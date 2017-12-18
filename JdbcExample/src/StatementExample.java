import java.sql.Connection;
import java.sql.Statement;

public class StatementExample {
	public static void main(String[] args) throws Exception
	{

		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
		String sql = null;
		
		//DDL statement processing
		
		// Table drop logic
		sql = "drop table student";
		boolean result = st.execute(sql); // returns false when table is created
		System.out.println(result);
		
		//Table Creation logic
		sql = "create table student(roll number(4), name varchar2(12))";
		result = st.execute(sql);
		System.out.println(result);
		
		//Table Alter logic
		sql = "Alter table student modify roll number(10)";
		result = st.execute(sql);
		System.out.println(result);
		
		//Table truncate logic
		sql = "truncate table student";
		result = st.execute(sql);
		System.out.println(result);
		
		//Table Rename logic
		sql = "rename table student to std1";
		result = st.execute(sql);
		System.out.println(result);
	}

}
