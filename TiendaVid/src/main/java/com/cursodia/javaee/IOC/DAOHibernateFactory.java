package com.cursodia.javaee.IOC;

import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.ProveedorDAOHibernateImpl;
import com.cursodia.javaee.dao.VideojuegoDAO;
import com.cursodia.javaee.dao.VideojuegoDAOHivernateImpl;

public class DAOHibernateFactory implements DAOFactory
{

	@Override
	public VideojuegoDAO getVideojuegoDAO() 
	{
		return new VideojuegoDAOHivernateImpl();
	}

	@Override
	public ProveedorDAO getProveedor() {
		// TODO Auto-generated method stub
		return new ProveedorDAOHibernateImpl();
	}
	

}
