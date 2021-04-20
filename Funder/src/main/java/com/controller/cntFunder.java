package com.controller;

import java.sql.*;

import java.util.*;
import com.java.Funder;

import com.config.dbconnector;

public class cntFunder {
	 
		
		Connection con = null;
		
		public cntFunder()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Funder>getFunders(){
	   	 
	   	 List<Funder> funders = new ArrayList<>();
	   	 String sql = "select * from funder";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Funder f = new Funder();
					  f.setFID(rs.getInt(1));
					  f.setFunderName(rs.getString(2));
					  f.setFunderMail(rs.getString(3));
					  f.setPhoneNo(rs.getInt(4));
					  f.setAddress(rs.getString(5));
					  f.setAmount(rs.getDouble(6));				   
					 
					  funders.add(f );
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return funders;
	    }
	        
	    
	    public Funder getFunder(int fid)
	    
	    {
	   	 String sql = "select * from funder where FID="+fid;
	   	  Funder f = new Funder();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					  f.setFID(rs.getInt(1));
					  f.setFunderName(rs.getString(2));
					  f.setFunderMail(rs.getString(3));
					  f.setPhoneNo(rs.getInt(4));
					  f.setAddress(rs.getString(5));
					  f.setAmount(rs.getDouble(6));	
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return f;
	    }

		public void create(Funder f1) 
		{
			String sql = "insert into funder values(?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, f1.getFID());
			  st.setString(2, f1.getFunderName());
			  st.setString(3, f1.getFunderMail());
			  st.setInt(4, f1.getPhoneNo());
			  st.setString(5, f1.getAddress());
			  st.setDouble(6, f1.getAmount());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Funder f1) 
		{
			String sql = "update funder set funderName=?,funderMail=?,phoneNo=?,address=?,amount=? where fid=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(1, f1.getFID());
			  st.setString(2, f1.getFunderName());
			  st.setString(3, f1.getFunderMail());
			  st.setInt(4, f1.getPhoneNo());
			  st.setString(5, f1.getAddress());
			  st.setDouble(6, f1.getAmount());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int fid) {

			String sql = "delete from funder where FID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, fid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
