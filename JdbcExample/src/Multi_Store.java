/*
  	Create table Multi //in RUN sql
  	(
  		slno number(4),
  		multi_info BLOB
  	);
 */
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Multi_Store 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql = "insert into Multi values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the slno ");
		int slno = sc.nextInt();
		
		System.out.println("Enter the filename(multimedia file)");
		String filename = sc.next();
		FileInputStream fis = new FileInputStream(filename);
		
		pst.setInt(1, slno);
		pst.setBinaryStream(2, fis, fis.available());
		
		int status = pst.executeUpdate();
		if(status>0)
			System.out.println("Yes multimedia info inserted...");
		else 
			System.out.println("Error ! ");
		fis.close();
		con.close();
	}
}
