package com.cursodia.javaee.IOC;

import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;
import com.cursodia.javaee.dao.VideojuegoDAO;
import com.cursodia.javaee.dao.VideojuegoDAOJPAImpl;

public class DAOJPAFactory implements DAOFactory
{

	@Override
	public VideojuegoDAO getVideojuegoDAO() 
	{
		return new VideojuegoDAOJPAImpl();	
	}

	@Override
	public ProveedorDAO getProveedor() 
	{
		return new ProveedorDAOJPAImpl();
	}

}
