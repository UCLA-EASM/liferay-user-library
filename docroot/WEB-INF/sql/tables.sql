create table Library_Document (
	documentId LONG not null primary key,
	originalURL VARCHAR(75) null,
	content VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);