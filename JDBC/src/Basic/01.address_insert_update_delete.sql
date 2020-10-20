
//delete from address;

insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시');
insert into address values(address_no_seq.nextval,'abcdf','박경호','123-4568','경기도 구리시');
insert into address values(address_no_seq.nextval,'starts','최경호','123-4568','경기도 포천시');
insert into address values(address_no_seq.nextval,'beauty','구경호','123-4568','경기도 이천시');
insert into address values(address_no_seq.nextval,'bishop','정경호','123-4568','경기도 군포시');
insert into address values(address_no_seq.nextval,'xyzzx','이경호','123-4568','경기도 안양시');
insert into address values(address_no_seq.nextval,'yyyyy','주경호','123-4568','경기도 안산시');
insert into address values(address_no_seq.nextval,'super','양경호','123-4568','경기도 인천시');
insert into address values(address_no_seq.nextval,'strong','인경호','123-4568','경기도 시흥시');

update address set id='***', name='김경호',phone='888-0000', ADDRESS='서울시 강남구'
where no = 1;

delete from ADDRESS where no = 1;
insert into address values(address_no_seq.nextval,'bbbbb','광화문','222-2222','서울시 노원구')
commit;

select * from address;



commit;