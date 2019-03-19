
create table ADDR_LOG
(
  PERSON_NAME VARCHAR(50) not null,
	TM TIMESTAMP(7) not null,
	LINE1 VARCHAR(40),
	LINE2 VARCHAR(40),
	ZIP VARCHAR(10),
	COUNTRY VARCHAR(3),
  constraint PK_ADDR_LOG
    primary key (PERSON_NAME, tm)
);;


create procedure LAST_UPDATED_ENTRY_BY_NAME(in IN_PERSON_NAME varchar(50), OUT CUR cursor)
  language sql
  dynamic result sets 1

begin
  declare CUR cursor for
    select distinct PERSON_NAME, TM, LINE1, LINE1, ZIP, COUNTRY
    from ADDR_LOG
    where PERSON_NAME = in_person_name
    and TM = (select MAX(TM) from ADDR_LOG where PERSON_NAME = PERSON_NAME);
  open CUR;
  return;
end;;


