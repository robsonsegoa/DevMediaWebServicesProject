package br.com.devmedia.ws.rest.example1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("ceprest")
public class CepRestWS {

	
    @Context
    private UriInfo context;

    public CepRestWS() {
	}
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCep/{cep}")
    public Cep getCep(@CepValido @PathParam("cep") String cep) {
    	Cep toReturn = new Cep();
    	toReturn.setCep(cep);
    	toReturn.setBairro("Bairro "+new Random().nextInt());
    	toReturn.setNumero(new Random().nextInt());
    	toReturn.setRua("Rua que sempre "+new Random().nextInt());
    	toReturn.setUf("PR");
    	return toReturn;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCepByRua/{rua}")
    public List<Cep> getCepByRua(@PathParam("rua") String rua){
    	List<Cep> ceps = new LinkedList<Cep>();
    	for(int i = 0; i< 10; i++){
    		Cep toReturn = new Cep();
        	toReturn.setCep(String.valueOf(new Random().nextInt()));
        	toReturn.setBairro("Bairro "+new Random().nextInt());
        	toReturn.setNumero(new Random().nextInt());
        	toReturn.setRua("Rua que sempre ("+rua+") "+new Random().nextInt());
        	toReturn.setUf("PR");
        	ceps.add(toReturn);
        	for(int j = 0; j< 10; j++){
        		Cep toReturn2 = new Cep();
            	toReturn2.setCep(String.valueOf(new Random().nextInt()));
            	toReturn2.setBairro("Bairro "+new Random().nextInt());
            	toReturn2.setNumero(new Random().nextInt());
            	toReturn2.setRua("Rua que sempre ("+rua+") "+new Random().nextInt());
            	toReturn2.setUf("PR");
            	toReturn.getCepsPorPerto().add(toReturn2);
        		
        	}
    	}
    		return ceps;
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("setCep")
    public void setCep(@Valid Cep cep){
    	System.out.println("Objeto Cep Recebido! - " +cep);
    	System.out.println("Cep "+ cep.getCep());
    	System.out.println("Rua "+ cep.getRua());
    	System.out.println("Bairro "+ cep.getBairro());
    	System.out.println("Numero "+ cep.getNumero());
    	System.out.println("UF "+ cep.getUf());
    	
    }
    
	
}
