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

import DataTypeObjects.appointmentDTO;
import DataTypeObjects.docHosDTO;
import DataTypeObjects.paymentDTO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Payment")
public class resPayment {
	
cntPayment app = new cntPayment();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("payment")
	public List<Payment> getPayments()
	{
		System.out.println("getPatient called...");
		return app.getPayments();
	}
	
	
	
	@GET
	@Path("payment/{paymentID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPayment(@PathParam("paymentID") int paymentID)
	{
		return app.getPayment(paymentID);
	
	}
	
	@POST
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment createPayment(Payment p1)
	{
		System.out.println(p1);
		app.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment updatePayment(Payment p1)
	{
		System.out.println(p1);
		if(app.getPayment(p1.getPID()).getPID()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("payment/{pid}")
	public Payment deletePatient(@PathParam("pid") int pid)
	{
		Payment p = app.getPayment(pid);
		
		if(p.getPID()!=0)
			app.delete(pid);
		return null;
	}
	
	
}
