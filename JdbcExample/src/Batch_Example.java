import java.sql.*;
public class Batch_Example
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
	
		String sql1 = "Insert into student1 values(111,'x',44)";
		String sql2 = "Insert into student1 values(112,'y',24)";
		String sql3 = "delete from student1 where roll = 111";
		
		st.addBatch(sql1);
		st.addBatch(sql2);
		st.addBatch(sql3);
		
		int status[] = st.executeBatch();
		for(int i = 0; i<status.length; i++)
		{
			System.out.println(status[i]);
		}
	}
}