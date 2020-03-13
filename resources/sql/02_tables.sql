drop table if exists news_letter_message_group_mapping; --jefersson serrano
drop table if exists news_letter_message; --jefersson serrano
drop table if exists interviewreplies;
drop table if exists surveyinterviews;
drop table if exists interviews; 
drop table if exists origin_sites;
drop table if exists course_resume;
drop table if exists note_template;
drop table if exists surveyquestions; --fabio
drop table if exists surveyreplies; --marcof
drop table if exists usersurveytoken; --traian
drop table if exists surveys; --alessandra
drop table if exists questions; --daniele
drop table if exists candidates; --giacomo
drop table if exists candidate_states;
drop table if exists coursepage; --traian
drop table if exists itconsultants; --maurizio
drop table if exists employees; --darioXXXXX
drop table if exists users; --ilaria
drop table if exists roles; --joffre


create table roles (
	id bigint NOT NULL AUTO_INCREMENT, 
	label VARCHAR(50),
	description VARCHAR(2000),
	level int,
	primary key(id),
	CONSTRAINT level UNIQUE (level)
);
insert into roles(id, label, description, level) VALUES (1, 'admin', 'administrator', 0);
insert into roles(id, label, description, level) VALUES (2, 'developer', 'developer', 10);
insert into roles(id, label, description, level) VALUES (3, 'permanent, external consultant', 'dipendente, attualmente impiegato in activita di consulenza esterna', 50);
insert into roles(id, label, description, level) VALUES (4, 'java course candidate', 'candidato a partecipare a corso java', 90);
insert into roles(id, label, description, level) VALUES (5, 'guest', 'guest', 100);

create table users (
	id bigint not null AUTO_INCREMENT, 
	email VARCHAR(100) not null,
	password VARCHAR(100),
	firstname VARCHAR(50) not null,
	lastname VARCHAR(50) not null,
	dateofbirth date,
	regdate datetime not null,
	role int not null,
	imgpath VARCHAR(255),
	note VARCHAR(2000),
	enabled boolean not null default false,
	primary key(id),
	CONSTRAINT uniqueEmail UNIQUE (email),
	foreign key (role) references roles(level)	
);

--insert into users (email,firstname,lastname, password, regdate, dateofbirth, role) VALUES ('1@2.3','bbb','aaa', 'NA==', '2018-11-01', '2018-11-01',10);

create table coursepage (
    id bigint primary key auto_increment,
    title varchar(1000) not null,
    code varchar(100) unique not null,
    body_text text(50000) not null,
    file_name varchar(300)
);
insert into coursepage(id, title, code, body_text) values (1, 'Candidatura generica', 'MIGEN01', 'Candidatura spontanea');
insert into coursepage(id, title, code, body_text) values (2, 'Candidatura corso FullStackWeb+Java 01 Milano', 'MICEACFS01', 'Candidatura partecipazione a I Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Gen18-Mar18');
insert into coursepage(id, title, code, body_text) values (3, 'Candidatura corso FullStackWeb+Java 02 Milano', 'MICEACFS02', 'Candidatura partecipazione a II Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Apr18-Giu18');
insert into coursepage(id, title, code, body_text) values (4, 'Candidatura corso FullStackWeb+Java 03 Milano', 'MICEACFS03', 'Candidatura partecipazione a III Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Nov18-Gen19');
insert into coursepage(id, title, code, body_text) values (5, 'Candidatura corso FullStackWeb+Java 04 Milano', 'MICEACFS04', 'Candidatura partecipazione a IV Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Mar19-Mag19');
insert into coursepage(id, title, code, body_text) values (6, 'Candidatura corso FullStackWeb+Java 05 Milano', 'MICEACFS05', 'Candidatura partecipazione a V Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Set19-Dic19');

create table candidate_states (
    id bigint primary key auto_increment,
    role_id bigint not null,
    status_code int not null,
    status_label varchar(300),
    status_description varchar(1000),
    status_color varchar(7) NOT NULL,
    foreign key (role_id) references roles(id)
);

insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (1,4,1, 'DA VALUTARE','entry appena effettuata. Stato: DA VALUTARE - DEFAULT','#f60000');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (2,4,2, 'ha rinunciato','Ha rinunciato di sua scelta al corso','#f98742');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (3,4,3, 'inadeguato standing/comportamentale','Scartato per inadeguatezza in termini di standing o criticità comportamentali','#f9c842');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (4,4,4, 'inadeguato backround','Scartato per inadeguatezza del suo backround','#f9ec14');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (5,4,5, 'da tenere in considerazione per corso formatemp','inadeguato backround/standing/altre criticità ma potrebbe rientrare in caso di formatemp','#0e81ec');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (6,4,6, 'background solo parzialmente adeguato, NON LAUREATO/NON LAUREANDO','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. NON LAUREATO/NON LAUREANDO','#2585de');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (7,4,7, 'background solo parzialmente adeguato, LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','#25ded3');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (8,4,8, 'OK. Background di prima scelta. NON LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#7af914');
insert into candidate_states(id, role_id, status_code, status_label, status_description, status_color) values (9,4,9, 'OK. Background di prima scelta. LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#63b81e');

