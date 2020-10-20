select c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_price 
		from cart1 c join user1 u 
		on c.userid = u.userid join product1 p on c.p_no=p.p_no 
		where u.userid='guard1';
select c.p_no
		from cart1 c join user1 u 
		on c.userid = u.userid join product1 p on c.p_no=p.p_no 
		where u.userid='guard1';
select count(*) as p_count 
		from cart1 c join user1 u 
		on c.userid = u.userid join product1 p 
		on c.p_no=p.p_no 
		where u.userid='guard1' and c.p_no=4;
update cart1 set cart_qty=cart_qty + 1 
		where userid='guard1' and p_no=1;

	