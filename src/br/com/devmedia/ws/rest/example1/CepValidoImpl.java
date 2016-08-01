package br.com.devmedia.ws.rest.example1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidoImpl implements ConstraintValidator<CepValido, String> {

	@Override
	public void initialize(CepValido annotation) {
		System.out.println("Mensagem inicial de erro " + annotation.message());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext contexto) {
		if(value == null) return false;
		if(value.length() != 8) return false;
		if(value.charAt(0) != '8') return false;
		return true; 
		/*Ele vem com padrão false, trocar para true se não n compila)*/
	}

}
