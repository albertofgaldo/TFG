create table PME_Activity (
	activityId LONG not null primary key,
	name STRING null,
	description STRING null,
	age INTEGER,
	minParticipants INTEGER,
	maxParticipants INTEGER,
	usageRules STRING null,
	loanConditions STRING null,
	titulationIsRequired BOOLEAN,
	totalStock INTEGER,
	availableStock INTEGER,
	daysBeforeLoan INTEGER,
	daysBooking INTEGER,
	daysAfterLoan INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_ActivityDependsOn (
	activityDependsOnId LONG not null primary key,
	activityId LONG,
	parentActivityId LONG,
	quantity INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_Loan (
	loanId LONG not null primary key,
	localEntityId LONG,
	pickupDate DATE null,
	returnDate DATE null,
	activityDate DATE null,
	activityName VARCHAR(75) null,
	participantsNum INTEGER,
	participantsKidsNum INTEGER,
	description VARCHAR(75) null,
	contactPerson VARCHAR(75) null,
	positionPerson VARCHAR(75) null,
	telephone VARCHAR(75) null,
	email VARCHAR(75) null,
	pmt VARCHAR(75) null,
	status VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_LoanActivity (
	loanActivityId LONG not null primary key,
	loanId LONG,
	activityId LONG,
	quantity INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_LocalEntity (
	localEntityId LONG not null primary key,
	cif VARCHAR(75) null,
	name VARCHAR(75) null,
	telephone VARCHAR(75) null,
	email VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_Maintenance (
	maintenanceId LONG not null primary key,
	activityId LONG,
	label VARCHAR(75) null,
	description VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	isDone BOOLEAN,
	loanId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PME_Material (
	materialId LONG not null primary key,
	name STRING null,
	heigh DOUBLE,
	width DOUBLE,
	longitude DOUBLE,
	weight DOUBLE,
	activityId LONG,
	quantity INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);