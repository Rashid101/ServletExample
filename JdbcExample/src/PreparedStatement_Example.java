import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class PreparedStatement_Example {

	public static void main(String[] args) throws Exception 
	{

		Connection con = Provider.getOracleConnection();
		String sql = "Insert into student(cgpa,name,roll,age) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		
		for(int i=1;i<=30;i++);
		{
			pst.setDouble(1, 6.5);
			pst.setString(2, "Raja");
			pst.setInt(3, 100);
			pst.setInt(4, 16);
			if(con!=null)
				System.out.println("Yes Inserted...");
			else
				System.out.println("Not Inserted...");
		}
		sql = "Update student set name=?,cgpa=?,age=?where roll=?"

				
					
	}
}
