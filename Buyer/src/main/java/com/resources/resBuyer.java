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

@Path("/Buyer")
public class resBuyer {
	
cntBuyer app = new cntBuyer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buyer")
	public List<Buyer> getBuyers()
	{
		System.out.println("getBuyer called...");
		return app.getBuyers();
	}
	
	
	
	@GET
	@Path("buyer/{buyerID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Buyer getBuyer(@PathParam("buyerID") int buyerID)
	{
		return app.getBuyer(buyerID);
	
	}
	
	@POST
	@Path("/buyer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Buyer createPayment(Buyer b1)
	{
		System.out.println(b1);
		app.create(b1);
		
		return b1;
	}
	
	
	@PUT
	@Path("/buyer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Buyer updateBuyer(Buyer b1)
	{
		System.out.println(b1);
		if(app.getBuyer(b1.getBID()).getBID()==0) {
			app.create(b1);
			
		}
		else
		{
			app.update(b1);
			
		}
		
		return b1;
	}
	
	
	@DELETE
	@Path("buyer/{bid}")
	public Buyer deletePatient(@PathParam("p=bid") int bid)
	{
		Buyer f = app.getBuyer(bid);
		
		if(f.getBID()!=0)
			app.delete(bid);
		return null;
	}
	
	
}
