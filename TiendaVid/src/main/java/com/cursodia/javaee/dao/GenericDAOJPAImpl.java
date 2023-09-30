package com.cursodia.javaee.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T,Id>
{
   private Class<T> clasedepersistencia;
   @SuppressWarnings("unchecked")
public GenericDAOJPAImpl()
   {
	   
	   this.clasedepersistencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
   }
   
    @Override
   public T seleccionar (Id id)
   {
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
	   EntityManager manager = emf.createEntityManager();
	   
	   T obj = null;
	   try
	   {
		   obj = (T) manager.find(clasedepersistencia, id);
		   System.out.println("");
	   }catch(PersistenceException e)
	   {
		   e.printStackTrace();
	   }finally 
	   {
		   manager.close();
	   }
	return obj;  
   }
    @Override
    public List<T> buscarTodos()
    {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
  	  EntityManager em = emf.createEntityManager();
  	  List<T> lista = null;
  	  try
  	  {
  		  TypedQuery<T> consulta = em.createQuery("SELECT o FROM "+clasedepersistencia.getSimpleName()+" o", clasedepersistencia);
  		  lista = consulta.getResultList();
  	  }catch(PersistenceException e)
  	  {
  		  e.printStackTrace();
  	  }finally
  	  {
  		  em.close();
  	  }  
  	  return lista;
    }
    @Override
    public void borrar(T objeto)
    {
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx =null;
		 
		  try
		  {
			  tx= em.getTransaction();
			  tx.begin();
			  em.remove(em.merge(objeto));	
			  tx.commit();
		  }
		  catch(PersistenceException e)
		  {
			  tx.rollback();
			  e.printStackTrace();
		  }
		  finally
		  {
			  em.close();  
		  }
		 
    }
    @Override
	public void insertar(T objeto)
	{
    	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx =null;
		  
		  try
		  {
			  tx= em.getTransaction();
			  tx.begin();
			  em.merge(objeto);
			  tx.commit();
		  }
		  catch(PersistenceException e)
		  {
			  tx.rollback();
			  e.printStackTrace();
		  }
		  finally
		  {
			  em.close();  
		  }
	}
    @Override
	public void guardarCambios(T objeto)
	{
    	  System.out.println(objeto);
    	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx =null;
		  
		  try
		  {
			  tx= em.getTransaction();
			  tx.begin();
			  em.merge(objeto);
			  tx.commit();
		  }
		  catch(PersistenceException e)
		  {
			  tx.rollback();
			  e.printStackTrace();
		  }
		  finally
		  {
			  em.close();  
		  }
	}
}
