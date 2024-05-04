package br.com.portifoliounopar.crud.services.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(Object id) {
		
		super("Seu usuário de id" + id);
		
	}

}
