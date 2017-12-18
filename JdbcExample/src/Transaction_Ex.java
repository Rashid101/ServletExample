import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Transaction_Ex 
{
	public static void main(String[] args) throws Exception 
	{
		Connection con = Provider.getOracleConnection();
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		
		String sql1 = "Insert into student values(111,'x',44)";
		String sql2 = "Insert into student values(112,'y',24)";
		String sql3 = "Insert into student values(113,'z',34)";
		
		int status = st.executeUpdate(sql1);
		System.out.println(status);
		con.commit();  // actual saving in database
		System.out.println("Yes commited....");
		con.rollback();  // actual rollbackig in database
		System.out.println("Yes rollbacked....");
		
		status = st.executeUpdate(sql2);
		System.out.println(status);
		status = st.executeUpdate(sql3);
		System.out.println(status);
		con.rollback();
		System.out.println("Yes rollbacked....");
		
	}
}
