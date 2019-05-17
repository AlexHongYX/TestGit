package com.dao;



import com.model.Member;
import com.tools.ChStr;
import com.tools.ConnDB;

public class MemberDaoImpl implements MemberDao {
	ConnDB conn = new ConnDB();
	ChStr chStr = new ChStr();
     
	public int insert(Member m) {
		int ret = -1;
		try {
			
			String  sql ="insert into user_(username,userpassword,userphonenumber) values" +
			   		"('"+chStr.chStr(m.getUsername()+"','"+chStr.chStr(m.getPwd()))+"',"+m.getTel()+")";
			System.out.println(sql);
			ret = conn.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		conn.close();
		return ret;
	}

	
}
