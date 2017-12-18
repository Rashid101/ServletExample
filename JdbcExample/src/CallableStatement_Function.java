import java.sql.Connection;
import java.sql.Types;
import java.sql.CallableStatement;

public class CallableStatement_Function 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		CallableStatement cst = con.prepareCall("{?=call fun_add(?,?)}");
		cst.registerOutParameter(1, Types.INTEGER);
		cst.setInt(2, 10);
		cst.setInt(3, 30);
		cst.execute();
		System.out.println("Function executed Successfully....");
		System.out.println("After add ; "+cst.getInt(1));
	}

}
