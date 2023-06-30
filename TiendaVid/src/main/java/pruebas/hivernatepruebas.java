package pruebas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import  com.cursodia.javaee.beans.Videojuego;
public class hivernatepruebas 
{

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaccion= null;
		
		try
		{
		SessionFactory factoria = new Configuration().configure().buildSessionFactory();
		session=factoria.openSession();
		transaccion=session.beginTransaction();
		Videojuego v=new Videojuego(1,"pruebcambio",12f,1,200);
		session.saveOrUpdate(v);
		transaccion.commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			transaccion.rollback();
		}finally
		{
			session.close();
		}
	}
}
