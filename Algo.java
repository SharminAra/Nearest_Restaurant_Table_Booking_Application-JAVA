
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.*; 

public class Algo {
	private Container c;
	private JComboBox cb;
	private JButton back,Next;
	private String[] resname = {"Cafe Milano","HANDI resturant","Sanmar food cort","Sadia's Kitchen","Fish n Chips"};
	
	
	Algo(){
		c=this.getContentPane();
		c.setLayout(null );
		c.setBackground(Color.pink);
		
		cb=new JComboBox(resname);
		cb.setBounds(50,100,200,50);
		cb.setEditable(true);
		c.add(cb);
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

		JTable table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		sp = new JScrollPane(table);
		sp.setBounds(50,200,500,100);
		c.add(sp);
	}

	

	private Container getContentPane() {
		return null;
	}



    int minDistance(int dist[], Boolean sptSet[]) 
    { 
       
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < v; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
   
    void printSolution(int dist[], int n) 
    { 
      
        int v = 0;
		for (int i = 0; i < v; i++) 
            System.out.println(i + " " + dist[i]); 
    } 
  
    
    void dijkstra(int graph[][], int src) 
    { 
        int v = 0;
		int dist[] = new int[v]; 
        
        Boolean sptSet[] = new Boolean[v]; 
  
   
        for (int i = 0; i < v; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        dist[src] = 0; 
  
        
        for (int count = 0; count < v - 1; count++) { 
             
            int u = minDistance(dist, sptSet); 
  
            sptSet[u] = true; 
  
            
            for (int v1 = 0; v1 < v1; v1++) 
   
                if (!sptSet[v1] && graph[u][v1] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v1] < dist[v1]) 
                    dist[v1] = dist[u] + graph[u][v1]; 
        } 
   
        printSolution(dist, v); 
    } 
   
    public static void main(String[] args) 
    { 
      
        Algo t = new Algo(); 
        int[][] graph = null;
		t.dijkstra(graph, 0); 
    } 

}
