package com.example.desafiozup.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Id não encontrado: " + id);
	}
}
