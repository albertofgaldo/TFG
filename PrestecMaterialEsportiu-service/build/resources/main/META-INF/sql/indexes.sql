create index IX_7FD4A5ED on PME_Activity (availableStock);
create index IX_AEC2996E on PME_Activity (companyId, groupId);

create index IX_4849EDCC on PME_ActivityDependsOn (activityId, parentActivityId);
create index IX_AB261108 on PME_ActivityDependsOn (companyId, groupId);
create index IX_1939FDCE on PME_ActivityDependsOn (parentActivityId);

create index IX_347EA00F on PME_Loan (companyId, groupId);
create index IX_2C06B0B1 on PME_Loan (status[$COLUMN_LENGTH:75$], pickupDate);
create index IX_49F40C65 on PME_Loan (status[$COLUMN_LENGTH:75$], returnDate);

create index IX_A413EDFA on PME_LoanActivity (activityId);
create index IX_629A22FE on PME_LoanActivity (companyId, groupId);
create index IX_7BC87259 on PME_LoanActivity (loanId, activityId);

create index IX_EB3D07D3 on PME_LocalEntity (cif[$COLUMN_LENGTH:75$]);
create index IX_B31D823F on PME_LocalEntity (companyId, groupId);
create index IX_8EBC933C on PME_LocalEntity (name[$COLUMN_LENGTH:75$]);

create index IX_E7183344 on PME_Maintenance (activityId, label[$COLUMN_LENGTH:75$]);
create index IX_93011864 on PME_Maintenance (companyId, groupId);
create index IX_47AD18FF on PME_Maintenance (loanId, activityId, isDone);
create index IX_8BB6E401 on PME_Maintenance (loanId, isDone);

create index IX_1BBBC82 on PME_Material (activityId);
create index IX_246FD04 on PME_Material (companyId, groupId, activityId);