import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PreparedStatement_Faster {

	public static void main(String[] args) throws Exception 
	{

		Connection con = Provider.getOracleConnection();
		String sql = "Insert into student(cgpa,name,roll,age) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		Statement st = con.createStatement();
		
		long start  = System.currentTimeMillis();
		for(int i=1 ; i<=200000 ; i++);
		{
			pst.setDouble(1, 6.5);
			pst.setString(2, "Raja");
			pst.setInt(3, 100);
			pst.setInt(4, 16);
			int status = pst.executeUpdate();
		}	
		long stop = System.currentTimeMillis();
		System.out.println(stop-start);
		
		System.out.println("----------------------");
		start=System.currentTimeMillis();
		for(int i = 1;i<=200000;i++)
		{
			int status = st.executeUpdate("Insert into student(cgpa,name,roll,age) values(6.5,'Raja',100,16)");
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		System.out.println("---------------");
		}
}
             