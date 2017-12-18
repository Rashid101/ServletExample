/*
  //In Mysql
   	use db1;
   	
   	Create table DTS
   	(
   		TD  date,
   		TT  Time,
   		TS  Timestamp
   	);
   	
 */
import java.sql.*;
public class Time_Date_Ex 
{
	public static void main(String[] args) throws Exception 
	{
		Connection con = Provider.getMysqlConnection();
		String dt = "2017-08-31";
		String tm = "08:18:20";
		String tsm =  "2017-08-31 08:18:20";
		
		Date dd = Date.valueOf(dt); // converts String date into Datetype
		Time tt = Time.valueOf(tm);  // converts String time into Timetype
		Timestamp ss = Timestamp.valueOf(tsm);
		
		String sql = "Insert into DTS values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDate(1, dd);
		pst.setTime(2, tt);
		pst.setTimestamp(3, ss);
		int status = pst.executeUpdate();
		if(status>0)
		
			System.out.println("Yes inserted....");
		pst = con.prepareStatement("select * from DTS");
		
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getDate(1)+"\t"+rs.getTime(2)+"\t"+rs.getTimestamp(3));
		}
		
	}
}
