package com.example.desafiozup.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotBlank(message = "CPF é obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	
	private LocalDate dataNascimento;
	
	public User() {
		
	}
	
	public User(@NotBlank(message = "Nome é obrigatório") String nome,
			@NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String email,
			@NotBlank(message = "CPF é obrigatório") @CPF(message = "CPF inválido") String cpf,
			@NotBlank(message = "Data de nascimento é obrigatória") LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}	

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	
	
}
