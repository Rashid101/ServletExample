import java.sql.*;
public class RSMD_EX 
{
	public static void main(String[] args) throws Exception 
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from student");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int no_of_cols = rsmd.getColumnCount();
		System.out.println("No of cols in table : "+no_of_cols);
		
		for(int i=1; i<=no_of_cols; i++)
		{
			System.out.print(rsmd.getColumnLabel(i)+"\t");
			System.out.print(rsmd.getColumnDisplaySize(i)+"\t");
			System.out.print(rsmd.getColumnTypeName(i)+"\t");
			System.out.println(rsmd.getColumnClassName(i));
			System.out.println();
		}
	}
}
