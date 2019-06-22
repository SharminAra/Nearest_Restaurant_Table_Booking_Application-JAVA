import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import java.util.Date;

public class Book_Table extends JFrame{
	private Container c;
	private JLabel imgLabel;
	private ImageIcon img;
	private JLabel textlabel1,textlabel2,textlabel3,textlabel4,textlabel5,textlabel6,textlabel7,textlabel8,textlabel9,textlabel10;
	private JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private static JTextField tf8;
	private JButton Submit,cancel,table;
	private JComboBox cb;
	private String[] resname = {"dawat","HANDI restaurant","Sanmar food cort","Sadia's kitchen","Fish n Chips"};
	
	
	private Font f;

	 Book_Table()
	
	{
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.pink );
		f=new Font("",Font.BOLD,15);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("H:\\bac.jpg")));
		
		textlabel1=new JLabel("NAME:");
		textlabel1.setBounds(10,25,150,40);
		textlabel1.setFont(f);
		add(textlabel1);
		tf1=new JTextField();
		tf1.setBounds(118,25,150,40);
		tf1.setBackground(Color.white);
		add(tf1);
		textlabel2=new JLabel("LOC_X:");
		textlabel2.setBounds(10,80,150,40);
		textlabel2.setFont(f);
		add(textlabel2);
		tf2=new JTextField();
		tf2.setBounds(118,85,150,40);
		tf2.setBackground(Color.white);
		add(tf2);
		textlabel3=new JLabel("LOC_Y:");
		textlabel3.setBounds(300,80,150,40);
		textlabel3.setFont(f);
		add(textlabel3);
		tf3=new JTextField();
		tf3.setBounds(380,85,150,40);
		tf3.setBackground(Color.white);
		add(tf3);
		textlabel5=new JLabel("NUMBER:");
		textlabel5.setBounds(10,130,150,40);
		textlabel5.setFont(f);
		add(textlabel5);
		tf5=new JTextField();
		tf5.setBounds(118,135,150,40);
		tf5.setBackground(Color.white);
		add(tf5);
		textlabel4=new JLabel("DATE:");
		textlabel4.setBounds(300,130,150,40);
		textlabel4.setFont(f);
		add(textlabel4);
		tf4=new JTextField();
		tf4.setBounds(380,135,150,40);
		tf4.setBackground(Color.white);
		add(tf4);
		textlabel6=new JLabel("TIME:");
		textlabel6.setBounds(10,190,150,40);
		textlabel6.setFont(f);
		add(textlabel6);
		

		JTextArea ta2=new JTextArea();
		JScrollPane scroll2;
		scroll2=new JScrollPane(ta2);
		scroll2.setBounds(118, 280, 350, 80);
		add(scroll2);
		
		JButton bt= new JButton("Nearest Restaurant");
		bt.setBounds(200,240,150,30);
		add(bt);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String xc=tf2.getText();
				String yc=tf3.getText();
				
				int x1=Integer.parseInt(xc);
				int y1=Integer.parseInt(yc);
				String data[][]=null;
				 String column[]=null;
				 	int x;
					int y;
					int max=100000;
					int result;
					int[] cost = new int[1000];
					String temp="";
					int k=0;
					try{
						Connection con=Resconnection.getConnection();
						PreparedStatement ps=con.prepareStatement("select * from rescordinate",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
							x=rs.getInt(2);
							y=rs.getInt(3);

							result=(int) Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y1),2));
							cost[k]=result;
							if(result<max)
							{
								max=result;
								String z=rs.getString(1);
								temp=temp+"\n"+z+"\n";
								ta2.setText(temp);

							}
							else
							{
								String z=rs.getString(1);
								temp=temp+"\n"+z+"\n";
								ta2.setText(temp);
							}
					
							k++;
							
							count++;
						}
						//String xx= Integer.toString(max);
						//ta2.setText(xx);

						con.close();
					}catch(Exception e1){System.out.println(e1);}
				
				
			}
		});
			
		tf6=new JTextField();
		tf6.setBounds(118,195,150,40);
		tf6.setBackground(Color.white);
		add(tf6);
		
		JTextArea ta=new JTextArea();
		JScrollPane scroll;
		scroll=new JScrollPane(ta);
		scroll.setBounds(118, 500, 350, 60);
		add(scroll);
		
		textlabel7=new JLabel("Enter number:");
		textlabel7.setBounds(10,600,150,40);
		textlabel7.setFont(f);
		add(textlabel7);
		tf7=new JTextField();
		tf7.setBounds(118,600,150,40);
		tf7.setBackground(Color.white);
		add(tf7);
		
		textlabel8=new JLabel("RESTAURANT:");
		textlabel8.setBounds(10,380,150,40);
		textlabel8.setFont(f);
		add(textlabel8);
		/*JTextArea ta1=new JTextArea();
		JScrollPane scroll1;
		scroll=new JScrollPane(ta1);
		scroll.setBounds(118, 385, 350, 30);
		add(scroll);*/
		
		tf8=new JTextField();
		tf8.setBounds(118, 385, 350, 30);
		tf8.setBackground(Color.white);
		add(tf8);
		
		/*cb=new JComboBox(resname);
		cb.setBounds(118,360,150,40);
		cb.setEditable(true);
		c.add(cb);*/
		
		String xc=tf2.getText();
		String yc=tf3.getText();
		
		table=new JButton("Choose Your Table");
		table.setBounds(180,460,200,30);
		//table.setBackground(Color.lightGray);
		table.setFont(f);
		add(table);
		table.addActionListener(new ActionListener() {
			
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String res=tf8.getText();
				
				String data[][]=null;
				String column[]=null;
				int x;
				String z="";
				
				try{
					Connection con=Resconnection.getConnection();
					PreparedStatement ps=con.prepareStatement("select Total_Table from tablenum where ResName= '"+tf8.getText()+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
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
						
						int tables= rs.getInt(1);
						for(int i1=1;i1<=tables;i1++)
						{
							x=i1;
							String xy= String.valueOf(x);
							z=z+"      "+xy;
							
						}
						ta.setText(z);
						ta.getSelectedTextColor();
						ta.getDisabledTextColor();
						ta.setFont(f);
						
					    

						count++;
					}
					con.close();
				}catch(Exception e1){System.out.println(e1);}
				
				
				
				
			} 
		});	  
				
		
	
		
		cancel=new JButton("Back");
		cancel.setBounds(25,660,150,30);
		//cancel.setBackground(Color.white);
		cancel.setFont(f);
		add(cancel);
		
		
cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User_Section.main(new String[] {});
				Book_Table.this.dispose();
				
			}
		});


	 
		
		Submit=new JButton("Submit");
		Submit.setBounds(300,600,100,60);
		//Submit.setBackground(Color.white);
		Submit.setFont(f);
		add(Submit);
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name=tf1.getText();
				String corx=tf2.getText();
				String cory=tf3.getText();
				String number=tf5.getText();
				String date=tf4.getText();
				String time=tf6.getText();
				String table=tf7.getText();
				String res=tf8.getText();
				
				
		int i=dbbooktable.data(name,corx,cory,number,date,time,table,res);
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(Book_Table.this,"DONE!");
				//MyAlgo.main(new String[] {});
					
					
				
				}
				
				else
				{
					JOptionPane.showMessageDialog(Book_Table.this,"ERROR!");

				}				
				
				String data[][]=null;
				String column[]=null;
				
				try{
					Connection con=Resconnection.getConnection();
					PreparedStatement ps=con.prepareStatement("select * from booking",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					//PreparedStatement ps=con.prepareStatement("select Total_Table from booking where ResName= '"+tf8.getText()+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=ps.executeQuery();
					
					
					
					ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					column=new String[cols];
					for(int i1=1;i1<=cols;i1++){
						column[i1-1]=rsmd.getColumnName(i1);
					}
					
					rs.last();
					int rows=rs.getRow();
					rs.beforeFirst();

					data=new String[rows][cols];
					int count=0;
					while(rs.next()){
						for(int i1=1;i1<=cols;i1++){
							data[count][i1-1]=rs.getString(i1);
						}
						
						String tables= rs.getString(1);
						ta.setText(tables);
						ta.setFont(f);
						
					    

						count++;
					}
					con.close();
				}catch(Exception e1){System.out.println(e1);}
				
				
				
				
			} 
		});	  
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book_Table frame=new Book_Table();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,800);
		frame.setTitle("Book_Table");
	}

}

