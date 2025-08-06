import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeletePage1 extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1, l2, background;
    JTextField t1, t2;
    JButton b;
    Connection conn;

    DeletePage1() {
        // Title Name
        f=new JFrame("Delete Page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 500);

        ImageIcon img1 = new ImageIcon(getClass().getResource("Picsart_23-07-06_20-49-02-089.jpg"));
        background = new JLabel(img1);
        //background.setBounds(0, 0, 800, 500);
        f.add(background);
        f.pack();

        // Label
        l1 = new JLabel("BOOK NAME :");
        l1.setBounds(690, 200, 250, 30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        background.add(l1);

        l2 = new JLabel("BOOK ID  :");
        l2.setBounds(710, 280, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        background.add(l2);

        // TextField
        t1 = new JTextField();
        t1.setBounds(650, 240, 250, 30);
        t1.setFont(new Font("Arial Black", Font.BOLD, 15));
        background.add(t1);

        t2 = new JTextField();
        t2.setBounds(650, 320, 250, 30);
        t2.setFont(new Font("Arial Black", Font.BOLD, 15));
        background.add(t2);

        // Button
        b = new JButton("DELETE");
        b.setBounds(720, 400, 100, 30);
        b.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
        b.addActionListener(this);
        background.add(b);

        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
	
		String Bookname = t1.getText();
		String BookId = t2.getText();
		
		if(e.getSource()== b){
			FirstClass DatabaseObj = new FirstClass();
			boolean status = DatabaseObj.fetchBookRecord(BookId);
			if(status)
			{
				JOptionPane.showMessageDialog(null, "Book Can not Deleted as it was Issued!!");
			}
			else
			{
				int rowsAffected = DatabaseObj.deleteBookInDB(Bookname, BookId);
			
				if (rowsAffected > 0) 
				{
					JOptionPane.showMessageDialog(null, "Book deleted successfully!");
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Book not found!");
				}
			}
			new MenuPage();
		}	
    }

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> {
            new DeletePage1();
       // });
    }
}
