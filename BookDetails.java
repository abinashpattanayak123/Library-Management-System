import java.sql.Date;

public class BookDetails {
	
	String BookId;
	String Studentname;
	Date Issuedate;
	
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public Date getIssuedate() {
		return Issuedate;
	}
	public void setIssuedate(Date issuedate) {
		Issuedate = issuedate;
	}
}
