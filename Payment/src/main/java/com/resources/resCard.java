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

@Path("/Card")
public class resCard {
cntCard app = new cntCard();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("card")
	public List<Card> getCards()
	{
		System.out.println("getCard called...");
		return app.getCards();
	}
	
	
	
	@GET
	@Path("card/{CardID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Card getCard(@PathParam("CardID") int CardID)
	{
		return app.getCard(CardID);
	
	}
	
	@POST
	@Path("/card")
	@Consumes(MediaType.APPLICATION_JSON)
	public Card createCard(Card c1)
	{
		System.out.println(c1);
		app.create(c1);
		
		return c1;
	}
	
	
	@PUT
	@Path("/card")
	@Consumes(MediaType.APPLICATION_JSON)
	public Card updateCard(Card p1)
	{
		System.out.println(p1);
		if(app.getCard(p1.getCID()).getCID()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("card/{cid}")
	public Card deleteCard(@PathParam("cid") int cid)
	{
		Card p = app.getCard(cid);
		
		if(p.getCID()!=0)
			app.delete(cid);
		return null;
	}
	


}
