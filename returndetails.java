import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class returndetails extends JFrame implements ActionListener
{
	String id;
	JButton b1;
	JTextField t4;
	JFormattedTextField t1,t2;
	JLabel lb1,lb2,lb4,bg;
	ImageIcon w1;
	JFrame f;
	BookDetails bkdetail = new BookDetails();
	FineCalculation calfine = new FineCalculation();
	
	returndetails(String bookId)
	{
		id=bookId;
		FirstClass fetchBookDetailsFromDB = new FirstClass();
		bkdetail = fetchBookDetailsFromDB.fetchBookDetailsObj(id);
		int fine = calfine.calculate(bkdetail.getIssuedate());
		
		//---------------------------------------------
		//ADD BOOK FRAME--
		//---------------------------------------------
		f = new JFrame("RETURN DETAILS");
		//STUDENT NAME---
		lb4=new JLabel("STUDENT NAME :");
		lb4.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb4.setBounds(670,128,173,39);
		f.add(lb4);

		t4 = new JTextField();
		t4.setBounds(645,160,173,39);
		t4.setFont(new Font("ARIAL BLACK",Font.BOLD,15));
		t4.setText(bkdetail.getStudentname());
		t4.setEditable(false);

		f.add(t4);

		//-------------------------------------------------
		//ISSUE DATE----
		//-------------------------------------------------

		lb1 = new JLabel("ISSUE DATE :");
		lb1.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb1.setBounds(678,197,173,39);
		f.add(lb1);
		
		DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		t1 = new JFormattedTextField(dateFormate);
		t1.setBounds(645,230,173,39);
		t1.setFont(new Font("ARIAL BLACK",Font.BOLD,15));
		t1.setValue(bkdetail.getIssuedate());
		t1.setEditable(false);

		f.add(t1);
		//---------------------------------------------------
		//FINE----
		//---------------------------------------------------
		
		lb2 = new JLabel("FINE : ");
		lb2.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb2.setBounds(700,266,173,39);
		f.add(lb2);
		
		t2 = new JFormattedTextField();
		t2.setBounds(645,300,173,39);
		t2.setFont(new Font("ARIAL BLACK",Font.BOLD,15));
		f.add(t2);
		t2.setValue(fine);
		t2.setEditable(false);
		 



		//---------------------------------------------------
		//SUBMIT
		//---------------------------------------------------
		b1 = new JButton("RETURN");
		b1.setBounds(683,380,100,30);
		b1.addActionListener(this);
		f.add(b1);
		w1=new ImageIcon(ClassLoader.getSystemResource("returnbg.jpg"));
		bg=new JLabel(w1);
		
		bg.add(lb1);
		bg.add(lb2);
		//bg.add(lb3);
		bg.add(t1);
		bg.add(t2);
		//bg.add(t3);
		f.add(bg);
		f.setSize(1080,608);
		f.pack();
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	returndetails(){}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			FirstClass dbConnectionObj = new FirstClass();
			int deleteDetails = dbConnectionObj.deleteBookDetailsInDB(id);
			if(deleteDetails != 0)
			{
				JOptionPane.showMessageDialog(null, "Book returned successfully!");
				System.out.println("Inside 1st If");
				System.out.println("Deleted Book Details...");
			}
			new MenuPage();
		}
	}
	public static void main(String args[])
	{
		new returndetails();
	}
}
