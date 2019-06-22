import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class dbbooktable { 
	public static int data(String name,String corx,String cory,String number,String date,String time,String table,String res){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO booking(NAME,LOC_X,LOC_Y,NUMBER,DATE_T,TIME_T,TABLE_NO,RESTAURANT) VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2,corx);
			ps.setString(3, cory);
			ps.setString(4, number);
			ps.setString(5, date);
			ps.setString(6, time);
			ps.setString(7, table);
			ps.setString(8, res);
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	



}

