import java.sql.Connection;
import java.sql.Statement;
public class StatementDML 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
		String sql = null;
		int status = 0;
		
		// Insert Logic
		sql = "insert into std values(100,'Raja')";
		status = st.executeUpdate(sql);
		System.out.println(status);
		if (status>0)
			System.out.println("Inserted...");
		else
			System.out.println("Not Inserted...");
		
		sql = "insert into std values(101,'Rani')";
		status = st.executeUpdate(sql);
		System.out.println(status);
		
		// Update Logic
		sql = "Update std set name='Ajay' where roll=100";
		status = st.executeUpdate(sql);
		System.out.println(status);
		
		// Delete Logic
		sql = "Delete from std where roll=100";
		status = st.executeUpdate(sql);
		System.out.println(status);
	}

}
/* Create table std
   (	Roll number(4) ,
		Name varchar2(20)
	);
*/
