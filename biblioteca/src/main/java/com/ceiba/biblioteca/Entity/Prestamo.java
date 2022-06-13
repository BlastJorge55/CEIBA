package com.ceiba.biblioteca.Entity;

import java.io.Serializable;


import javax.persistence.*;


@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true,length=10)
	private String isbn;
	
	@Column(length=10)
	private String identificacionUsuario;
	

	@Column(length=1)
	private int tipoUsuario;
	
	@Column(length=10)
	private String fechaMaximaDevolucion ;
	
    
	
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}

	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
