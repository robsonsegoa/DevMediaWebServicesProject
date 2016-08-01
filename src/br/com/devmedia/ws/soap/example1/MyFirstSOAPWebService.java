package br.com.devmedia.ws.soap.example1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;


@WebService()
public class MyFirstSOAPWebService {

	
	@WebMethod
	public String ping(@WebParam(name="nome")@NotNull String nome) {
		return "Pong ! "+nome;
	}
	
	@WebMethod(operationName="MeDeMinhaIdadePorFavor",exclude=true)
	public Integer getAge() {
		return new Random().nextInt();
	}
	
	public List<String> getMinhaPrimeiraLista() {
		List<String> toReturn = new LinkedList<String>();
		toReturn.add("Meu item 1");
		toReturn.add("Meu item 2");
		toReturn.add("Meu item 3");
		toReturn.add("Meu item 4");
		toReturn.add("Meu item 5");
		return toReturn;
	}
	
	public List<Carro> getMeusCarros() {
		List<Carro> toReturn = new LinkedList<Carro>();
		Carro carro1 = new Carro();
		carro1.setCor(CorType.MARRON);
		carro1.setMarca("RENAULT");
		carro1.setNome("MEGANE GT");
		toReturn.add(carro1);
		Carro carro2 = new Carro();
		carro2.setCor(CorType.ROSA);
		carro2.setMarca("FIAT");
		carro2.setNome("UNO");
		toReturn.add(carro2);
		carro1.setErroXMLProfundo(carro2);
		return toReturn;
	}
	
}
