package com.cursodia.javaee.dao;

import java.io.Serializable;
import java.util.List;

import com.cursodia.javaee.beans.Videojuego;

public class VideojuegoDAOJDBCImpl extends GenericDAOJDBCImpl<Videojuego,Integer> implements VideojuegoDAO
{
	@Override
	public List<Videojuego> sortByProv(int cveprov)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
