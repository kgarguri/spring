package com.itwill.shop.jumun;

import java.util.ArrayList;

import com.itwill.shop.cart.CartDao;
import com.itwill.shop.cart.CartItemDto;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class JumunService {
	private JumunDao jumunDao;
	private JumunDetailDao jumunDetailDao;
	private CartDao cartDao;
	private ProductDao productDao;
	
	public JumunService() throws Exception{
		jumunDao=new JumunDao();
		jumunDetailDao=new JumunDetailDao();
		cartDao=new CartDao();
		productDao=new ProductDao();
	}
	/*
	 * 주문삭제
	 */
	public int delete(int j_no) throws Exception {
		/*
		  delete from jumun_detail2 where j_no=6;
		  delete from jumun2 where j_no=6;
		 * 
		 */
		int rowcount1=jumunDetailDao.delete(j_no);
		int rowcount2=jumunDao.delete(j_no);
		return rowcount2;
	}
	
	
	/*
	 * 주문목록
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		ArrayList<Jumun> jumunList=jumunDao.list(sUserId);
		return jumunList;
	}
	/*
	 * 주문과 주문상세
	 */
	
	public Jumun detail(String sUserId,int j_no) throws Exception{
		Jumun jumun=jumunDao.detail(sUserId, j_no);
		ArrayList<JumunDetail> jumunDetailList =jumunDetailDao.list(sUserId,j_no);
		
		jumun.setJumunDetailList(jumunDetailList);
		
		return jumun; 
	}
	/*
	 *  cart에서 주문생성
	 */
	public void create(String sUserId) throws Exception{

			ArrayList<CartItemDto> cartItemList = cartDao.getCartItemList(sUserId);

			int j_price=0;
			for (CartItemDto cartItemDto : cartItemList) {
				j_price+=cartItemDto.getCart_tot_price();
			}
			Jumun jumun=new Jumun();
			jumun.setJ_desc(cartItemList.get(0).getP_name()+"외 "+ (cartItemList.size()-1)+" 종");
			jumun.setUserId(sUserId);
			jumun.setJ_price(j_price);
			
			int jumun_no=jumunDao.create(sUserId,jumun);
			
			for (CartItemDto cartItemDto : cartItemList) {
				JumunDetail jumunDetail=new JumunDetail();
				jumunDetail.setJd_qty(cartItemDto.getCart_qty());
				jumunDetail.setJ_no(jumun_no);
				jumunDetail.setJd_pname(cartItemDto.getP_name());
				jumunDetail.setP_no(cartItemDto.getP_no());
				jumunDetail.setJd_tot_price(cartItemDto.getCart_tot_price());
				
				jumunDetailDao.create(sUserId, jumunDetail);
			}
			
			cartDao.deleteCart(sUserId);
	}
	/*
	 * 상품에서직접주문생성
	 */
	public void create(String sUserId,Jumun jumun,int p_no,int jd_qty) throws Exception{
		Product product=productDao.getProduct(p_no);
		
		int j_no=jumunDao.create(sUserId,jumun);
		
		JumunDetail jumunDetail=new JumunDetail();
		jumunDetail.setJd_qty(jd_qty);
		jumunDetail.setJ_no(j_no);
		jumunDetail.setJd_pname(product.getP_name());
		jumunDetail.setP_no(product.getP_no());
		jumunDetail.setJd_tot_price(product.getP_price()*jd_qty);
		
		jumunDetailDao.create(sUserId, jumunDetail);
	}
	
}
