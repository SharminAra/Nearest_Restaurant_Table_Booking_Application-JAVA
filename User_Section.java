import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class User_Section extends JFrame {
private Container c;
private Font f;
private JButton details,table,status,Logout;
 

User_Section()
	
	{
	     c= this.getContentPane();
	
		c.setLayout(null);
		c.setBackground(Color.pink);
		f=new Font("",Font.BOLD,20);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		
		table=new JButton("BOOK TABLE");
		table.setBounds(50,150,300,70);
		table.setBackground(Color.lightGray);
		table.setFont(f);
		add(table);
		
		status=new JButton("CHECK STATUS");
		status.setBounds(50,250,300,70);
		status.setBackground(Color.lightGray);
		status.setFont(f);
		add(status);
status.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkstatus.main(new String[] {});
				User_Section.this.dispose();
				
			}
		});
		Logout=new JButton("LOGOUT");
		Logout.setBounds(50,350,300,70);
		Logout.setBackground(Color.lightGray);
		Logout.setFont(f);
		add(Logout);
		Logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Loginpage.main(new String[] {});
				User_Section.this.dispose();
				
			}
		});
		
table.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Book_Table.main(new String[] {});
				User_Section.this.dispose();
				
			}
		});
		
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User_Section frame=new User_Section();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("RESTAURANT");
	}

}
                                                                                                                                                                                 