-- Author jefersson serrano

drop database IF EXISTS  centauri_academy_3_stage;
create database centauri_academy_3_stage;
CREATE USER 'centauri_academy_3_stage'@'%' IDENTIFIED BY 'centauri_academy_3_stage';
GRANT ALL PRIVILEGES ON centauri_academy_3_stage.* TO 'centauri_academy_3_stage'@'%'  WITH GRANT OPTION;
FLUSH PRIVILEGES;


drop database IF EXISTS  centauri_academy_3_test;
create database centauri_academy_3_test;
CREATE USER 'centauri_academy_3_test'@'%' IDENTIFIED BY 'centauri_academy_3_test';
GRANT ALL PRIVILEGES ON centauri_academy_3_test.* TO 'centauri_academy_3_test'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;


drop database IF EXISTS  centauri_academy_3_dev;
create database centauri_academy_3_dev;
CREATE USER 'centauri_academy_3_dev'@'%' IDENTIFIED BY 'centauri_academy_3_dev';
GRANT ALL PRIVILEGES ON centauri_academy_3_dev.* TO 'centauri_academy_3_dev'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

--create database centauri_academy_3_stage;
--GRANT ALL PRIVILEGES ON centauri_academy_3_stage.* TO 'centauri_academy_3_stage'@'%' IDENTIFIED BY 'centauri_academy_3_stage' WITH GRANT OPTION;
--FLUSH PRIVILEGES;

--create database centauri_academy_3_test;
--GRANT ALL PRIVILEGES ON centauri_academy_3_test.* TO 'centauri_academy_3_test'@'%' IDENTIFIED BY 'centauri_academy_3_test' WITH GRANT OPTION;
--FLUSH PRIVILEGES;

--create database centauri_academy_3_dev;
--GRANT ALL PRIVILEGES ON centauri_academy_3_dev.* TO 'centauri_academy_3_dev'@'%' IDENTIFIED BY 'centauri_academy_3_dev' WITH GRANT OPTION;
--FLUSH PRIVILEGES;



