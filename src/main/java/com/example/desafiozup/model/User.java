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
	Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email inválido")
	
	String email;
	
	@NotBlank(message = "CPF é obrigatório")
	@CPF(message = "CPF inválido")
	String cpf;
	
	@NotBlank(message = "Data de nascimento é obrigatória")
	LocalDate dataNascimento;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
