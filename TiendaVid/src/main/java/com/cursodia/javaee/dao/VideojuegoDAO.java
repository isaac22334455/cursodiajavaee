package com.cursodia.javaee.dao;

import java.sql.SQLException;
import java.util.List;
import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.beans.Videojuego;

public interface VideojuegoDAO 
{
	public abstract void insertar(Videojuego v);
	public abstract List<Videojuego> buscarTodos();
	public abstract Videojuego seleccionar(Integer cve);
	public abstract  void borrar(Videojuego cve);
	public abstract  void guardarCambios(Videojuego v);
	public abstract List<Videojuego> sortByProv(int cveprov);
}
