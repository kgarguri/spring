--guard1 멤버한사람의  카트에 제품존재여부
select count(*) as p_count 
from cart2 c join user2 u on c.userid = u.userid 
join product2 p on c.p_no=p.p_no 
where u.userid='guard1' and c.p_no=1;

--guard1 멤버한사람의 카트아이템리스트
select c.cart_itemno, c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_image,p.p_price 
		from cart2 c join user2 u 
		on c.userid = u.userid join product2 p on c.p_no=p.p_no where u.userid='guard1';
--guard1 멤버한사람의  카트아이템 1개의 제품정보
select * from cart2 c join product2 p on c.p_no=p.p_no where c.cart_itemno=1; 
--guard1 멤버한사람의 카트정보출력(제품정보)
select p.*,c.* from cart2 c join product2 p on c.p_no=p.p_no where c.cart_itemno=1; 	
		
--guard1 카트에 있는 제품 수량증가
update cart2 set cart_qty=cart_qty + 1 
		where userid='guard1' and p_no=1;	
	
--guard1님 카트아이템1개삭제
delete from cart2 where cart_itemno = 3;

--guard1님 카트아이템모두삭제
delete from cart2 c where c.userid='guard1';


 --1. 멤버 한사람의 특정날짜의 주문전체목록
 select j.* from 
 user2 u join jumun2 j
 on u.userid = j.userid and u.userid='guard1';
 
--2. 멤버 한사람의 특정날짜의 주문한개 
  select j.* from 
 user2 u join jumun2 j
 on u.userid = j.userid and u.userid='guard1' and to_char(j.j_date,'YYYY/MM/DD')>='2020/09/02' and j_no=1 ;

--3. 주문한개의  주문상세 정보들(주문상세)
select jd.*,j.* from jumun2 j 
join jumun_detail2 jd 
on j.j_no=jd.j_no
where j.userid='guard1' and j.j_no=1; 
 
-- 4. 주문한개의  주문상세와제품 정보들(주문상세,제품)
select p.* from jumun2 j 
join jumun_detail2 jd 
on j.j_no=jd.j_no
join product2 p
on jd.p_no=p.p_no
where j.userid='guard1' and j.j_no=1;

-- 4. 주문한개의 내역삭제
delete from jumun_detail2 where j_no=6;
delete from jumun2 where j_no=6;


commit;







		