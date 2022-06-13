package com.ceiba.biblioteca.Controller.Respuestas;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RespuestaPost {
     
	 private long id;
     private String fechaMaximaDevolucion;
     public String mensaje;
 
     
     
	public RespuestaPost(long id, String fechaMaximaDevolucion) {
		this.id = id;
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	
	
	public RespuestaPost(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
     
     
}
