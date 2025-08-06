//login page
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class LoginPage extends JFrame implements ActionListener
{
	JFrame f;
	JLabel l1,l2,bg;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	ImageIcon i1,logo;
	
	LoginPage()
	{
		f=new JFrame("Login Page");
		
		l1=new JLabel("Username :");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		l1.setBounds(800,240,200,50);
		
		l2=new JLabel("Password :");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		l2.setBounds(800,340,200,50);
		
		t1=new JTextField();
		t1.setBounds(780,290,200,30);
		t1.setFont(new Font("Arial Black",Font.BOLD,15));
		
		t2=new JPasswordField();
		t2.setBounds(780,390,200,30);
		t2.setFont(new Font("Arial Black",Font.BOLD,15));
		
		b1=new JButton("Login");
		b1.setBounds(820,450,120,36);
		b1.setFont(new Font("SANS_SERIF",Font.BOLD,20));
		b1.addActionListener(this);
		
		/*b2=new JButton("Admin");
		b2.setBounds(230,290,150,40);
		b2.setFont(new Font("SANS_SERIF",Font.BOLD,20));
		b2.addActionListener(this);*/
		
		logo=new ImageIcon("logo.png");
		f.setIconImage(logo.getImage());
		
		f.setSize(1080,608);
		f.setVisible(true);
		
		i1=new ImageIcon(ClassLoader.getSystemResource("login1.jpg"));
		bg=new JLabel(i1);
		f.add(bg);
		bg.add(l1);
		bg.add(l2);
		bg.add(t1);
		bg.add(t2);
		bg.add(b1);
		//bg.add(b2);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String user = t1.getText();
		String Password = new String(t2.getPassword());
		
		FirstClass dbconnectToInsert = new FirstClass();
        boolean status = dbconnectToInsert.fetchUser(user, Password);
		if(status)
		{
			new MenuPage();
		}
		else{
			System.out.println("Invalid User");
		}
	}
	public static void main(String args[])
	{
		new LoginPage();
	}
}