package cat.diba.materialesportiu.internal.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import cat.diba.materialesportiu.service.LoanLocalServiceUtil;
//1día->cron.expression=0 0 0 * * ?
//1hora->cron.expression=0 0 * ? * *
//3min->cron.expression=0 */3 * ? * *
//1día a las 2am->cron.expression=0 0 2 * * ?
@Component(immediate = true, property = { "cron.expression=0 */3 * ? * *" }, // Scheduler run daily at 0AM
		service = SampleScheduler.class)
public class SampleScheduler extends BaseMessageListener {

	private static Log log = LogFactoryUtil.getLog(SampleScheduler.class);

	@Override
	protected void doReceive(Message message) throws Exception {		
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());		
		
		//Actualizamos las posibles reservas expiradas
		LoanLocalServiceUtil.checkExpiredLoans();		
				
		//Actualizamos availableStock para material que salió ayer
		//Actualizamos estado Confirmed to Borrowed
		LoanLocalServiceUtil.updateStatusConfirmedToBorrowed(today.getTime());
		
		//Añadimos material que haya vuelto de Borrowed a Maintenance
		//Actualizamos estado Borrowed to Maintenance
		LoanLocalServiceUtil.updateStatusBorrowedToMaintenance(today);
		
		//Actualizamos stockAvailable de Maintenance isDonde
		//Actualizamos estado Maintenance to Returned cuando todo el Maintenance isDone
		LoanLocalServiceUtil.updateStatusMaintenanceToReturned(today.getTime());		
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		
		try {
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
			log.info(" cronExpression: " + cronExpression);

			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null,
					cronExpression);

			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);
			SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

		} catch (Exception e) {
			log.error(e);
		}
	}

	@Deactivate
	protected void deactive() {
		SchedulerEngineHelperUtil.unregister(this);
	}

}
