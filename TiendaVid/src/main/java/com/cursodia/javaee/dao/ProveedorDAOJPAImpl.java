package com.cursodia.javaee.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cursodia.javaee.DBH.HibernateHelper;
import com.cursodia.javaee.beans.Proveedor;
public class ProveedorDAOJPAImpl extends GenericDAOJPAImpl<Proveedor,Integer> implements ProveedorDAO
{	
	public static List<Proveedor> buscarProvedorCveName()
	{
		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		 Session session = factoriaS.openSession();
		 @SuppressWarnings("unchecked")
		List<Proveedor> lista = session.createQuery("from Proveedor proveedores").list();
			session.close();
			return lista;
	}
}
                                                                                                                  