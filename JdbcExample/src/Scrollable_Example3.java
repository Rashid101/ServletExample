import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_Example3 
{
	public static void main(String[] args)throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement
				(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = st.executeQuery("Select roll,name,cgpa from student1");
		rs.absolute(3);
		System.out.println("3rd row..............");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		rs.absolute(2);
		rs.deleteRow();
		
		System.out.println("Yes 2ndd row deleted");
		rs.absolute(3);
		rs.updateString(2,"ABC");
		rs.updateDouble(3, 9.5);
		rs.updateRow();
		System.out.println("Yes updated");
		
		rs.moveToInsertRow();
		rs.updateInt(1, 200);
		rs.updateString(2, "XYZ");
		rs.updateDouble(3, 5.5);
		rs.insertRow();
		System.out.println("Yes Inserted");	
	}
}
