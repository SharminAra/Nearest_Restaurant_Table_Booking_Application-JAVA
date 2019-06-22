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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Adminlogin extends JFrame implements ActionListener {
	
	private Container c;
	private JLabel imgLabel,textlabel1,textlabel2;
	private JPasswordField passwordField;
	private JTextField tf1;
	private JButton login,cancel;
	private ImageIcon img;
	private Font f;
	Adminlogin()
	{
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.pink );
		f=new Font("",Font.BOLD,15);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		img=new ImageIcon(getClass().getResource("adminn.jpg"));
		imgLabel=new JLabel(img);
		 imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	add(imgLabel); 
	
	textlabel1=new JLabel("Name:");
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
	passwordField=new JPasswordField();
	passwordField.setBounds(120,495,150,40);
	passwordField.setBackground(Color.lightGray);
	add( passwordField);
	
	login=new JButton("Login");
	login.setBounds(120,550,150,70);
	login.setBackground(Color.lightGray);
	login.setFont(f);
	login.addActionListener(this);
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
			Adminlogin.this.dispose();
			
		}
	});
	
	
	 
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adminlogin frame=new Adminlogin();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("ADMIN_PAGE");

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			String name=tf1.getText();
			String password=passwordField.getText();
			
				if(name.equals("admin")&&password.equals("123")){
					Admin_Section.main(new String[]{});
				}
				else{
					JOptionPane.showMessageDialog(Adminlogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
					passwordField.setText("");
				}
		}
		
	}


	

}
