create table profile(
	id int not null auto_increment,
	full_name varchar(255) not null,
	reg_date  datetime not null,
	uname varchar(255) not null,
	upass varchar(255) not null,
	primary key (id)
)engine=innoDB;
alter table add unique(uname);
insert into profile values ('', 'Sanjay Saha', NOW(), 'sanjaysaha', 'sanjaysaha');
insert into profile values ('', 'Rashedul Hasan', NOW(), 'rijul', 'rijul');
insert into profile values ('', 'Imran Bin Azad', NOW(), 'imran', 'imran');
insert into profile values ('', 'Shakhawat Hossain', NOW(), 'safat', 'safat');
insert into profile values ('', 'Sujan Sarker', NOW(), 'sujon', 'sujon');
insert into profile values ('', 'Rifatul Islam', NOW(), 'shovon', 'shovon');
insert into profile values ('', 'Abdullah Al Hafiz', NOW(), 'hafiz', 'hafiz');

create table global_privacy(
	privacy_id int not null auto_increment,
	privacy_name varchar(255) not null,
	privacy_detail text not null,
	primary key (privacy_id)
)engine=innoDB;
insert into global_privacy values('', 'public', 'All Over Facebook');
insert into global_privacy values('', 'friends', 'All My Friends');
insert into global_privacy values('', 'onlyme', 'Only Me');


create table global_relation(
	relation_id int not null auto_increment,
	relation_name varchar(255) not null,
	relation_detail text not null,
	primary key (relation_id)
)engine=innoDB;
insert into global_relation values('','single','Single');
insert into global_relation values('','inrelateion','In a relationship');
insert into global_relation values('','married','Married');

create table global_interested_in(
	interested_in_id int not null auto_increment,
	interested_in_name varchar(255) not null,
	primary key (interested_in_id)
)engine=innoDB;
insert into global_interested_in values ('','Men');
insert into global_interested_in values ('','Women');
insert into global_interested_in values ('','Both');

create table global_post(
	post_id int not null auto_increment,
	post_user int not null,

	primary key (post_id),
	foreign key (post_user) references profile(id)
)engine=innoDB;

create table global_post_type(
	post_type_id int not null auto_increment,
	post_type_name varchar(255) not null,

	primary key (post_type_id)
)engine=innoDB;
insert into global_post_type values ('', 'wallpost');
insert into global_post_type values ('', 'photo');
insert into global_post_type values ('', 'video');
insert into global_post_type values ('', 'album');


/**
* TABLES for EACH USER:
* 1) personal_info_<id>
* 2) post_<id>
* 3) friend_list_<id>
* 4) activity_<id>
*/
create table personal_info_1(
	dob date not null,
	relationship_status int(3),
	interested_in int(3),
	about_me text,

	foreign key (relationship_status) references global_relation(relation_id),
	foreign key (interested_in) references global_interested_in(interested_in_id)
)engine=innoDB;
insert into personal_info_1 values ('1991-11-13', 1, 2, 'About Me: Sanjay');

create table post_1(
	post_id int not null,
	post_to int not null,
	post_parent int,
	post_type int(3) not null,
	post_time datetime not null,	
	post_text text,
	post_privacy int(3) not null default 1,


	foreign key (post_id) references global_post(post_id),
	foreign key (post_parent) references global_post(post_id),
	foreign key (post_to) references profile(id),
	foreign key (post_type) references global_post_type(post_type_id),
	foreign key (post_privacy) references global_privacy(privacy_id),
	unique(post_id)
)engine=innoDB;
insert into global_post values('', 1);
insert into post_1 values (1, 1, , 1, NOW(), 'First Post by Sanjay Saha', );


create table friend_list_1(
	friend_id int not null,
	friend_add_date datetime not null,

	foreign key (friend_id) references profile(id)
)engine=innoDB;
insert into friend_list_1 values (2, NOW());
insert into friend_list_1 values (3, NOW());




/**
* TABLE for EACH POST
* post_comments_likes_<post_id>
*/
create table post_comments_likes_1(
	comment_like_id   int not null auto_increment,
	comment_like_type int(2) not null,
	comment_like_to   int not null,
	comment_like_text text,
	comment_like_user int not null,
	comment_like_time datetime not null,

	primary key (comment_like_id),
	foreign key (comment_like_user) references profile(id)
)engine=innodb;
insert into post_comments_likes_1 values ('', 1, 0, 'Nice Post', 4, NOW());
insert into post_comments_likes_1 values ('', 1, 0, 'Test comment two', 5, NOW());
insert into post_comments_likes_1 values ('', 1, 0, 'Third Test comment', 6, NOW());
insert into post_comments_likes_1 values ('', 2, 0, NULL, 5, NOW());
insert into post_comments_likes_1 values ('', 2, 0, NULL, 3, NOW());
insert into post_comments_likes_1 values ('', 2, 2, NULL, 2, NOW());
insert into post_comments_likes_1 values ('', 2, 2, NULL, 4, NOW());
