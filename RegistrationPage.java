//registration page
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegistrationPage extends JFrame implements ActionListener
{
	JFrame f;
	JLabel userid,password,confirm,bg;
	JTextField t2;
	JPasswordField t3,t4;
	JButton submit,reset;
	ImageIcon i1,logo,button;
	
	RegistrationPage()
	{
		f=new JFrame("Registration Page");
		
		i1=new ImageIcon(ClassLoader.getSystemResource("register.jpg"));
		bg=new JLabel(i1);
		
	    userid=new JLabel("User ID:");
		userid.setForeground(Color.BLACK);
		userid.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		userid.setBounds(760,80,200,30);
		bg.add(userid);
		
		t2=new JTextField();
		t2.setBounds(700,130,250,30);
		t2.setFont(new Font("Arial Black",Font.BOLD,15));
		bg.add(t2);
		
		password=new JLabel("Password:");
		password.setForeground(Color.BLACK);
		password.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		password.setBounds(750,180,200,30);
		bg.add(password);
		
		t3=new JPasswordField();
		t3.setBounds(700,230,250,30);
		t3.setFont(new Font("Arial Black",Font.BOLD,15));
		bg.add(t3);
		
		confirm=new JLabel("Confirm Password:");
		confirm.setForeground(Color.BLACK);
		confirm.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		confirm.setBounds(690,280,300,30);
		bg.add(confirm);
		
		t4=new JPasswordField();
		t4.setBounds(700,330,250,30);
		t4.setFont(new Font("Arial Black",Font.BOLD,15));
		bg.add(t4);
		
		submit=new JButton("Submit");
		submit.setBounds(700,380,120,36);
		submit.setFont(new Font("SANS_SERIF",Font.BOLD,20));
	    //submit.setIcon(button);
		submit.addActionListener(this);
		bg.add(submit);
		
		reset=new JButton("Reset");
		reset.setBounds(830,380,120,36);
		reset.setFont(new Font("SANS_SERIF",Font.BOLD,20));
	    //reset.setIcon(button);
		reset.addActionListener(this);
		bg.add(reset);
		
		f.setSize(1080,608);
		f.setVisible(true);
		
		f.add(bg);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==reset)
		{
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}
		 
		String UserId = t2.getText();
		String Password = new String(t3.getPassword());
		String ConfirmPassword = new String(t4.getPassword());
		
		
		
		FirstClass AddLibrarian = new FirstClass();
		AddLibrarian.AddLibrarianInDB(UserId, Password, ConfirmPassword);
		
		JOptionPane.showMessageDialog(null, "Registered successfully!");
		if(e.getSource()==submit)
		{
			new LoginPage();
		}
	}	
	public static void main(String args[])
	{
		new RegistrationPage();
	}
}