package com.controller;

import java.sql.*;

import java.util.*;
import com.java.Buyer;

import com.config.dbconnector;

public class cntBuyer {
	 
		
		Connection con = null;
		
		public cntBuyer()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Buyer>getBuyers(){
	   	 
	   	 List<Buyer> buyers = new ArrayList<>();
	   	 String sql = "select * from buyer";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Buyer b = new Buyer();
					  b.setBID(rs.getInt(1));
					  b.setBuyerName(rs.getString(2));
					  b.setBuyerMail(rs.getString(3));
					  b.setBuyerNo(rs.getInt(4));
					  b.setBuyerAddress(rs.getString(5));
					 				   
					 
					  buyers.add(b );
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return buyers;
	    }
	        
	    
	    public Buyer getBuyer(int bid)
	    
	    {
	   	 String sql = "select * from funder where BID="+bid;
	   	  Buyer b = new Buyer();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					  b.setBID(rs.getInt(1));
					  b.setBuyerName(rs.getString(2));
					  b.setBuyerMail(rs.getString(3));
					  b.setBuyerNo(rs.getInt(4));
					  b.setBuyerAddress(rs.getString(5));
					 
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return b;
	    }

		public void create(Buyer b1) 
		{
			String sql = "insert into buyer values(?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, b1.getBID());
			  st.setString(2, b1.getBuyerName());
			  st.setString(3, b1.getBuyerMail());
			  st.setInt(4, b1.getBuyerNo());
			  st.setString(5, b1.getBuyerAddress());
		
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Buyer b1) 
		{
			String sql = "update buyer set buyerName=?,buyerMail=?,buyerNo=?,buyeraddress=?, where bid=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(1, b1.getBID());
			  st.setString(2, b1.getBuyerName());
			  st.setString(3, b1.getBuyerMail());
			  st.setInt(4, b1.getBuyerNo());
			  st.setString(5, b1.getBuyerAddress());

	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int bid) {

			String sql = "delete from buyer where BID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, bid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
