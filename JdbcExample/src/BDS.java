
import java.sql.Connection;
import org.apache.commons.dbcp.BasicDataSource;
public class BDS 
	{
		public static void main(String[] args) throws Exception
		{

			BasicDataSource bds = new BasicDataSource();
			bds.setDriverClassName("oracle.jdbc.OracleDriver");
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");  //setUrl is same as DriverManager.getConnection() in above program.
			bds.setUsername("system");
			bds.setPassword("system");
			Connection con = bds.getConnection();
			if(con!=null)
			{
				System.out.println("Connected with ORACLE using BasicDataSource class");
				System.out.println(con);
			}
		}
	}