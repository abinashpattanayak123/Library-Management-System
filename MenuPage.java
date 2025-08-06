//menu page
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MenuPage extends JFrame implements ActionListener
{
	JFrame f;
	JButton bib,brb,bab,bdb,bsb,logout;
	JLabel bg1;
	ImageIcon i1,logo,button;
	
	MenuPage()
	{
		f=new JFrame("Menu Page");
		
		button=new ImageIcon("button.png");
		
		bib=new JButton();
		bib.setBounds(50,425,120,36);
		bib.setIcon(button);
		bib.addActionListener(this);
		
		brb=new JButton();
		brb.setBounds(270,135,120,36);
		brb.setIcon(button);
		brb.addActionListener(this);
		
		bab=new JButton();
		bab.setBounds(535,525,120,36);
		bab.setIcon(button);
		bab.addActionListener(this);
		
		bdb=new JButton();
		bdb.setBounds(656,310,120,36);
		bdb.setIcon(button);
		bdb.addActionListener(this);
		
		bsb=new JButton();
		bsb.setBounds(700,110,120,36);
		bsb.setIcon(button);
		bsb.addActionListener(this);
		
		logout=new JButton("Logout");
		logout.setBounds(100,300,105,36);
		logout.setFont(new Font("SANS_SERIF",Font.BOLD,17));
		logout.addActionListener(this);
		
		logo=new ImageIcon("logo.png");
		f.setIconImage(logo.getImage());
		
		f.setSize(1080,608);
		f.setVisible(true);
		
		i1=new ImageIcon(ClassLoader.getSystemResource("menu1.jpg"));
		bg1=new JLabel(i1);
		
		f.add(bg1);
		bg1.add(bib);
		bg1.add(brb);
		bg1.add(bab);
		bg1.add(bdb);
		bg1.add(bsb);
		bg1.add(logout);
		
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bib)
		{
			new IssueBook();
		}
		if(e.getSource()==brb)
		{
			new ReturnBook();
		}
		if(e.getSource()==bab)
		{
			new AddBook();
		}
		if(e.getSource()==bdb)
		{
			new DeletePage1();
		}
		if(e.getSource()==bsb)
		{
			new SearchBook();
		}
		if(e.getSource()==logout)
		{
			new LoginPage();
		}
	}
	public static void main(String args[])
	{
		new MenuPage();
	}
}