create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table image (id bigint not null, ms1 varchar(255) not null, ms2 varchar(255) not null, name varchar(255) not null, path varchar(255) not null, primary key (id)) engine=MyISAM;
