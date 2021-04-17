package com.controller;

import java.sql.*;
import java.util.*;

import com.config.dbconnector;
import com.java.Card;

public class cntCard {
Connection con = null;
	
	public cntCard()
	{		 
		con = dbconnector.connector();
	} 

public List<Card>getCards(){
   	 
   	 List<Card> cards = new ArrayList<>();
   	 String sql = "select * from card";
   	 try 
   	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  while(rs.next())
			  {
				  Card c = new Card();
				  c.setCID(rs.getInt(1));
				  c.setPrice(rs.getDouble(2));
				  c.setPRID(rs.getInt(3));
				  c.setBID(rs.getInt(4));				   
				  
				  cards.add(c);
			  }
			
		    } 
   	 catch (Exception e) 
   	  {
			
		   System.out.println(e);
		  }
   	  
   	 return cards;
    }
        
    
    public Card getCard(int cid)
    
    {
   	 String sql = "select * from card where CID="+cid;
   	  Card c = new Card();
   	 try 
   	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  if(rs.next())
			  {			
				  c.setCID(rs.getInt(1));
				  c.setPrice(rs.getDouble(2));
				  c.setPRID(rs.getInt(3));
				  c.setBID(rs.getInt(4));	
			  }
			
		    } 
   	 catch (Exception e) 
   	  {
			
		   System.out.println(e);
		  } 
   	 return c;
    }

	public void create(Card p1) 
	{
		String sql = "insert into card values(?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, p1.getCID());
		  st.setDouble(2, p1.getPrice());
		  st.setInt(3, p1.getPRID());
		  st.setInt(4, p1.getBID());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
	public void update(Card p1) 
	{
		String sql = "update card set Price=?,prid=?,bid=? where cid=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

		  st.setDouble(1, p1.getPrice());
		  st.setInt(2, p1.getPRID());
		  st.setInt(3, p1.getBID());
		  st.setInt(4, p1.getCID());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}



	public void delete(int cid) {

		String sql = "delete from card where CID=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, cid);
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 

	}



}
