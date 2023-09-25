package visitr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtility;
import util.StateMasterDAO;

public class VisitorDAO {
	public List<VisitorDTO> getVisitorDetail(String name)
	{  
		 List<VisitorDTO> list=new ArrayList<VisitorDTO>();
		try {
			Connection con = JDBCUtility.getConn();
			PreparedStatement ps=null;
			 String q="select v.vname as name,v.vemail as email,v.vadd as add,v.vphone as phone,s.state_name as statename,v.district_code as districtcode from visitor_master v inner join state_mst s on v.state_code=s.state_code ";
		      
			if(name.equalsIgnoreCase("All"))
			{
			
         ps = con.prepareStatement(q);
			  }
			else   
			{   String[] n = name.split(",");
			     String email = n[1];
				ps = con.prepareStatement(q+" where v.vemail=?");
				   ps.setString(1, email);
			}
		 
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			VisitorDTO visitorDTO=new VisitorDTO();
			visitorDTO.setVisitorName(rs.getString("name"));
			visitorDTO.setVisitorEmail(rs.getString("email"));
			visitorDTO.setVisitorAdd(rs.getString("add"));
			visitorDTO.setVisitorPhone(rs.getString("phone"));
			visitorDTO.setStateName(rs.getString("statename"));
			visitorDTO.setDistName(StateMasterDAO.getDistrictName(rs.getString("districtcode")));
			list.add(visitorDTO);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public  List<String> getVisitorEntry()
	{      List<String> l=new ArrayList<String>();
		try {
		Connection con = JDBCUtility.getConn();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select vid,vemail from visitor_master");
	  while(rs.next())
	  {
		  l.add(rs.getInt(1)+","+rs.getString("vemail"));
		  
	  }
	
	} catch (Exception e) {
		e.printStackTrace();
	}
		return l;
		
	}
	
	
	
	public int insertVisitorEntry(VisitorDTO vdto)
	{
		try {
			Connection con = JDBCUtility.getConn();
PreparedStatement ps = con.prepareStatement("insert into visitor_master values (?,?,?,?,?,?,?)");
		  ps.setInt(1, vdto.getVid());
		  ps.setString(2, vdto.getStateCode());
		  ps.setString(3, vdto.getDistCode());
		  ps.setString(4, vdto.getVisitorName());
		  ps.setString(5, vdto.getVisitorAdd());
		  ps.setString(6, vdto.getVisitorEmail());
		  ps.setString(7, vdto.getVisitorPhone());
		 return ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
