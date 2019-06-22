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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class viewbookings extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel x;
	private JButton back;
	private Container c;
	private Font f;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewbookings frame = new viewbookings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viewbookings() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setBounds(0,0,600,800);
		c=this.getContentPane();
		c.setBackground(Color.pink );setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		
		c.setLayout(null );
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from viewuser",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		sp.setBounds(50,100,500,200);
		add(sp);
		f=new Font("",Font.BOLD,20);
		x=new JLabel("Confirmation Table");
		x.setBounds(200,40,200,60);
		x.setFont(f);
		add(x);
		back=new JButton("Back");
		back.setBounds(200,350,100,50);
		back.setBackground(Color.LIGHT_GRAY);
		add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Section.main(new String[] {});
				viewbookings.this.dispose();
				
			}
		});
	}

}
