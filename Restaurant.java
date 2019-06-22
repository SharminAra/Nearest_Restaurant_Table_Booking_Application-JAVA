import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Restaurant extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JButton back,Next;
	private JComboBox cb;
	private String[] resname = {"CAFE MILANO","HANDI RESTAURANT","SANMAR FOOD CORNER","SADIA'S KITCHEN ","FISH N CHIPS"};
	
	private Container c;
	Restaurant()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(Color.lightGray );
		setBounds(0,0,600,800);
		c=this.getContentPane();
		c.setBackground(Color.pink );
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		c.setLayout(null );
		cb=new JComboBox(resname);
		cb.setBounds(20,80,200,50);
		cb.setEditable(true);
		add(cb);
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from dijkstra",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		sp.setBounds(10,200,550,210);
		add(sp);
		back=new JButton("Back");
		back.setBounds(150,500,100,50);
		back.setBackground(Color.lightGray);
		add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//User_Section.main(new String[] {});
				Restaurant.this.dispose();
				
			}
		});
		Next=new JButton("Next");
		Next.setBounds(300,500,100,50);
		Next.setBackground(Color.lightGray);
		add(Next);
		Next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Book_Table.main(new String[] {});
				Restaurant.this.dispose();
				
			}
		});
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurant frame=new Restaurant();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);

	}

}
