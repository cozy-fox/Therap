-- Database Schema --
-- Assignment: Facebook --
-- Sanjay Saha --
-- 27 April 2014 --

create table account(
	account_id int not null auto_increment,
	account_uname varchar(255) not null,
	account_upass varchar(255) not null,
	account_country varchar(3) not null,
	account_fullname varchar(255) not null,

	primary key (account_id),
	unique (account_uname)
)engine=innoDB;
insert into account values('', 'sanjay', 'sanjay', 'BD', 'Sanjay Saha');
insert into account values('', 'rashed', 'rashed', 'BD', 'Rashedul Hasan');
insert into account values('', 'imran', 'imran', 'BD', 'Imran Bin Azad');
insert into account values('', 'safat', 'safat', 'BD', 'Shakhawat Hossain');
insert into account values('', 'sujan', 'sujan', 'BD', 'Sujan Sarker');


create table global_post_type(
	post_type_id int not null auto_increment,
	post_type_name varchar(255) not null,

	primary key (post_type_id)
)engine=innoDB;
insert into global_post_type values ('', 'wallpost');
insert into global_post_type values ('', 'photo');
insert into global_post_type values ('', 'video');
insert into global_post_type values ('', 'album');


create table global_privacy(
	privacy_id int not null auto_increment,
	privacy_name varchar(255) not null,
	privacy_detail text not null,
	primary key (privacy_id)
)engine=innoDB;
insert into global_privacy values('', 'public', 'All Over Facebook');
insert into global_privacy values('', 'friends', 'All My Friends');
insert into global_privacy values('', 'onlyme', 'Only Me');


create table personal_info(
	account_id int not null,
	personal_dob date not null,
	personal_relationship_status int(3),
	personal_interested_in int(3),
	personal_about_me text,

	primary key (account_id),
	foreign key (account_id) references account(account_id)
)engine=innoDB;
insert into personal_info values (1, NOW(), 1, 1, 'About me: Sanjay');
insert into personal_info values (2, NOW(), 1, 1, 'About me: Rijul');
insert into personal_info values (3, NOW(), 1, 1, 'About me: Imran');
insert into personal_info values (4, NOW(), 1, 1, 'About me: Safat');
insert into personal_info values (5, NOW(), 1, 1, 'About me: Sujan');

create table post(
	post_id int not null auto_increment,
	post_to int not null,
	post_parent int,
	post_type int(3) not null,
	post_time datetime not null,	
	post_text text,
	post_privacy int(3) not null default 1,

	primary key (post_id),
	foreign key (post_to) references account(account_id),
	foreign key (post_type) references global_post_type(post_type_id),
	foreign key (post_privacy) references global_privacy(privacy_id),
	unique(post_id)
)engine=innoDB;

create table post_comments_likes(
	comment_like_id   int not null auto_increment,
	post_id int not null,
	comment_like_type int(2) not null,
	comment_like_to   int not null,
	comment_like_text text,
	comment_like_user int not null,
	comment_like_time datetime not null,

	primary key (comment_like_id),
	foreign key (post_id) references post(post_id),
	foreign key (comment_like_user) references account(account_id)
)engine=innodb;

create table friendlist(
	id1 int not null,
	id2 int not null,
	friends_from datetime not null,

	foreign key (id1) references account(account_id),
	foreign key (id2) references account(account_id)
)engine=innoDB;
