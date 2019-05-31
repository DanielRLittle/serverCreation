package com.qa.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.qa.model.Account;
import com.qa.repository.AccountRepo;
import com.qa.repository.Relation;

@Path("/")
public class AccountEndPoints {
	@Inject
	private Relation relation;
	
	@Inject
	private AccountRepo accountRepo;
	@POST
	@Path("/account")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({"application/json"})
	
	public Response createAccount(Account account, @Context UriInfo uriInfo) {
		Account returned = accountRepo.createAccount(account);
		System.out.println(returned.getId());
		System.out.println(returned.getFirstName());
		URI uri = uriInfo.getBaseUriBuilder().path(""+returned.getId()).build();
		return Response.created(uri).build();	
	}
	
	public Response getText() {
		String text = relation.message();
		return Response.ok(text).build();
	}
	
	
}
