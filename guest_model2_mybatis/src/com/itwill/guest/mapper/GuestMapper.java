package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;

public interface GuestMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치
	 */
	public List<Guest> selectAll();
	/*
	 <select id="selectAll" resultType="com.itwill.guest.Guest">
		SELECT * FROM GUEST
	</select>
	*/
	public Guest selectByNo(Integer guest_no);
	
	public int insertGuest(Guest guest);
	
	public int deleteGuest(int no);
	
	public int updateGuest(Guest guest);
	/*
	<select id="selectByNo" 
			parameterType="java.lang.Integer" 
			resultType="com.itwill.guest.Guest">
		SELECT * FROM GUEST
		WHERE guest_no=#{guest_no}
	</select>
	<insert id="insertGuest" parameterType="com.itwill.guest.Guest">
		<selectKey resultType="java.lang.Integer"
			keyProperty="guest_no" order="BEFORE">
			SELECT guest_no_seq.nextval FROM DUAL
		</selectKey>
		insert into guest 
		values( #{guest_no},#{guest_name},
		 		sysdate,#{guest_email},
		 		#{guest_homepage},#{guest_title},
		 		#{guest_content})
	</insert>
	<delete id="deleteGuest" parameterType="java.lang.Integer">
		delete from guest where guest_no = #{guest_no}
	</delete>
	<update id="updateGuest" parameterType="com.itwill.guest.Guest">
		update guest set  guest_name=#{guest_name}, guest_email=#{guest_email},
		                  guest_homepage=#{guest_homepage}, guest_title=#{guest_title}, 
		                  guest_content=#{guest_content} 
		where guest_no = #{guest_no}
	</update>
	 */
}
