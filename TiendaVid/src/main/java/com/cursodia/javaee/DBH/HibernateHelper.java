package com.cursodia.javaee.DBH;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper 
{
	private static final SessionFactory sessionfactory= buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		try
		{
		  return new Configuration().configure().buildSessionFactory();	
		}catch(Throwable ex)
		{
			System.err.println("error al crear el factory"+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getsessionfactory()
	{
		return sessionfactory;
	}
}
