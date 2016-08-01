package br.com.devmedia.ws.rest.example1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

@Constraint(validatedBy = CepValidoImpl.class)

public @interface CepValido {

	/* Especificação obrigatória do beans validation */

	String message() default "Cep invalido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
