//search book
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SearchBook extends JFrame implements ActionListener
{
	JFrame f;
	JLabel l1,bk;
	JTextField ts;
	JButton sbook;
	ImageIcon img1,button,logo;
	Book b1 = new Book();
	
	SearchBook()
	{
		//Framing
		f=new JFrame("Search Book");
		f.setSize(1080,608);
		
		button=new ImageIcon("search1.png");
		
		//add image
		img1 = new ImageIcon(ClassLoader.getSystemResource("search.jpg"));
        bk = new JLabel(img1);
        f.add(bk);
		 
		ts=new JTextField();
		ts.setBounds(295,150,418,61);
		ts.setFont(new Font("Arial Black", Font.BOLD, 30));
		bk.add(ts);
		//Button
		sbook = new JButton();
        sbook.setBounds(717,150,67,60);
		sbook.setIcon(button);
        sbook.addActionListener(this);
        bk.add(sbook);
		
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==sbook ){
			
			String Bookid= ts.getText();
			FirstClass f1 = new FirstClass();
			b1 = f1.fetchBookRecordObj(Bookid);
			if(b1.getBookName() == null){
				JOptionPane.showMessageDialog(null, "Book Not Found!");
			}
			else{
				new SearchDetails( b1.getAuthorName(), b1.getBookName(), b1.getStatus(), b1.getBookId() );
			}
		}
		
		//f.setVisible(true);
	}
	public static void main(String args[])
	{
		new SearchBook();
	}
}