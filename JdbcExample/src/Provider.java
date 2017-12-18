//To establish Connection
import java.sql.Connection;
import java.sql.DriverManager;

public class Provider {
	public static Connection getOracleConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system","system");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static Connection getMysqlConnection() 
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1",
					"root","system");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
		
	}

}

