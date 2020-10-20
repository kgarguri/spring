select name from student;
select name from student where stud_id = 1;


select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      inner join addresses a 
      on s.addr_id=a.addr_id;
      
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      left outer join addresses a 
      on s.addr_id=a.addr_id;
       
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      right outer join addresses a 
      on s.addr_id=a.addr_id;   
      
      
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      full outer join addresses a 
      on s.addr_id=a.addr_id;     
--findStudentByIdWithAddress--
/*
* student + address join
*/
select stud_id, name, email, dob, phone, a.addr_id, street, city, state, zip, country
	  		FROM students s 
	      left outer join addresses a 
	      on s.addr_id=a.addr_id
	      where s.stud_id=1;
/*
* student + courses join
*/
select  s.stud_id,s.name  ,s.email,s.phone,s.dob ,
        c.course_id,c.name  ,c.description,c.start_date,c.end_date
		from students s 
		join course_enrollment ce
		on s.stud_id = ce.stud_id
		join courses c
		on ce.course_id=c.course_id where s.stud_id=1;
/*
* tutors + courses join
*/
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      join courses c 
      on t.tutor_id=c.tutor_id; 
/*
* tutors + courses outer join
*/      
      
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id;
        
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id
      where t.tutor_id=1;  
 /*
* tutors + addresses + courses outer join
*/     
SELECT t.tutor_id, t.name as tutor_name, email, a.addr_id, street, city, state, zip, country,
       			course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join addresses a 
      on t.addr_id=a.addr_id
	  left outer join courses c on t.tutor_id=c.tutor_id
      where t.tutor_id=1;   
      
-- Courses검색      
SELECT * FROM COURSES
WHERE TUTOR_ID = 1
AND NAME LIKE '%Quick%'
AND START_DATE >= TO_DATE('2015/05/01');
      
      
      
      
      
      
      
      