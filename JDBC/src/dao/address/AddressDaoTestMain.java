package dao.address;

import java.util.ArrayList;
public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception{
		AddressDao addressDao=new AddressDaoImpl();
		System.out.println("-----------1.create-----------");
		int insertRowCount=
				addressDao.create(new Address("xxx", "김수미","234-9090", "CANADA"));
		System.out.println("create:"+insertRowCount);
		
		System.out.println("-----------2.update-----------------");
		Address updateAddress=new Address(2, "uuu", "변경이름", "900-0000", "주소변경");
		int updateRowCount=
				addressDao.update(updateAddress);
		System.out.println("update:"+updateRowCount);
		System.out.println("------------3.delete---------------------");
		System.out.println("delete:"+addressDao.delete(44));
		System.out.println("------------4.selectByNo----------------");
		Address findAddress=addressDao.selectByNo(45);
		System.out.println(findAddress);
		System.out.println("------------5.selectAll--------------------");
		ArrayList<Address> findAddressList=addressDao.selectAll();
		System.out.println(findAddressList);
		
	}

}
