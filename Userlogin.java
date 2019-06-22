import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Userlogin extends JFrame{
	private Container c;
	private JLabel imgLabel,textlabel1,textlabel2;
	
	private JTextField tf1;
	private JPasswordField tf2;
	private JButton login,cancel,register;
	private ImageIcon img;
	private Font f;
	Userlogin()
	{
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.pink);
		
		f=new Font("",Font.BOLD,15);

		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		img=new ImageIcon(getClass().getResource("login.jpg"));
		imgLabel=new JLabel(img);
		 imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	add(imgLabel); 
	
	textlabel1=new JLabel("Username:");
	textlabel1.setBounds(40,430,150,70);
	textlabel1.setFont(f);
	add(textlabel1);
	tf1=new JTextField();
	tf1.setBounds(120,445,150,40);
	tf1.setBackground(Color.lightGray);
	add(tf1);
	textlabel2=new JLabel("Password:");
	textlabel2.setBounds(40,480,150,70);
	textlabel2.setFont(f);
	add(textlabel2);
	tf2=new JPasswordField();
	tf2.setBounds(120,495,150,40);
	tf2.setBackground(Color.lightGray);
	add(tf2);
	
	login=new JButton("Login");
	login.setBounds(120,550,150,70);
	login.setBackground(Color.lightGray);
	login.setFont(f);
	add(login);
	
	cancel=new JButton("Cancel");
	cancel.setBounds(300,550,150,70);
	cancel.setBackground(Color.lightGray);
	cancel.setFont(f);
	add(cancel);
    cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Loginpage.main(new String[] {});
			Userlogin.this.dispose();
			
		}
	});
	
    register=new JButton("Register");
	register.setBounds(210,630,170,40);
	register.setBackground(Color.lightGray);
	register.setFont(f);
	add(register);
register.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Register.main(new String[] {});
			Userlogin.this.dispose();
			
		}
	});
login.addActionListener(new ActionListener() {
	

	public void actionPerformed(ActionEvent e) {
	String name=tf1.getText();
	String pass=String.valueOf(tf2.getPassword());
	
	if(dblogin. match( name, pass)){
		User_Section.main(new String[]{});
		Userlogin.this.dispose();
		
	}else{
		JOptionPane.showMessageDialog(Userlogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		tf2.setText("");
	}
	}
});
	
	
	 
	}
	 
	 

	public static void main(String[] args) {
		Userlogin frame=new Userlogin();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("RESTAURANT");

	}

}
