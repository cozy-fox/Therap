CREATE TABLE user (
	id int AUTO_INCREMENT,
	uname varchar(15) NOT NULL,
	upass varchar(255) NOT NULL,
	utype int NOT NULL DEFAULT 0,

	PRIMARY KEY id
)engine=innoDB;