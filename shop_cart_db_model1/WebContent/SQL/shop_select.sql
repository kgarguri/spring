select c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_price 
		from cart2 c join user2 u 
		on c.userid = u.userid join product2 p on c.p_no=p.p_no where u.userid='guard1';