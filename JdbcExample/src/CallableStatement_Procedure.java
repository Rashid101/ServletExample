import java.sql.Connection;
import java.util.Scanner;
import java.sql.CallableStatement;

public class CallableStatement_Procedure {
public static void main(String[] args) throws Exception
{
	Connection con = Provider.getOracleConnection();
	CallableStatement cst = con.prepareCall("call proc_insert(?,?,?)");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter roll,name,cgpa");
	cst.setInt(1,sc.nextInt());
	cst.setString(2,sc.next());
	cst.setDouble(3,sc.nextDouble());
	cst.execute();
	System.out.println("Procedure Executed Succesfully");
}
}
