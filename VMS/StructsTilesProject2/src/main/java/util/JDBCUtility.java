package util; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtility {
	
	
	public static String getStateShortName(String scode,Connection con)
	{
		try {
			
			PreparedStatement ps = con.prepareStatement("select state_short_name from state_mst where state_code=?");
		ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String state_short = rs.getString("state_short_name");
				if(state_short.length()==2)
				{
					return state_short;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static int getID(String shortName,Connection con)
	{
		try {
PreparedStatement ps = con.prepareStatement("select max(pid) as pd from "+shortName+"_parents");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("pd");
			return id+1;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int getCID(String shortName,Connection con)
	{
		try {
PreparedStatement ps = con.prepareStatement("select max(cid) as cd from "+shortName+"_child");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("cd");
			return id+1;
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private JDBCUtility()
	{
		
	}
	static Connection cn=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/struts","postgres","abc");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return cn;
	}

}
