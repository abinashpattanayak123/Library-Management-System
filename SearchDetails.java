//search details

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchDetails extends JFrame implements ActionListener
{
	String authName, bkName, stats, id;
	JButton b1;
	JFrame f;
	JLabel bookname,authorname,status,bg;
	JTextField t1,t2,t3;
	ImageIcon i1,logo;
	
	SearchDetails(String AuthorName, String BookName, String Status, String BookId)
	{
		authName = AuthorName;
		bkName = BookName;
		stats = Status;
		id = BookId;
		
		f=new JFrame("Search Details");
		
		i1=new ImageIcon(ClassLoader.getSystemResource("register.jpg"));
		bg=new JLabel(i1);
		
	    bookname=new JLabel("Book Name:");
		bookname.setForeground(Color.BLACK);
		bookname.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		bookname.setBounds(750,110,200,30);
		bg.add(bookname);
		
		t1=new JTextField();
		t1.setBounds(710,160,250,30);
		t1.setFont(new Font("Arial Black",Font.PLAIN,15));
		t1.setText(bkName);
		t1.setEditable(false);
		bg.add(t1);
		
		authorname=new JLabel("Author Name:");
		authorname.setForeground(Color.BLACK);
		authorname.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		authorname.setBounds(740,210,250,30);
		bg.add(authorname);
		
		t2=new JTextField();
		t2.setBounds(710,260,250,30);
		t2.setFont(new Font("Arial Black",Font.PLAIN,15));
		t2.setText(authName);
		t2.setEditable(false);
		bg.add(t2);
		
		status=new JLabel("Status:");
		status.setForeground(Color.BLACK);
		status.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		status.setBounds(780,310,300,30);
		bg.add(status);
		
		t3=new JTextField();
		t3.setBounds(710,360,250,30);
		t3.setFont(new Font("Arial Black",Font.PLAIN,15));
		t3.setText(stats);
		t3.setEditable(false);
		bg.add(t3);
		
		b1 = new JButton("BACK");
		b1.setBounds(785,420,100,30);
		b1.addActionListener(this);
		bg.add(b1);
		
		f.setSize(1080,608);
		f.setVisible(true);
		
		f.add(bg);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	SearchDetails(){}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new MenuPage();
		}
	}	
	public static void main(String args[])
	{
		new SearchDetails();
	}
}