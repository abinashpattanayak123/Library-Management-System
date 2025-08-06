//return page
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ReturnBook extends JFrame implements ActionListener
{
	JFrame f;
	JLabel l1,bg;
	JTextField ts;
	JButton r,c;
	ImageIcon img,button,logo;
	
	ReturnBook()
	{
		//Framing
		f=new JFrame("Return Book");
		f.setSize(1080,608);
		
		//button=new ImageIcon();
		
		//add image
		img = new ImageIcon(ClassLoader.getSystemResource("return.jpg"));
        bg= new JLabel(img);
        f.add(bg);
		
		l1=new JLabel("Book Id:");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("SANS_SERIF",Font.BOLD,30));
		l1.setBounds(700,195,200,30);
		bg.add(l1);
		 
		ts=new JTextField();
		ts.setBounds(650,250,230,30);
		ts.setFont(new Font("Arial Black", Font.BOLD, 30));
		bg.add(ts);
		//Button
		r = new JButton("Return");
        r.setBounds(650,300,100,30);
		//r.setIcon(button);
        r.addActionListener(this);
        bg.add(r);
		
		
		c = new JButton("Cancel");
        c.setBounds(780,300,100,30);
		//c.setIcon(button);
        c.addActionListener(this);
        bg.add(c);
		
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String BookId = ts.getText();
		if(e.getSource() == r)
		{
			FirstClass dbConnectionObj = new FirstClass();
			boolean status = dbConnectionObj.fetchBookRecord( BookId );
			if(status)
			{
				int updatedRow = dbConnectionObj.updateStatusToAvail(BookId);
				if(updatedRow != 0)
				{
						new returndetails(BookId);
				}
						
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid BookId!!");
			}
		}
		else if(e.getSource() == c)
		{
			new MenuPage();
		}
	}
	public static void main(String args[])
	{
		new ReturnBook();
	}
}