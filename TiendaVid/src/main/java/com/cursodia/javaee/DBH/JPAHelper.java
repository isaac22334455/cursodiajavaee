package com.cursodia.javaee.DBH;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper 
{
	private static final EntityManagerFactory emf = buildEntityManagerFactory();
	
	private static EntityManagerFactory buildEntityManagerFactory()
	{
		try
		{
			return Persistence.createEntityManagerFactory("javaee22");
		}catch(Throwable e)
		{
			e.printStackTrace(); 
			throw new RuntimeException("error al cargar factoria jpa");
		}
	}
	public static EntityManagerFactory getJPAFactorry()
	{
		return emf;
	}
}
