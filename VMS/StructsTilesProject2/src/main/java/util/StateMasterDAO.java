package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StateMasterDAO {
	
	public static String getDistrictName(String distCode)
	{
		try {
			Connection con = JDBCUtility.getConn();
			PreparedStatement ps = con.prepareStatement("select district_name from mst_district where district_code = ?");
		  ps.setString(1, distCode);
			ResultSet rs = ps.executeQuery();
		  if(rs.next())
		  {
			  return rs.getString("district_name");
			  
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public  List<ComanBean> getStateDetail()
	{     List<ComanBean> list= new ArrayList<ComanBean>();
		try {
			Connection con = JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("select state_code,state_name from state_mst");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	
		    	ComanBean comanBean= new	ComanBean();
		    	comanBean.setStateCode(rs.getString("state_code"));
		    	comanBean.setStateName(rs.getString("state_name"));
		    	
		    	 list.add(comanBean);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public  List<ComanBean> getDistrictList(String stateCode)
	{    List<ComanBean> list= new ArrayList<ComanBean>();
		try {
			Connection con = JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("select district_code,district_name from mst_district where state_code = ?");
		      ps.setString(1, stateCode);
			 ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	 ComanBean comanbean = new ComanBean ();
		    	 comanbean.setDistName(rs.getString("district_name"));
		    	 comanbean.setDistCode(rs.getString("district_code"));
		    	 list.add(comanbean);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
