package com.cursodia.javaee.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cursodia.javaee.DBH.HibernateHelper;

public abstract class GenericDAOHivernateImpl<T, Id extends Serializable> implements GenericDAO<T,Id>
{
	 private Class<T> clasedepersistencia;
	   @SuppressWarnings("unchecked")
	public GenericDAOHivernateImpl()
	   {
		   
		   this.clasedepersistencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	   }
	   
	   
	   
	    @Override
	   public T seleccionar (Id id)
	   {
	       SessionFactory factoriaS= HibernateHelper.getsessionfactory();
	  	   Session session = factoriaS.openSession();
		   
		   T obj = null;
		   try
		   {
			   obj = (T) session.find(clasedepersistencia, id);
			   System.out.println("");
		   }catch(PersistenceException e)
		   {
			   e.printStackTrace();
		   }finally 
		   {
			   session.close();
		   }
		return obj;  
	   }
	    @Override
	    public List<T> buscarTodos()
	    {
	    	System.out.println("entro en hibernate");
	      SessionFactory factoriaS= HibernateHelper.getsessionfactory();
	 	  Session session = factoriaS.openSession();
	  	  List<T> lista = null;
	  	  try
	  	  {
	  		  TypedQuery<T> consulta = session.createQuery("SELECT o FROM "+clasedepersistencia.getSimpleName()+" o", clasedepersistencia);
	  		  lista = consulta.getResultList();
	  	  }catch(PersistenceException e)
	  	  {
	  		  e.printStackTrace();
	  	  }finally
	  	  {
	  		  session.close();
	  	  }  
	  	  return lista;
	    }
	    @Override
	    public void borrar(T objeto)
	    {
	    	 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
			 Session session = factoriaS.openSession();
			 Transaction tx = session.beginTransaction();;
			 
			  try
			  {
				  session.remove(session.merge(objeto));	
				  tx.commit();
			  }
			  catch(PersistenceException e)
			  {
				  tx.rollback();
				  e.printStackTrace();
			  }
			  finally
			  {
				  session.close();  
			  }
			 
	    }
	    @Override
		public void insertar(T objeto)
		{
	    	 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
			 Session session = factoriaS.openSession();
			 Transaction tx = session.beginTransaction();
			  
			  try
			  {
				  session.merge(objeto);
				  tx.commit();
			  }
			  catch(PersistenceException e)
			  {
				  tx.rollback();
				  e.printStackTrace();
			  }
			  finally
			  {
				  session.close();  
			  }
		}
	    @Override
		public void guardarCambios(T objeto)
		{
	    	SessionFactory factoriaS= HibernateHelper.getsessionfactory();
			 Session session = factoriaS.openSession();
			 Transaction tx = session.beginTransaction();
			  
			  try
			  {
				  session.merge(objeto);
				  tx.commit();
			  }
			  catch(PersistenceException e)
			  {
				  tx.rollback();
				  e.printStackTrace();
			  }
			  finally
			  {
				  session.close();  
			  }
		}

}
