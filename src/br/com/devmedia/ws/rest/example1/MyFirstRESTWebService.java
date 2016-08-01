package br.com.devmedia.ws.rest.example1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("restws")
public class MyFirstRESTWebService {
    @Context
    private UriInfo context;

    public MyFirstRESTWebService() {
        // TODO Auto-generated constructor stub
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        // TODO return proper representation object
        return "meuPrimeiroTesteREst";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("sayOla/{nome}")
    public String sayOla(@PathParam(value="nome") String nome) {
    	return "Ola "+nome;
    }
    
    
    


}