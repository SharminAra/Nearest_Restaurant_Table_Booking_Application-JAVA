
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View_User extends JFrame {

	private JPanel contentPane;
	private JLabel textlabel1,textlabel2;
	private JTextField tf1,tf2;
	private JButton Submit,cancel;
	private JTable table;
	private JButton back,next;
	private Container c;
	private Font f;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_User frame = new View_User();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public View_User() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(Color.lightGray );
		setBounds(0,0,600,800);
		c=this.getContentPane();
		c.setBackground(Color.pink );
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		c.setLayout(null );
		
		
	    textlabel1=new JLabel("ID:");
		textlabel1.setBounds(10,270,150,40);
		textlabel1.setFont(f);
		add(textlabel1);
		tf1=new JTextField();
		tf1.setBounds(85,270,150,40);
		tf1.setBackground(Color.lightGray);
		add(tf1);
		textlabel2=new JLabel("Accept:");
		textlabel2.setBounds(10,320,150,40);
		textlabel2.setFont(f);
		add(textlabel2);
		tf2=new JTextField();
		tf2.setBounds(85,320,150,40);
		tf2.setBackground(Color.lightGray);
		add(tf2);
	
			
		Submit=new JButton("Submit");
		Submit.setBounds(300,400,150,70);
		Submit.setBackground(Color.lightGray);
		Submit.setFont(f);
		add(Submit);
		
		
		
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=tf1.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(View_User.this,"Id can't be blank");
				}else{
					int id=Integer.parseInt(sid);
					int i=dblogin.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(View_User.this,"Record deleted successfully!");
						viewbookings.main(new String[] {});
						View_User.this.dispose();
					}else{
						JOptionPane.showMessageDialog(View_User.this,"Unable to delete given id!");
					}
				}
			}
		});
		cancel=new JButton("Back");
		cancel.setBounds(100,400,150,70);
		cancel.setBackground(Color.lightGray);
		cancel.setFont(f);
		add(cancel);
	    cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Section.main(new String[] {});
				View_User.this.dispose();
				
			}
		});

	    
Submit.addActionListener(new ActionListener() {
			
	

	
			@Override
			public void actionPerformed(ActionEvent e) {
				String 	id=tf1.getText();
				String accept=tf2.getText();
int i=dblogin.show(id,accept);
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(View_User.this,"Successfully added!");
					//viewbookings.main(new String[]{});
				}
				
				
				else 
				{
					JOptionPane.showMessageDialog(View_User.this,"Failed!");

				}				
				
			
			}

});

		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from booking",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		sp = new JScrollPane(table);
		sp.setBounds(50,50,500,200);
		add(sp);
		
		
	}

}