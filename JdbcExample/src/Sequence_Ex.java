//How to use sequence in JDBC ?
/*
  	SQL>Create sequence slno start with 10;
  	Sequence created.
  	SQL> select slno.nextval from dual;
 */
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Sequence_Ex 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql = "select slno.nextval from dual";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		long slno = 0;
		while(rs.next())
		{
			slno = rs.getLong(1);
		}
		String sql = "insert into multi values (?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the filename(multimedia file)");
		String filename = sc.next();
		FileInputStream fis = new FileInputStream(filename);
		
		pst.setLong(1, slno);
		pst.setBinaryStream(2, fis,fis.available());
		int status = pst.executeUpdate();
		if(status>0)
			System.out.println("Yes multimedia info inserted...");
		else 
			System.out.println("Error ! ");
		fis.close();
		con.close();
	
		
	}	
}
