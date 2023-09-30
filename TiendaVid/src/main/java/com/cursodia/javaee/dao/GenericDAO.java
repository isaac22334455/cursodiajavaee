package com.cursodia.javaee.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,Id extends Serializable>
{
	T seleccionar(Id id);
	List<T> buscarTodos();
	void borrar(T objeto);
	void insertar(T objeto);
	void guardarCambios(T objeto);

}
