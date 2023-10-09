package com.cursodia.javaee.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cursodia.javaee.DBH.JPAHelper;
import com.cursodia.javaee.beans.Videojuego;

public class VideojuegoDAOJPAImpl extends GenericDAOJPAImpl<Videojuego,Integer> implements VideojuegoDAO
{
	public List<Videojuego> sortByProv(int cveprov)
	{
      EntityManagerFactory emf = JPAHelper.getJPAFactorry();
      EntityManager manager = emf.createEntityManager();
      TypedQuery<Videojuego> query = manager.createQuery("SELECT v FROM Videojuego v WHERE v.cveprov_vid = :cveprov", Videojuego.class);
      query.setParameter("cveprov", cveprov);

      return query.getResultList();
    }
}