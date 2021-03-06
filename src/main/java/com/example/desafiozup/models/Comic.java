package com.example.desafiozup.models;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "tb_autores", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "autores")
	private List<String> autores = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	
	private String diaDesconto;
	private Boolean descontoAtivo;
			
	
	
	public Comic() {
		
	}
	
	public Comic(Integer comicId, String titulo, String isbn, String descricao, Double preco,
			List<String> autores, User user) {
		super();
		this.ComicId = comicId;
		this.titulo = titulo;
		this.isbn = isbn;
		this.descricao = descricao;
		this.preco = preco;
		this.autores = autores;
		this.user=user;
	}


	public Long getId() {
		return id;
	}


	public Integer getComicId() {
		return ComicId;
	}



	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
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

	public User getUser() {
		return user;
	}


	public List<String> getAutores() {
		return autores;
	}

	
	
	public  void addAutor(String autor) {
		this.autores.add(autor);
	}
	
    public String getDiaDesconto() {
		return diaDesconto;
	}
   
    public void setDiaDesconto(String diaDesconto) {
		this.diaDesconto = diaDesconto;
	}

	public Boolean getDescontoAtivo() {
		return descontoAtivo;
	}
	

	public void setDescontoAtivo(Boolean descontoAtivo) {
		this.descontoAtivo = descontoAtivo;
	}

	
	public Integer parseIsbnToDayValue() {
		String isbn = this.isbn;
		char lastNum = isbn.charAt(isbn.length() - 1);
		System.out.println(lastNum);
		Integer dia = null;
		switch (lastNum) {
		case '0':
		case '1':
			dia = 1;
			break;
		case '2':
		case '3':
			dia = 2;
			break;
		case '4':
		case '5':
			dia = 3;
			break;
		case '6':
		case '7':
			dia = 4;
			break;
		case '8':
		case '9':
			dia = 5;
			break;
		}
		System.out.println(dia);
		return dia;
	}
	
	public String parseIsbnToDay() {
		String isbn = this.isbn;
		char lastNum = isbn.charAt(isbn.length() - 1);
		String dia = "";
		switch(lastNum) {
		case '0':
		case '1':
			dia = "segunda-feira";
			break;
		case '2':
		case '3':
			dia = "ter??a-feira";
			break;
		case '4':
		case '5':
			dia = "quarta-feira";
			break;
		case '6':
		case '7':
			dia = "quinta-feira";
			break;
		case '8':
		case '9':
			dia = "sexta-feira";
			break;
		}
		System.out.println(dia);
		return dia;
	}
	
	public Boolean criaDescontoAtivo() {
		Instant horario = Instant.now();
		Integer myDay =  horario.atZone(ZoneId.systemDefault()).getDayOfWeek().getValue();
		Integer dia = parseIsbnToDayValue();
		if(myDay == dia) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public String toString() {
		return "Comic [id=" + id + ", ComicId=" + ComicId + ", titulo=" + titulo + ", isbn=" + isbn + ", descricao="
				+ descricao + ", preco=" + preco + ", autores=" + autores + "]";
	}
	
	

}
