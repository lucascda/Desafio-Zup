package com.example.desafiozup.request;

import java.time.LocalDate;

import com.example.desafiozup.model.User;
import com.example.desafiozup.validators.UniqueValue;

public class CreateUserRequest {
	
	private String nome;
	@UniqueValue(domainClass = User.class, fieldName = "email")
	private String email;
	@UniqueValue(domainClass = User.class, fieldName = "cpf")
	private String cpf;
	private LocalDate dataNascimento;
	
	public CreateUserRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public User toModel() {
		return new User(this.nome, this.email, this.cpf, this.dataNascimento);
	}
	
	
}
