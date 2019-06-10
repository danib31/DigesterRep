package com.testpackage;

import javax.ws.rs.GET;
import javax.ws.rs.POST; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.PathParam;

@Path("/messages") 
public class Messages {  
   MessageService messageService = new MessageService();  
   
   @GET
   @Path("/{message}")
   @Produces("text/plain")
   public String getDecryptedMessage(@PathParam("message") String message){
      return messageService.getDecryptedMessage(message);
   }
   
   @POST 
   @Path("/{message}") 
   @Produces("text/plain") 
   public String getEncryptedMessage(@PathParam("message") String message){
	    return messageService.getEncryptedMessage(message);
   }
}
