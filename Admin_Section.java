import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Admin_Section extends JFrame {
	
	private Container c;
	private Font f;
	private JButton customer,view,Logout,add;
	
	Admin_Section()
	{
		 c= this.getContentPane();
			
			c.setLayout(null);
			c.setBackground(Color.pink);
			f=new Font("",Font.BOLD,20);
			setLayout(new BorderLayout());
			setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
			
			customer=new JButton("VIEW USER");
			customer.setBounds(50,150,300,70);
			customer.setBackground(Color.lightGray);
			customer.setFont(f);
			add(customer);
			
customer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					View_User.main(new String[] {});
					Admin_Section.this.dispose();
					
				}
			});


			
			
			
			view=new JButton("VIEW BOOKINGS");
			view.setBounds(50,250,300,70);
			view.setBackground(Color.lightGray);
			view.setFont(f);
			add(view);
			
view.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					viewbookings.main(new String[] {});
					Admin_Section.this.dispose();
					
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
					Admin_Section.this.dispose();
					
				}
			});
			
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin_Section frame=new Admin_Section();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("RESTAURANT");
	}

}
