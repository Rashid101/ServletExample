import java.sql.*;
public class DBMD_EX 
{
	public static void main(String[] args) throws Exception 
	{
		Connection con = Provider.getOracleConnection();
		DatabaseMetaData dbmd = con.getMetaData();
		
		System.out.println(dbmd.getDriverMajorVersion());
		System.out.println(dbmd.getDriverMinorVersion());
		System.out.println(dbmd.getDriverVersion());
		System.out.println(dbmd.getDriverName());
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getDatabaseProductVersion());
		System.out.println(dbmd.getDatabaseMajorVersion());
		System.out.println(dbmd.getDatabaseMinorVersion());
		System.out.println(dbmd.getMaxColumnsInSelect());
		System.out.println(dbmd.getMaxColumnsInTable());
		System.out.println(dbmd.getMaxColumnNameLength());
		System.out.println(dbmd.getMaxTableNameLength());
		System.out.println(dbmd.getMaxColumnsInOrderBy());
		System.out.println(dbmd.getMaxColumnsInGroupBy());
		System.out.println(dbmd.getDriverName());
		
	}
}
