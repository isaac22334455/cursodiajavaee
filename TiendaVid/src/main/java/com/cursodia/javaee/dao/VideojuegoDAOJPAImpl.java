package com.cursodia.javaee.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.cursodia.javaee.DBH.HibernateHelper;
import com.cursodia.javaee.beans.Videojuego;

public class VideojuegoDAOJPAImpl extends GenericDAOJPAImpl<Videojuego,Integer> implements VideojuegoDAO
{
	
	public List<Videojuego> sortByProv(int cveprov)
	{
	SessionFactory factory = HibernateHelper.getsessionfactory();
	Session session = factory.openSession();
	return session.createQuery("from Videojuego videojuegos WHERE videojuegos.cveprov_vid ="+cveprov).list();
	}
}
