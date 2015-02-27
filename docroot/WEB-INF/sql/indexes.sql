create index IX_745305E5 on Library_Document (groupId);
create index IX_D5AB339F on Library_Document (userId);
create index IX_B1BB58EA on Library_Document (userId, companyId, groupId, createDate, modifiedDate);