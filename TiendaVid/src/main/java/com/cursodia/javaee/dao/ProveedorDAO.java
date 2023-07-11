package com.cursodia.javaee.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cursodia.javaee.beans.Proveedor;

public class ProveedorDAO 
{
	public static List<Proveedor> buscarProvedorCveName() throws SQLException
	{
//		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
//		 Session session = factoriaS.openSession();
//		 List<Proveedor> lista = session.createQuery("from Proveedor proveedores").list();
//			session.close();
//			return lista;
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		  EntityManager em = emf.createEntityManager();
		  TypedQuery<Proveedor> query =em.createQuery("SELECT p FROM Proveedor p",Proveedor.class);
	      List<Proveedor>lista = query.getResultList();
		  em.close();
		  return lista;
	}
}
