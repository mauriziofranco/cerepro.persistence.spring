alter table users drop column dateofbirth;
alter table users drop column imgpath;
alter table users drop column note;

drop table itconsultants ;

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
select c.id, u.surveyid, u.generatedtoken, u.expirationdate, u.expired from usersurveytoken u, candidates c where u.userid=c.user_id 

