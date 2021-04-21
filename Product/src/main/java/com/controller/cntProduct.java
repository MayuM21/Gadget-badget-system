package com.controller;

import java.sql.*;
import java.util.*;
import com.java.Product;

import com.config.dbconnector;

public class cntProduct {
	 
		
		Connection con = null;
		
		public cntProduct()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Product>getProducts(){
	   	 
	   	 List<Product> products = new ArrayList<>();
	   	 String sql = "select * from product";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Product p = new Product();
					  p.setPID(rs.getInt(1));
					  p.setProductName(rs.getString(2));
					  p.setRpaperType(rs.getString(3));
					  p.setPrice(rs.getDouble(4));
					
					  products.add(p);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return products;
	    }
	        
	    
	    public Product getProduct(int pid)
	    
	    {
	   	 String sql = "select * from product where PID="+pid;
	   	  Product p = new Product();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  p.setPID(rs.getInt(1));
					  p.setProductName(rs.getString(2));
					  p.setRpaperType(rs.getString(3));
					  p.setPrice(rs.getDouble(4));
					  	
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p;
	    }

		public void create(Product p1) 
		{
			String sql = "insert into product values(?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getPID());
			  st.setString(2, p1.getProductName());
			  st.setString(3, p1.RpaperType());
			  st.setDouble(4, p1.getPrice());
			 
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Product p1) 
		{
			String sql = "update product set cardName=?,cardNo=?,zipCode=?,bid=?,cid=? where pid=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(1, p1.getPID());
			  st.setString(2, p1.getProductName());
			  st.setString(3, p1.RpaperType());
			  st.setDouble(4, p1.getPrice());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int pid) {

			String sql = "delete from product where PID=?";
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
