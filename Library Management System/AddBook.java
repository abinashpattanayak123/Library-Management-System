 //Swing program to design a frame of ADD BOOK--

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class AddBook extends JFrame implements ActionListener
{
	JButton b1;
	JTextField t1,t2,t3,t4;
	JLabel lb1,lb2,lb3,lb4,bg;
	ImageIcon w1;
	JFrame f;
	AddBook()
	{
		//---------------------------------------------
		//ADD BOOK FRAME--
		//---------------------------------------------
		f = new JFrame("ADD BOOK");
		//BOOK ID---
		lb4=new JLabel("BOOK ID :");
		lb4.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb4.setBounds(695,128,173,39);
		f.add(lb4);

		t4 = new JTextField();
		t4.setBounds(645,160,173,39);
		t4.setFont(new Font("ARIAL BLACK",Font.BOLD,15));

		f.add(t4);

		//-------------------------------------------------
		//BOOK NAME----
		//-------------------------------------------------

		lb1 = new JLabel("BOOK NAME :");
		lb1.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb1.setBounds(678,197,173,39);
		f.add(lb1);
		
		t1 = new JTextField();
		t1.setBounds(645,230,173,39);
		t1.setFont(new Font("ARIAL BLACK",Font.BOLD,15));

		f.add(t1);
		//---------------------------------------------------
		//AUTHOR NAME----
		//---------------------------------------------------
		
		lb2 = new JLabel("AUTHOR NAME : ");
		lb2.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb2.setBounds(670,266,173,39);
		f.add(lb2);
		
		t2 = new JTextField();
		t2.setBounds(645,300,173,39);
		t1.setFont(new Font("ARIAL BLACK",Font.BOLD,15));
		f.add(t2);
		//--------------------------------------------------
		//TOTAL PIECE
		//--------------------------------------------------
		
		lb3 = new JLabel("TOTAL PIECE :");
		lb3.setFont(new Font("SANS_SERIF",Font.BOLD,15));
		lb3.setBounds(670,330,173,39);
	    f.add(lb3);
	    t3=new JTextField();
 		t3.setBounds(645,365,173,39);
		t3.setFont(new Font("ARIAL BLACK",Font.BOLD,15));
		f.add(t3);



		//---------------------------------------------------
		//SUBMIT
		//---------------------------------------------------
		b1 = new JButton("ADD");
		b1.setBounds(683,420,100,30);
		b1.addActionListener(this);
		f.add(b1);
		w1=new ImageIcon(ClassLoader.getSystemResource("addbook.jpg"));
		bg=new JLabel(w1);
		
		bg.add(lb1);
		bg.add(lb2);
		bg.add(lb3);
		bg.add(t1);
		bg.add(t2);
		bg.add(t3);
		f.add(bg);
		f.setSize(1080,608);
		f.pack();
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String Str= t4.getText();
		String Str1= t1.getText();
		String Str2= t2.getText();
		String Str3= t3.getText();
		//System.out.println(1);
		JOptionPane.showMessageDialog(null, "Book added successfully!");
	}
	public static void main(String args[])
	{
		new AddBook();
	}
}