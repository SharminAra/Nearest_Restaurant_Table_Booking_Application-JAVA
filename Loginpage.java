import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.FontSizeAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class Loginpage extends JFrame{
	private Container c;
	private JLabel imgLabel;
	private JButton admin,user;
	private ImageIcon img;
	private Font f;
	Loginpage()
	{
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.white);
		f=new Font("",Font.BOLD,30);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		 img=new ImageIcon(getClass().getResource("bg.jpg"));
		imgLabel=new JLabel(img);
		 imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	add(imgLabel); 
	
	
	admin=new JButton("Admin");
	admin.setBounds(120,510,150,70);
	admin.setBackground(Color.yellow);
	admin.setFont(f);
	add(admin);
    admin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Adminlogin.main(new String[] {});
			Loginpage.this.dispose();
			
		}
	});
	
	
	user=new JButton("User");
	user.setBounds(300,510,150,70);
	user.setBackground(Color.yellow);
	user.setFont(f);
	add(user);
	user.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Userlogin.main(new String[] {});
			Loginpage.this.dispose();
			
		}
	});
	
	
	
	 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginpage frame=new Loginpage();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("RESTAURANT");
		
	}

}
