create table personal_info_2(
	dob date not null,
	relationship_status int(3),
	interested_in int(3),
	about_me text,

	foreign key (relationship_status) references global_relation(relation_id),
	foreign key (interested_in) references global_interested_in(interested_in_id)
)engine=innoDB;
insert into personal_info_2 values ('1990-11-09', 1, 2, 'About Me: Rijul');

create table post_2(
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
insert into global_post values('', 2);
insert into post_2 values (2, 2, NULL, 1, NOW(), 'First Post by Rashedul Hasan');

insert into global_post values('', 2);
select @lastinsert := MAX(post_id) from global_post where post_user=2;
insert into post_2 values (@lastinsert, 2, NULL, 1, NOW(), 'Second Post by Rashedul Hasan');

create table friend_list_2(
	friend_id int not null,
	friend_add_date datetime not null,

	foreign key (friend_id) references profile(id)
)engine=innoDB;
insert into friend_list_2 values (1, NOW());
insert into friend_list_2 values (3, NOW());


/*tmp*/
select * from friend_list_1 and friend_list_2;