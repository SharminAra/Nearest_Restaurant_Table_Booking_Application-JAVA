
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame {
	
	
	private Container c;
	private JLabel textlabel1,textlabel2,textlabel3,textlabel4,textlabel5;
	private JTextField tf1,tf2,tf3,tf4,tf5;
	private JLabel imgLabel;
	private JPasswordField passwordField;
	private JButton Submit,cancel;
	private ImageIcon img;
	private Font f;
	Register()
	{
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.pink);
		f=new Font("",Font.BOLD,15);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		/*img=new ImageIcon(getClass().getResource("register.jpg"));
		imgLabel=new JLabel(img);
		 imgLabel.setBounds(250,0,500,370);
	c.add(imgLabel);
	*/
	
		 
		textlabel1=new JLabel("Name:");
		textlabel1.setBounds(10,25,150,40);
		textlabel1.setFont(f);
		add(textlabel1);
		tf1=new JTextField();
		tf1.setBounds(85,30,150,40);
		tf1.setBackground(Color.lightGray);
		add(tf1);
		textlabel2=new JLabel("Address:");
		textlabel2.setBounds(10,80,150,40);
		textlabel2.setFont(f);
		add(textlabel2);
		tf2=new JTextField();
		tf2.setBounds(85,85,150,40);
		tf2.setBackground(Color.lightGray);
		add(tf2);
		textlabel3=new JLabel("E-mail:");
		textlabel3.setBounds(10,135,150,40);
		textlabel3.setFont(f);
		add(textlabel3);
		tf3=new JTextField();
		tf3.setBounds(85,140,150,40);
		tf3.setBackground(Color.lightGray);
	    add(tf3);
		textlabel5=new JLabel("Password:");
		textlabel5.setBounds(10,195,150,40);
		textlabel5.setFont(f);
		add(textlabel5);
		passwordField=new JPasswordField();
		passwordField.setBounds(85,195,150,40);
		passwordField.setBackground(Color.lightGray);
		add(passwordField);
		textlabel4=new JLabel("Number:");
		textlabel4.setBounds(10,250,150,40);
		textlabel4.setFont(f);
		add(textlabel4);
		tf4=new JTextField();
		tf4.setBounds(85,250,150,40);
		tf4.setBackground(Color.lightGray);
		add(tf4);
	
		Submit=new JButton("Submit");
		Submit.setBounds(300,400,150,70);
		Submit.setBackground(Color.lightGray);
		Submit.setFont(f);
		add(Submit);
		cancel=new JButton("Back");
		cancel.setBounds(100,400,150,70);
		cancel.setBackground(Color.lightGray);
		cancel.setFont(f);
		add(cancel);
	    cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Userlogin.main(new String[] {});
				
				Register.this.dispose();
			}
		});

	    
Submit.addActionListener(new ActionListener() {
			
	

	
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=tf1.getText();
				String address=tf2.getText();
				String email=tf3.getText();
				String pass=String.valueOf(passwordField.getText());
				String id=tf4.getText();
                int i=dblogin.data(name,address,email,pass,id);
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(Register.this,"Successfully Registered!");
					Userlogin.main(new String[]{});
					Register.this.dispose();
				}
				
				
				
				
				else 
				{
					JOptionPane.showMessageDialog(Register.this,"Registration Failed!");

				}				
				
			
			}

});
			
	    
	    
	}
	    
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register frame=new Register();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("REGISTER");

	}
	 


}
