import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class FirstClass {

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
	
	public void insertBookInDB(String Bookname, String BookId, String AuthorName)
	{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("INSERT into BOOK (BOOKNAME, BOOKID, AUTHORNAME, STATUS) values (?, ?, ?, ?)");
			psmt.setString(1, Bookname);
			psmt.setString(2, BookId);
			psmt.setString(3, AuthorName);
			psmt.setString(4, "Available");
			
			psmt.execute();
			
			psmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int deleteBookInDB(String Bookname, String BookId)
	{
		int rowsAffected = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("DELETE from BOOK where BOOKNAME=? AND BOOKID=?");
			psmt.setString(1, Bookname);
			psmt.setString(2, BookId);
			
			rowsAffected = psmt.executeUpdate();
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	public int deleteBookDetailsInDB(String BookId)
	{
		int rowsAffected = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("DELETE from BOOK_DETAILS where BOOKID=?");
			psmt.setString(1, BookId);
			
			rowsAffected = psmt.executeUpdate();
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public int updateStatus(String BookId)
	{	
	    int rowsUpdated = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("UPDATE BOOK set STATUS='Issued' WHERE BOOKID=?");
			psmt.setString(1, BookId);
			
			rowsUpdated = psmt.executeUpdate();
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}
	
	public int updateStatusToAvail(String BookId)
	{	
	    int rowsUpdated = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("UPDATE BOOK set STATUS='Available' WHERE BOOKID=?");
			psmt.setString(1, BookId);
			
			rowsUpdated = psmt.executeUpdate();
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}
	
	public int insertBookDetails(String BookId, String IssueDate, String StudentName )
	{	
	    int rowsUpdated = 0;
		try {
			Date sqlDate = Date.valueOf(IssueDate);
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("INSERT into BOOK_DETAILS (BOOKID, ISSUE_DATE, STUDENT_NAME) values (?, ?, ?)");
			psmt.setString(1, BookId);
			psmt.setDate(2, sqlDate);
			psmt.setString(3, StudentName);
			
			rowsUpdated = psmt.executeUpdate();
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}
	
	public boolean fetchBookRecord(String bookId)
	{
		boolean present = false;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			Statement smt = con.createStatement();
			
			String query = "SELECT * FROM BOOK";
			ResultSet rs = smt.executeQuery(query);
			while(rs.next())
			{
				
				String bookName = rs.getString(1);
				String id = rs.getString(2);
				String AuthorName = rs.getString(3);
				String status = rs.getString(4);
				
				if(bookId.equalsIgnoreCase(id) && status.equalsIgnoreCase("Issued"))
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
	
	public Book fetchBookRecordObj(String bookId)
	{
		Book b1 = new Book();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			Statement smt = con.createStatement();
			
			String query = "SELECT * FROM BOOK";
			ResultSet rs = smt.executeQuery(query);
			while(rs.next())
			{
				
				String bookName = rs.getString(1);
				String id = rs.getString(2);
				String AuthorName = rs.getString(3);
				String status = rs.getString(4);
				
				if(bookId.equalsIgnoreCase(id))
				{
					
					
					b1.setBookName(bookName);
					b1.setAuthorName(AuthorName);
					b1.setBookId(id);
					b1.setStatus(status);
				}
				
			}
			rs.close();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return b1;
	}
	
	public BookDetails fetchBookDetailsObj(String bookId)
	{
		BookDetails b1 = new BookDetails();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			Statement smt = con.createStatement();
			
			String query = "SELECT * FROM BOOK_DETAILS";
			ResultSet rs = smt.executeQuery(query);
			while(rs.next())
			{
				
				String id = rs.getString(1);
				Date issueDate = rs.getDate(2);
				String studentName = rs.getString(3);
				
				if(bookId.equalsIgnoreCase(id))
				{
					b1.setBookId(id);
					b1.setIssuedate(issueDate);
					b1.setStudentname(studentName);
				}
				
			}
			rs.close();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return b1;
	}
	
	public void AddLibrarianInDB(String UserId,String Password,String ConfirmPassword)
	{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "002460");
			PreparedStatement psmt = con.prepareStatement("INSERT into LIBRARIAN (USERID,PASS) values (?, ?)");
			psmt.setString(1, UserId);
			psmt.setString(2, Password);
			
			
			psmt.execute();
			
			psmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}

