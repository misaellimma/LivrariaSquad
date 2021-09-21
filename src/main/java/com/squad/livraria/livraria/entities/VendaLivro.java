package com.squad.livraria.livraria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venda_livro")
public class VendaLivro {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name="idvenda", nullable= false)
	private Integer idvenda;
	@Column(name="idlivro", nullable= false)
	private Integer idlivro;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(Integer idvenda) {
		this.idvenda = idvenda;
	}
	public Integer getIdlivro() {
		return idlivro;
	}
	public void setIdlivro(Integer idlivro) {
		this.idlivro = idlivro;
	}
}
