package com.example.desafiozup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_comic")
public class Comic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer ComicId;
	private String titulo;
	private String isbn;
	@Column(length = 1000)
	private String descricao;
	private Double preco;
	
	@ManyToMany(mappedBy = "comics")
	@JsonIgnore
	private List<User> users = new ArrayList<>();
			
	private ArrayList<String> autores = new ArrayList<>();
	
	public Comic() {
		
	}
	
	public Comic(Long id, Integer comicId, String titulo, String isbn, String descricao, Double preco,
			ArrayList<String> autores, List<User> users) {
		super();
		this.id = id;
		this.ComicId = comicId;
		this.titulo = titulo;
		this.isbn = isbn;
		this.descricao = descricao;
		this.preco = preco;
		this.autores = autores;
		this.users=users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getComicId() {
		return ComicId;
	}

	public void setComicId(Integer comicId) {
		ComicId = comicId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}
	
	
	public  void addAutor(String autor) {
		this.autores.add(autor);
	}
	
	


    @Override
	public String toString() {
		return "Comic [id=" + id + ", ComicId=" + ComicId + ", titulo=" + titulo + ", isbn=" + isbn + ", descricao="
				+ descricao + ", preco=" + preco + ", autores=" + autores + "]";
	}
	
	

}
