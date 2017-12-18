import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;


public class Transaction_Ex_Savepoint 
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
		Savepoint sp1 = con.setSavepoint();
		
		status = st.executeUpdate(sql2);
		System.out.println(status);
		Savepoint sp2 = con.setSavepoint();
		
		status = st.executeUpdate(sql3);
		System.out.println(status);
		
		con.rollback(sp2);
		System.out.println("Rollback upto Savepoint sp2....");
		con.rollback(sp1);
		System.out.println("Rollback upto Savepoint sp1....");
		
		con.commit();
		System.out.println("Yes Committed....");
		
	}
}
