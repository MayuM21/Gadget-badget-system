package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Researchers {

	//A common method to connect to the DB 
		private Connection connect() {
			Connection con = null;
			
			try {
				 Class.forName("com.mysql.jdbc.Driver");
				 //Provide the correct details: DBServer/DBName, username, password 
				 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/gadget_badget_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

				//For testing          
				 System.out.print("Successfully connected");
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return con; 
		}
		
		public String readResearchers() {  
			String output = "";  
			
			try {  
				Connection con = connect();  
				if (con == null)  {   
					return "Error while connecting to the database for reading.";  
				} 

				// Prepare the html table to be displayed   
				output = "<table border='1'><tr><th>fullName</th>"
						+ "<th>mobile</th><th>email</th>"
						+ "<th>NIC</th><th>Address</th>"
						+ "<th>Date</th>"
						+"<th>Message</th>"
						+ "<th>Update</th><th>Remove</th></tr>";


				  String query = "select * from researcher";   
				  Statement stmt = con.createStatement();   
				  ResultSet rs = stmt.executeQuery(query); 

				  // iterate through the rows in the result set   
				  while (rs.next())   {  

					  	String appID = Integer.toString(rs.getInt("appID"));
						String fullName = rs.getString("fullName");
						String mobile = Integer.toString(rs.getInt("mobile"));
						String email = rs.getString("email");
						String nic = rs.getString("nic");
						String address = rs.getString("address");
						String date = rs.getString("date");
						String msg = rs.getString("msg");
					  // Add into the html table    

					  output += "<tr><td><input id='hidAppIDUpdate' name='hidAppIDUpdate' type='hidden' value='" + appID + "'>" + fullName + "</td>"; 

					  output += "<td>" + mobile + "</td>";
						output += "<td>" + email + "</td>";
						output += "<td>" + nic + "</td>";
						output += "<td>" + address + "</td>";
						output += "<td>" + date + "</td>";
						output += "<td>" + msg + "</td>"; 
					  
					// buttons     
					  output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
					  		+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-appID='"+ appID +"'>"+"</td></tr>";

					} 
				  
				  con.close(); 

				  // Complete the html table   
				  output += "</table>"; 
				}
				catch (Exception e) {  
					output = "Error while reading the researcher.";  
					System.err.println(e.getMessage()); 
				}

				return output;
			}
		
		//Insert researcher
		public String insertResearchers(String fullName, String mobile, String email, String nic, String address, String date,  String msg) {
			String output = "";

			try {
				Connection con = connect();  

				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement   
				String query = " insert into researcher (`appID`,`fullName`,`mobile`,`email`,`nic`, `address`,`date`,`msg`)"+" values (?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values 
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, fullName);
				preparedStmt.setString(3, mobile);
				preparedStmt.setString(4, email);
				preparedStmt.setString(5,nic);
				preparedStmt.setString(6, address);
				preparedStmt.setString(7, date);
				preparedStmt.setString(8, msg);
				
				//execute the statement   
				preparedStmt.execute();   
				con.close(); 

				//Create JSON Object to show successful msg.
				String newResearchers = readResearchers();
				output = "{\"status\":\"success\", \"data\": \"" + newResearchers + "\"}";
			}
			catch (Exception e) {  
				//Create JSON Object to show Error msg.
				output = "{\"status\":\"error\", \"data\": \"Error while Inserting Researchers.\"}";   
				System.err.println(e.getMessage());  
			} 

			 return output; 
		}
		
		//Update researcher
		public String updateResearchers(String appID, String fullName, String mobile, String email, String nic, String address, String date, String msg )  {   
			String output = ""; 
		 
		  try   {   
			  Connection con = connect();
		 
			  if (con == null)    {
				  return "Error while connecting to the database for updating."; 
			  } 
		 
		   // create a prepared statement    
			   String query = "UPDATE researcher SET fullName=?,mobile=?,email=?,nic=?,address=?,date=?,msg=?WHERE appID=?";
				 
		   PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		   // binding values    
		   preparedStmt.setString(1, fullName);
			preparedStmt.setInt(2,Integer.parseInt (mobile));
			preparedStmt.setString(3, email);
			preparedStmt.setString(4,nic);
			preparedStmt.setString(5, address);
			preparedStmt.setString(6, date);
			preparedStmt.setString(7, msg);
			preparedStmt.setInt(8, Integer.parseInt(appID));
		   
		 
		   // execute the statement    
		   preparedStmt.execute();    
		   con.close(); 
		 
		   //create JSON object to show successful msg
		   String newResearchers = readResearchers();
		   output = "{\"status\":\"success\", \"data\": \"" + newResearchers + "\"}";
		   }   catch (Exception e)   {    
			   output = "{\"status\":\"error\", \"data\": \"Error while Updating Researchers Details.\"}";      
			   System.err.println(e.getMessage());   
		   } 
		 
		  return output;  
		  }
		
		public String deleteResearchers(String appID) {  
			String output = ""; 
		 
		 try  {   
			 Connection con = connect();
		 
		  if (con == null)   {    
			  return "Error while connecting to the database for deleting.";   
		  } 
		 
		  // create a prepared statement   
		  String query = "DELETE FROM researcher WHERE appID=?"; 
		 
		  PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		  // binding values   
		  preparedStmt.setInt(1, Integer.parseInt(appID));       
		  // execute the statement   
		  preparedStmt.execute();   
		  con.close(); 
		 
		  //create JSON Object
		  String newresearchers = readResearchers();
		  output = "{\"status\":\"success\", \"data\": \"" + newresearchers + "\"}";
		  }  catch (Exception e)  {  
			  //Create JSON object 
			  output = "{\"status\":\"error\", \"data\": \"Error while Deleting Researchers.\"}";
			  System.err.println(e.getMessage());  
			  
		 } 
		 
		 return output; 
		 }
}