create table candidates (
	id bigint not null AUTO_INCREMENT, 
	user_id bigint not null,
	domicile_city varchar(100),
--	domicile_street_name varchar(100),
--	domicile_house_number varchar(100),
	study_qualification varchar(300),
	graduate boolean,
	high_graduate boolean,
	still_high_study boolean,
	mobile varchar(20),
	cv_external_path varchar(1000),
	course_code varchar(100) not null,
	candidacy_date_time datetime not null,
	label VARCHAR(255),
	candidate_states_id bigint,
	primary key(id),	
	foreign key (user_id) references users(id),
	foreign key(course_code) references coursepage(code),
	foreign key(candidate_states_id) references candidate_states(id)
);

--insert into candidates(user_id, course_code, candidacy_date_time) values (1, 'MICEACFS04', now()); 

create table itconsultants (
	id bigint not null AUTO_INCREMENT, 
	user_id bigint not null,
	domicile_city varchar(100),
	domicile_street_name varchar(100),
	domicile_house_number varchar(100),
	study_qualification varchar(300),
	graduate boolean,
	high_graduate boolean,
	still_high_study boolean,
	mobile varchar(20),
	cv_external_path varchar(1000),
	primary key(id),	
	foreign key (user_id) references users(id)
);

create table employees (
	id bigint not null AUTO_INCREMENT, 
	user_id bigint not null,
	domicile_city varchar(100),
	domicile_street_name varchar(100),
	domicile_house_number varchar(100),	
	mobile varchar(20),
	cv_external_path varchar(1000),
	primary key(id),	
	foreign key (user_id) references users(id)
);



create table questions (
    id bigint primary key not null auto_increment,
    label varchar(500) not null,
    description varchar(3000),
    ansa VARCHAR(255),
	ansb VARCHAR(255),
	ansc VARCHAR(255),
	ansd VARCHAR(255),
	anse VARCHAR(255),
	ansf VARCHAR(255),
	ansg VARCHAR(255),
	ansh VARCHAR(255),
	cansa BIT,
	cansb BIT,
	cansc BIT,
	cansd BIT,
	canse BIT,
	cansf BIT,
	cansg BIT,
	cansh BIT,
	full_answer VARCHAR(3000)
);

create table surveys(
	id bigint primary key not null auto_increment,
	label VARCHAR(50) NOT NULL,
	time bigint,
	description VARCHAR(2000)
);

create table usersurveytoken (
	id bigint NOT NULL AUTO_INCREMENT, 
	userid bigint not null,
	surveyid bigint not null,
	generatedtoken VARCHAR(50),
	expirationdate datetime,
	expired boolean,
	primary key(id),
	CONSTRAINT uniqueToken UNIQUE (generatedtoken),
	foreign key (userid) references users(id),
	foreign key (surveyid) references surveys(id)
);

--insert into usersurveytoken (userid, surveyid, generatedtoken, expirationdate) VALUES (1, 1 , 'abcd1234', '2012-07-01 10:34:09');


create table surveyquestions (
    id bigint primary key auto_increment,
    survey_id bigint not null,
    question_id bigint not null,
    position int,
    foreign key (survey_id) references surveys(id),
    foreign key (question_id) references questions(id),
    CONSTRAINT UC_SurveyQuestion UNIQUE (survey_id,question_id)
    
);

create table surveyreplies(
	id bigint primary key not null auto_increment,
	survey_id bigint not null,
	user_id bigint not null,
	starttime datetime,
	endtime datetime,
	answers varchar(5000),
	pdffilename varchar(100),
	points varchar(50),
	foreign key(survey_id) references surveys(id),
	foreign key(user_id) references users(id)
);

create table note_template (
    id bigint primary key auto_increment,
    title varchar(100) unique not null,
    content varchar(2000) not null
);  

create table course_resume (
    id bigint primary key auto_increment,
    title varchar(100) unique not null,
    content varchar(2000) not null,
    code varchar(100) unique not null,
    foreign key(code) references coursepage(code)
);

create table origin_sites (
    id bigint primary key auto_increment,
    label varchar(100) unique not null,
    description varchar(2000),
    imgpath VARCHAR(255)
);  

create table interviews (
    id bigint primary key auto_increment,
  	question_text varchar(255),
    ansa VARCHAR(255),
	ansb VARCHAR(255),
	ansc VARCHAR(255),
	ansd VARCHAR(255),
	anse VARCHAR(255),
	ansf VARCHAR(255),
	ansg VARCHAR(255),
	ansh VARCHAR(255),
	ansi VARCHAR(255),
	ansj VARCHAR(255)
	
);

create table surveyinterviews (
    id bigint primary key auto_increment,
    survey_id bigint not null,
    interview_id bigint not null,
    position int,
    foreign key (survey_id) references surveys(id),
    foreign key (interview_id) references interviews(id),
    CONSTRAINT UC_SurveyInterview UNIQUE (survey_id,interview_id)
    
);

create table news_letter_message(
	id bigint primary key not null AUTO_INCREMENT, 
	message_subject VARCHAR(250) not null,
	message_text VARCHAR(2000) not null
);
--insert into news_letter_message(id, message_subject, message_text) VALUES (1, 'message_subject 1', 'messageText 1', );
/*
create table news_letter_message_group_mapping(
	id bigint not null AUTO_INCREMENT, 
	it_consultant_group_id bigint not null,
	news_letter_message_id bigint not null,
	foreign key (it_consultant_group_id) references it_consultant_group(id),
    foreign key (news_letter_message_id) references news_letter_message(id)
);
*/
--insert into news_letter_message_group_mapping(id,it_consultant_group_id,news_letter_message_id) values (1,1,1);

