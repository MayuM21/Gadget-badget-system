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

@Path("/Funder")
public class resFunder {
	
cntFunder app = new cntFunder();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("funder")
	public List<Funder> getFunders()
	{
		System.out.println("getFunder called...");
		return app.getFunders();
	}
	
	
	
	@GET
	@Path("funder/{funderID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Funder getFunder(@PathParam("funderID") int funderID)
	{
		return app.getFunder(funderID);
	
	}
	
	@POST
	@Path("/funder")
	@Consumes(MediaType.APPLICATION_JSON)
	public Funder createPayment(Funder f1)
	{
		System.out.println(f1);
		app.create(f1);
		
		return f1;
	}
	
	
	@PUT
	@Path("/funder")
	@Consumes(MediaType.APPLICATION_JSON)
	public Funder updateFunder(Funder f1)
	{
		System.out.println(f1);
		if(app.getFunder(f1.getFID()).getFID()==0) {
			app.create(f1);
			
		}
		else
		{
			app.update(f1);
			
		}
		
		return f1;
	}
	
	
	@DELETE
	@Path("funder/{fid}")
	public Funder deletePatient(@PathParam("p=fid") int fid)
	{
		Funder f = app.getFunder(fid);
		
		if(f.getFID()!=0)
			app.delete(fid);
		return null;
	}
	
	
}
