-- create schema DB2INST1;;

-- create database test;;

create table ADDR_LOG
(
	TM TIMESTAMP(7) not null,
	PERSON_NAME VARCHAR(50) not null,
	LINE1 VARCHAR(40),
	LINE2 VARCHAR(40),
	ZIP VARCHAR(10),
	COUNTRY VARCHAR(3),
  constraint PK_ADDR_LOG
    primary key (PERSON_NAME, tm)
);;

CREATE PROCEDURE FF(IN in_person_name varchar(50))
  LANGUAGE SQL
BEGIN
  DECLARE out_line1  varchar(40);
  DECLARE out_line2  varchar(40);
  DECLARE out_zip  varchar(10);
  DECLARE out_country  varchar(3);
  DECLARE not_found CONDITION FOR '02000';

  DECLARE C1 CURSOR FOR
    SELECT DISTINCT a.line1, a.line2,  a.zip, a.country
    FROM addr_log a
    WHERE a.person_name = in_person_name
    AND a.tm = (SELECT  max(tm) FROM addr_log WHERE addr_log.person_name = in_person_name);
  OPEN C1;
  RETURN;
END;;


call FF('sophie')
