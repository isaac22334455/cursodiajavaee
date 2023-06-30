package pruebas;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cursodia.javaee.beans.Videojuego;
public class JPAPruebas 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaee22");//el nombre para identificar la persistencia porque puede haber mas de una
		System.out.println("este"+emf);
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query =em.createQuery("SELECT V FROM Videojuego V",Videojuego.class);
		List<Videojuego> lista = query.getResultList();
		
		for(Videojuego v:lista)
		{
			System.out.println(v.gettit_vid());
		}
	}
}
