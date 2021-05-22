package com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ServicioBase<T, ID, R extends JpaRepository<T, ID>> {

	@Autowired
	protected R repositorio;
	
	public ServicioBase(R repo) {
		this.repositorio = repo;
	}

	/**
	 * Almacenamos una nueva entidad a través del repositorio
	 * 
	 * @param t
	 * @return
	 */
	public T save(T t) {
		return repositorio.save(t);
	}

	/**
	 * Localizamos una entidad en base a su Id.
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public T findById(ID id) {
		// Devolvemos la entidad si la encuentra u otro si no lo encuentra, en este
		// caso,
		// hemos dicho que ese "otro" sea null
		return repositorio.findById(id).orElse(null);
	}

	/**
	 * Obtenemos todas las entidades de un tipo de entidad
	 * 
	 * @return
	 */
	public List<T> findAll() {
		return repositorio.findAll();
	}

	/**
	 * Editamos una instancia de una entidad (si no tiene Id, la insertamos).
	 * 
	 * @param t
	 * @return
	 */
	public T edit(T t) {
		return repositorio.save(t);
	}

	/**
	 * Eliminamos una instancia de una entidad
	 * 
	 * @param t
	 */
	public void delete(T t) {
		repositorio.delete(t);
	}

	/**
	 * Eliminamos una instancia en base a su ID
	 * 
	 * @param id
	 */
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
}
