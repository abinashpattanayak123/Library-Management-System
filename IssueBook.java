//issue book
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class IssueBook extends JFrame implements ActionListener
{
	JFrame f;
	JLabel bn,bid,sname,idt,bg;
	JTextField name,id,sn,date;
	JButton submit;
	ImageIcon i1,logo;
	IssueBook()
	{
		f=new JFrame("Issue Book");
		f.setSize(1080,608);
		f.setVisible(true);
		
		i1=new ImageIcon(ClassLoader.getSystemResource("issue.jpg"));
		bg=new JLabel(i1);
		
		bn=new JLabel("Book Name:");
		bn.setForeground(Color.BLACK);
		bn.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		bn.setBounds(700,100,200,50);
		bg.add(bn);
		
		name=new JTextField();
		name.setBounds(687,150,200,30);
		name.setFont(new Font("Arial Black",Font.BOLD,15));
		bg.add(name);
		
		bid=new JLabel("Book ID:");
		bid.setForeground(Color.BLACK);
		bid.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		bid.setBounds(725,200,200,50);
	    bg.add(bid);
		
		id=new JTextField();
		id.setBounds(687,250,200,30);
		id.setFont(new Font("Arial Black",Font.BOLD,15));
		bg.add(id);
		
		sname=new JLabel("Student Name:");
		sname.setForeground(Color.BLACK);
		sname.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		sname.setBounds(681,300,300,50);
		bg.add(sname);
		
		sn=new JTextField();
		sn.setBounds(687,350,200,30);
		sn.setFont(new Font("Arial Black",Font.BOLD,15));
		f.add(sn);
		
		idt=new JLabel("Issue Date:");
		idt.setForeground(Color.BLACK);
		idt.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		idt.setBounds(705,400,200,50);
		bg.add(idt);
		
		date=new JTextField();
		date.setBounds(687,450,200,30);
		date.setFont(new Font("Arial Black",Font.BOLD,15));
		f.add(date);
		
		submit=new JButton("submit");
		submit.setBounds(725,500,120,36);
		bg.add(submit);
		submit.addActionListener(this);
		
		logo=new ImageIcon("logo.png");
		f.setIconImage(logo.getImage());
		
		f.add(bg);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		FirstClass DbCallForCRUDObj = new FirstClass();
		//String Bookname= name.getText();
		String Bookid= id.getText();
		String Student_name= sn.getText();
		String Issuedate= date.getText();
		boolean status = DbCallForCRUDObj.fetchBookRecord(Bookid);
		if(!status) {
			FirstClass updateBookStatus = new FirstClass();
			int rowsUpdated = updateBookStatus.updateStatus(Bookid);
			
			if (rowsUpdated > 0) {
				//Date convertDate;
				try {
					//convertDate = new SimpleDateFormat("dd-MM-yyyy").parse(Issuedate);
					FirstClass InsertBookDetailsObj = new FirstClass();
					int rowsInserted = InsertBookDetailsObj.insertBookDetails(Bookid,Issuedate,Student_name);
					if (rowsInserted > 0) {
						JOptionPane.showMessageDialog(null, "Book issued successfully!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Book is Already issued!!!");
		}
		if(e.getSource()==submit)
		{
			new MenuPage();
		}
	}
	public static void main(String args[])
	{
		new IssueBook();
	}
}