--update candidates set technical_note = null ;
--update candidates set candidate_state_code = 100 ;

alter table users drop column dateofbirth;
alter table users drop column imgpath;
alter table users drop column note;

drop table itconsultants ;

drop table if exists candidatesurveytokens ;

create table candidatesurveytokens (
	id bigint NOT NULL AUTO_INCREMENT, 
	candidate_id bigint not null,
	survey_id bigint not null,
	generated_token VARCHAR(50),
	expiration_date_time datetime,
	expired boolean DEFAULT false,
	primary key(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token),
	foreign key (candidate_id) references candidates(id),
	foreign key (survey_id) references surveys(id)
);

INSERT INTO candidatesurveytokens (candidate_id, survey_id, generated_token, expiration_date_time, expired)
select c.id, u.surveyid, u.generatedtoken, u.expirationdate, u.expired from usersurveytoken u, candidates c where u.userid=c.user_id ;

update  roles set label="technical recruiter", description="technical recruiter" where id = 2;
update  roles set label="hr", description="human resources" where id = 3;
update  roles set label="account", description="business account" where id = 4;


drop table if exists interviewreplies;
drop table if exists surveyinterviews;
drop table if exists interviews; 
drop table if exists employees;

alter table surveyreplies add column candidate_id bigint(20) NOT NULL ;

UPDATE surveyreplies
INNER JOIN candidates ON surveyreplies.user_id=candidates.user_id
SET surveyreplies.candidate_id = candidates.id ;

alter table surveyreplies DROP FOREIGN KEY surveyreplies_ibfk_2;
alter table surveyreplies drop column user_id;

alter table surveyreplies ADD FOREIGN KEY (candidate_id) references candidates(id);

alter table candidates DROP FOREIGN KEY candidates_ibfk_1;
alter table candidates drop column user_id;

drop table if exists usersurveytoken;







