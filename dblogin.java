import java.sql.*;
public class dblogin { 
	public static int data(String name,String address,String email,String pass,String id){
		int status=0;
		try{
			
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(NAME,ADDRESS,EMAIL,PASSWORD,NUMBER) values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3,email);
			ps.setString(4, pass);
			ps.setString(5, id);
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean match(String name,String pass){
		boolean status=false;
		try{
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT NAME, ADDRESS, EMAIL, PASSWORD, NUMBER FROM register WHERE NAME=? AND PASSWORD=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int show(String id,String accept){
		int status=0;
		try{
			
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into viewuser(ID,Accept) values(?,?)");
			ps.setString(1,id);
			ps.setString(2,accept);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			
			Connection con=Resconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from booking where BOOK_ID=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
		return status;
	}




}
