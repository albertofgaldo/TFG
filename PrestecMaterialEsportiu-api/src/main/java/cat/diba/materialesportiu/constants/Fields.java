package cat.diba.materialesportiu.constants;

public class Fields {
	// Common
	public static final String NAME = "name";
	public static final String CREATEDATE = "createDate";
	public static final String MODIFIEDDATE = "modifiedDate";

	// LocalEntity
	public static final String LOCALENTITYID = "localEntityId";
	public static final String CIF = "cif";
	public static final String TELEPHONE = "telephone";
	public static final String EMAIL = "email";

	// Activity
	public static final String ACTIVITYID = "activityId";
	public static final String DESCRIPTION = "description";
	public static final String AGE = "age";
	public static final String MINPARTICIPANTS = "minParticipants";
	public static final String MAXPARTICIPANTS = "maxParticipants";
	public static final String USAGERULES = "usageRules";
	public static final String LOANCONDITIONS = "loanConditions";
	public static final String TOTAL_STOCK = "totalStock";
	public static final String AVAILABLE_STOCK = "availableStock";
	public static final String DAYSBEFORELOAN = "daysBeforeLoan";
	public static final String DAYSBOOKING = "daysBooking";
	public static final String DAYSAFTERLOAN = "daysAfterLoan";
	public static final String TITULATIONISREQUIRED = "titulationIsRequired";

	// Material
	public static final String MATERIALID = "materialId";	
	public static final String VOLUME = "volume";
	public static final String HEIGH = "heigh";
	public static final String WIDTH = "width";
	public static final String LONGITUDE = "longitude";
	public static final String WEIGHT = "weight";

	// Material-Activity & Loan-Material
	public static final String ACTIVITYDEPENDSONID = "activityDependsOnId";
	public static final String LOANACTIVITYID = "loanActivityId";
	public static final String QUANTITY = "quantity";

	// Maintenance
	public static final String MAINTENANCEID = "maintenanceId";
	public static final String LABEL = "label";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	public static final String ISDONE = "isDone";

	// Loan
	public static final String LOANID = "loanId";
	public static final String PICKUP_DATE = "pickupDate";
	public static final String RETURN_DATE = "returnDate";
	public static final String ACTIVITY_DATE = "activityDate";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String PARTICIPANTS = "participantsNum";
	public static final String PARTICIPANTS_KIDS = "participantsKidsNum";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String POSITION_PERSON = "positionPerson";
	public static final String PMT = "pmt";
	public static final String STATUS = "status";	
	public enum LoanStatus{
		NOTCONFIRMED, EXPIRED, CONFIRMED, BORROWED, MAINTENANCE, RETURNED
	}

	// Default values
	// Activity
	public static final int DEFAULT_AGE = 5;
	public static final int DEFAULT_MIN_PARTICIPANTS = 1;
	public static final int DEFAULT_MAX_PARTICIPANTS = 100;
	// Material-Activity
	public static final int DEFAULT_QUANTITY = 1;
	// Material
	public static final int DEFAULT_STOCK = 0;
	public static final int DEFAULT_DAYS_BEFORE_LOAN = 1;
	public static final int DEFAULT_DAYS_BOOKING = 5;
	public static final int DEFAULT_DAYS_AFTER_LOAN = 3;
	public static final float DEFAULT_HEIGH = 0;
	public static final float DEFAULT_WIDTH = 0;
	public static final float DEFAULT_LONGITUDE = 0;
	public static final float DEFAULT_WEIGHT = 0;
	public static final int DEFAULT_PARTICIPANTS = 0;
	public static final int DEFAULT_PARTICIPANTS_KIDS = 0;
	// Loan
	public static final int DEFAULT_DAYS_CALENDAR_ACTIVITY = 1;
	public static final int DEFAULT_DAYS_CALENDAR_RETURN = 7;
	public static final int DEFAULT_LAST_DAY_LOAN_PERMIT = 90;
	public static final int DEFAULT_DAYS_PICKUP = -4;

	// Magnitudes
	public static final String CENTIMETERS = " cm";
	public static final String KILOGRAMS = " kg";
	public static final String DAYS = " dies";

}
