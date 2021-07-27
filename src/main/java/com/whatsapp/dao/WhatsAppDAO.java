package com.whatsapp.dao;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.whatsapp.entity.whatsappUser;

public class WhatsAppDAO implements WhatsAppDAOInterface {

	public int createProfileDAO(whatsappUser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
			
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, ws.getName());
			ps.setString(2, ws.getPassword());
			ps.setString(3, ws.getEmail());
			ps.setString(4, ws.getAddress());
		
			
			i=ps.executeUpdate(); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public  whatsappUser viewProfileDAO(whatsappUser ws) {
		
		whatsappUser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
			
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=?");
			ps.setString(1, ws.getEmail());
			
		
			
			ResultSet res=ps.executeQuery(); 
			if(res.next()) {
				ww=new whatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}
	

	
	public List<whatsappUser> viewAllProfileDAO() {
		List<whatsappUser> ll=new ArrayList<whatsappUser>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
		
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser");
			
			
		
			
			ResultSet res=ps.executeQuery(); 
			while(res.next()) {
				whatsappUser ww=new whatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
				
				ll.add(ww);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	public  int deleteProfileDAO(whatsappUser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
			
			PreparedStatement ps=con.prepareStatement("delete from whatsappuser where email=?");
		    
			ps.setString(1, ws.getEmail());
			
			
			i=ps.executeUpdate(); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;


	}

	
       
	

	public int editProfileDAO(whatsappUser ws) {
		
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
			
			PreparedStatement ps=con.prepareStatement("Update whatsappuser set password=? where email=?");
			//ps.setString(1, ws.getName());
			ps.setString(1, ws.getPassword());
			ps.setString(2, ws.getEmail());
		//	ps.setString(4, ws.getAddress());
		
			
			i=ps.executeUpdate(); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public whatsappUser searchProfileDAO(whatsappUser ws) {
		whatsappUser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys","root","L@lith@918");
			
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=?");
			ps.setString(1, ws.getEmail());
			
		
			
			ResultSet res=ps.executeQuery(); 
			if(res.next()) {
				ww=new whatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	
	}