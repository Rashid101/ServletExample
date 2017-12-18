import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Multi_Fetch 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql = "Select multi_info from multi where slno = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the new slno ");
		int slno = sc.nextInt();
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, slno);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			InputStream is = rs.getBinaryStream(1);
			System.out.println("Enter the filename(multimedia file)");
			String filename = sc.next(); //creates a new file
			
			
			
			FileOutputStream fos = new FileOutputStream(filename);
			int ch;
			while((ch=is.read())!= -1)
			{
				fos.write(ch);
			}
			System.out.println("Done !");
			fos.close();
			is.close();
		}
		con.close();
	}
}
