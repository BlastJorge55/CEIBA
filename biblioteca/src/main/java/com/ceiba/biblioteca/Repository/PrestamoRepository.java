package com.ceiba.biblioteca.Repository;

import org.springframework.stereotype.Repository;
import com.ceiba.biblioteca.Entity.Prestamo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo,Long>{
	
	List<Prestamo>  findPrestamoByidentificaciónUsuario(String identificaciónUsuario);

}
 