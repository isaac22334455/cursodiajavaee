package com.cursodia.javaee.IOC;

import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.VideojuegoDAO;

public interface DAOFactory 
{
	public abstract VideojuegoDAO getVideojuegoDAO();
	public abstract ProveedorDAO getProveedor();

}
