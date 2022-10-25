create database if not exists moviedb;

use moviedb;

drop table if exists movie;
drop table if exists director;

create table director
(
 		director_id varchar(20) primary key,
 		director_name varchar(100),
 		director_age int,
 		director_winnerCount int default 0
);

create table movie
(
 		movie_id int primary key auto_increment,
 		movie_title varchar(200) ,
 		director_id varchar(20),
 		movie_year int,
		constraint movie_fk foreign key(director_id) references director(director_id)
        #on delete cascade
        #on update cascade
);


insert into director values('00001','박찬욱',48,30);
insert into director values('00002','김싸피',27,2);
insert into director values('00003','이안',57,22);
insert into director values('00004','로베르토베니니',59,32);
insert into director values('00005','스티븐스필버그',65,17);

insert into movie(movie_title,director_id,movie_year) values('박쥐','00001',2009);
insert into movie(movie_title,director_id,movie_year) values('올드보이','00001',2003);
insert into movie(movie_title,director_id,movie_year) values('슬기로운 싸피생활','00002',2022);
insert into movie(movie_title,director_id,movie_year) values('와호장룡','00003',2000);
insert into movie(movie_title,director_id,movie_year) values('인생은 아름다워','00004',1997);
insert into movie(movie_title,director_id,movie_year) values('인디아나 존스','00005',2008);
insert into movie(movie_title,director_id,movie_year) values('마이너리티 리포트','00005',2002);
insert into movie(movie_title,director_id,movie_year) values('에이 아이','00005',2001);
commit;

