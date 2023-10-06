package com.cursodia.javaee.IOC;

import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.VideojuegoDAO;
import com.cursodia.javaee.dao.VideojuegoDAOJDBCImpl;
import com.cursodia.javaee.dao.ProveedorDAOJDBCImpl;

public class DAOJDBCFactory implements DAOFactory
{

	@Override
	public VideojuegoDAO getVideojuegoDAO() {
		// TODO Auto-generated method stub
		return new VideojuegoDAOJDBCImpl();
	}

	@Override
	public ProveedorDAO getProveedor() {
		// TODO Auto-generated method stub
		return new ProveedorDAOJDBCImpl();
	}

}
