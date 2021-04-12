package com.controller;

import java.sql.*;
import java.util.*;
import com.java.Payment;

import com.config.dbconnector;

public class cntPayment {
	 
		
		Connection con = null;
		
		public cntPayment()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Payment>getPayments(){
	   	 
	   	 List<Payment> payments = new ArrayList<>();
	   	 String sql = "select * from payment";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Payment p = new Payment();
					  p.setPID(rs.getInt(1));
					  p.setCardName(rs.getString(2));
					  p.setCardNo(rs.getInt(3));
					  p.setZipCode(rs.getInt(4));
					  p.setBID(rs.getInt(5));
					  p.setCID(rs.getInt(6));				   
					  
					  payments.add(p);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return payments;
	    }
	        
	    
	    public Payment getPayment(int pid)
	    
	    {
	   	 String sql = "select * from payment where PID="+pid;
	   	  Payment p = new Payment();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  p.setPID(rs.getInt(1));
					  p.setCardName(rs.getString(2));
					  p.setCardNo(rs.getInt(3));
					  p.setZipCode(rs.getInt(4));
					  p.setBID(rs.getInt(5));
					  p.setCID(rs.getInt(6));	
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p;
	    }

		public void create(Payment p1) 
		{
			String sql = "insert into payment values(?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getPID());
			  st.setString(2, p1.getCardName());
			  st.setInt(3, p1.getCardNo());
			  st.setInt(4, p1.getZipCode());
			  st.setInt(5, p1.getBID());
			  st.setInt(6, p1.getCID());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Payment p1) 
		{
			String sql = "update payment set cardName=?,cardNo=?,zipCode=?,bid=?,cid=? where pid=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setString(1, p1.getCardName());
			  st.setInt(2, p1.getCardNo());
			  st.setInt(3, p1.getZipCode());
			  st.setInt(4, p1.getBID());
			  st.setInt(5, p1.getCID());
			  st.setInt(6, p1.getPID());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int pid) {

			String sql = "delete from payment where PID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, pid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
