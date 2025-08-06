import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstClass {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			//Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
//			
//			Statement smt = con.createStatement();
//			smt.executeUpdate("CREATE TABLE USER_TABLE(Name VARCHAR(20), Pass VARCHAR(20))");
//			
//			System.out.println("Table Created. . .");
//			con.close();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//
//	}
	public void insertUser(String UserName, String Password)
	{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("INSERT into librarian (userid, Pass) values (?, ?)");
			psmt.setString(1, UserName);
			psmt.setString(2, Password);
			
			psmt.execute();
			System.out.println("Inserted the Data. . .");
			
			psmt.close();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean fetchUser(String UserName, String Password)
	{
		boolean present = false;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			Statement smt = con.createStatement();
			
			String query = "SELECT * FROM librarian";
			ResultSet rs = smt.executeQuery(query);
			while(rs.next())
			{
				
				String User = rs.getString(1);
				String pswd = rs.getString(2);
				System.out.println("User: "+User);
				System.out.println("pswd: "+pswd);
				
				System.out.println("UserI: "+UserName);
				System.out.println("pswdI: "+Password);
				if(UserName.equalsIgnoreCase(User) && Password.equalsIgnoreCase(pswd))
				{
					System.out.println("Inside If. . .");
					System.out.println("SuccessFull. . . Going to New Page");
					present = true;
					break;
				}
				
			}
			if(!present)
			{
				System.out.println("Invalid Input in New Pop up");
				return present;
			}
			rs.close();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return present;
	}
		
}

