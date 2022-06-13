package com.ceiba.biblioteca.Services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.biblioteca.Entity.Prestamo;
import com.ceiba.biblioteca.Repository.PrestamoRepository;

@Service
public class PrestamoServicio {

	@Autowired
	PrestamoRepository pre;

	public Prestamo cargarPrestamo(Prestamo p) {
		return pre.save(p);
	}
    
	public List<Prestamo> encontrarPrestamo(Prestamo p) {
		return pre.findPrestamoByidentificaciónUsuario(p.getIdentificaciónUsuario());
	}
	
	//METODO PARA CALULAR LA FECHA
	public String fechaMaximaDevolucion1(Prestamo p) {

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		@SuppressWarnings("deprecation")
		int dias = c.getTime().getDay();

		int d = 0;

		switch (p.getTipoUsuario()) {
		case 1:
			d = 10;
			break;

		case 2:
			d = 8;
			break;

		case 3:
			d = 7;
			break;

		}

		System.out.println(d);

		while (dias <= d) {

			if (c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {

				dias++;
			}
			c.add(Calendar.DATE, 1);
		}

		return sdf.format(c.getTime());

	}
}
