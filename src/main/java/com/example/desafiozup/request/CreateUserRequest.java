package com.example.desafiozup.request;

import java.time.LocalDate;

import com.example.desafiozup.model.User;

public class CreateUserRequest {
	
	private String nome;
	private String email;
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
