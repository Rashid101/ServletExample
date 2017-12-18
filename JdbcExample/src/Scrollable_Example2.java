import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_Example2 
{
	public static void main(String[] args)throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement
				(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = st.executeQuery("Select roll,name,cgpa from student1");
		System.out.println(rs.isBeforeFirst());
		System.out.println(rs.getRow());
		System.out.println("Forward.......");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		}
		System.out.println(rs.isAfterLast());
		System.out.println(rs.getRow());
		System.out.println("Backward........");
		while(rs.previous())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		}
		rs.absolute(3);
		System.out.println("3rd row.........");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		
		rs.first();
		System.out.println(rs.getRow());
		rs.last();
		System.out.println(rs.getRow());
		rs.afterLast();
		System.out.println(rs.isLast());
		
		rs.absolute(2);
		//rs.deleteRow(); //Invalid operation for read only ResultSet
		
	}
}
