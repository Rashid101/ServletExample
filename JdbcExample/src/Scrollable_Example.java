import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_Example 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select cgpa, name, roll from Student1");
		
		System.out.println("Roll\tName\tCGPA");
		
		while(rs.next())
		{
			double cgpa = rs.getDouble(1); // 1 since cgpa is at no. 1 in executeQuery()
			String name = rs.getString("name");
			int roll = rs.getInt(3);
			
			System.out.println(roll+"\t"+name+"\t"+cgpa);
			
		}
	}
	
}
