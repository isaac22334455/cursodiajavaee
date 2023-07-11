package com.cursodia.javaee.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.beans.Videojuego;

public class VideojuegoDAO 
{
	public static void insertar(int cve,String titulo,float precio,int cvep, int inv) throws SQLException, DataBaseException
	{	
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx =null;
		  tx= em.getTransaction();
		  tx.begin();
		  em.merge(new Videojuego(cve,titulo,precio,cvep,inv));
		  tx.commit();
		  em.close();
	}
	public static List<Videojuego> buscartodos() throws SQLException, DataBaseException
	{
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
	  EntityManager em = emf.createEntityManager();
	  TypedQuery<Videojuego> query =em.createQuery("SELECT V FROM Videojuego V JOIN FETCH V.prov",Videojuego.class);
	  List<Videojuego> lista = null;
	  try
	  {
		  lista = query.getResultList();
	  }catch(PersistenceException e)
	  {
		  e.printStackTrace();
	  }finally
	  {
		  em.close();
	  }  
	  return lista;
	}
	
	public static Videojuego seleccionarvid(int cve) throws SQLException
	{
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  TypedQuery<Videojuego> query =em.createQuery("SELECT V FROM Videojuego V JOIN FETCH V.prov WHERE V.cve_vid=?1 ",Videojuego.class);
	      query.setParameter(1,cve);
		  Videojuego lista = query.getSingleResult();
		  em.close();
		  return lista;   
	}
	public static void EliminarVideojuego(int cve) throws SQLException, DataBaseException
	{
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx =null;
		  tx= em.getTransaction();
		  tx.begin();
		  try
		  {
			  em.remove(em.merge(seleccionarvid(cve)));	
			  tx.commit();
		  }
		  catch(PersistenceException e)
		  {
			  em.getTransaction().rollback();
			  e.printStackTrace();
		  }
		  em.close();
	}
}
