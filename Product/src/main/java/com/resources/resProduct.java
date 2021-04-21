package com.resources;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import com.controller.*;
import com.java.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Product")
public class resProduct {
	
cntProduct app = new cntProduct();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("product")
	public List<Product> getProducts()
	{
		System.out.println("getPatient called...");
		return app.getProducts();
	}
	
	
	
	@GET
	@Path("product/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("productID") int productID)
	{
		return app.getProduct(productID);
	
	}
	
	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product createProduct(Product p1)
	{
		System.out.println(p1);
		app.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product updateProduct(Product p1)
	{
		System.out.println(p1);
		if(app.getProduct(p1.getPID()).getPID()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("product/{pid}")
	public Product deletePatient(@PathParam("pid") int pid)
	{
		Product p = app.getProduct(pid);
		
		if(p.getPID()!=0)
			app.delete(pid);
		return null;
	}
	
	
}
