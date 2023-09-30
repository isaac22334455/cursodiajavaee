package com.cursodia.javaee.dao;
import java.util.List;
import com.cursodia.javaee.beans.Proveedor;
public interface ProveedorDAO 
{
	public abstract void insertar(Proveedor p);
	public abstract List<Proveedor> buscarTodos();
	public abstract Proveedor seleccionar(Integer cve);
	public abstract  void borrar(Proveedor cve);
	public abstract  void guardarCambios(Proveedor p);
}
