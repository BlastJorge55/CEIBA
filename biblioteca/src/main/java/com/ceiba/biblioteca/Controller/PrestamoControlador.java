package com.ceiba.biblioteca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.Controller.Respuestas.RespuestaPost;
import com.ceiba.biblioteca.Entity.Prestamo;
import com.ceiba.biblioteca.Services.PrestamoServicio;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

	@Autowired
	PrestamoServicio ps;

	@GetMapping("/Prueba")
	public String prueba() {
		return "Me gusta la Sangria";
	}

	@PostMapping()

	public ResponseEntity<RespuestaPost> cargarPrestamo(@RequestBody Prestamo prestamo) {
		System.out.println(ps.encontrarPrestamo(prestamo).isEmpty());
		
		//Comprobacion de que la identificacionUsuario no tenga otros prestamos (Si es asi habra alerta)

		if (ps.encontrarPrestamo(prestamo).isEmpty() == false) {

			RespuestaPost rpf = new RespuestaPost("El usuario con identificacion "+prestamo.getIdentificacionUsuario()+" ya tiene un libro prestado por lo cual no se le puede realizar otro prestamo");
			return new ResponseEntity<RespuestaPost>(rpf,HttpStatus.BAD_REQUEST);

			//Comprobacion de que tipoUsuario este en el rango)	
			
		} else if (prestamo.getTipoUsuario() <= 3 && prestamo.getTipoUsuario() >= 1) {

			prestamo.setFechaMaximaDevolucion(ps.fechaMaximaDevolucion1(prestamo));
			this.ps.cargarPrestamo(prestamo);
			RespuestaPost rp = new RespuestaPost(prestamo.getId(), prestamo.getFechaMaximaDevolucion());

			return new ResponseEntity<RespuestaPost>(rp,HttpStatus.OK);

		} else {

			RespuestaPost rpf = new RespuestaPost("Tipo de usuario no permitido en la biblioteca");
			return new ResponseEntity<RespuestaPost>(rpf,HttpStatus.BAD_REQUEST);
		}
	}

}
