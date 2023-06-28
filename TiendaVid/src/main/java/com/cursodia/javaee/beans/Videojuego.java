package com.cursodia.javaee.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.DBH.DatabaseHlper;
import com.cursodia.javaee.DBH.HibernateHelper;

@Entity
@Table(name="videojuegos")
public class Videojuego 
{
	@Id
	@Column(name="cve_vid")
	private int cve_vid;
	private String tit_vid;
	private float pre_vid;
	@ManyToOne
	@JoinColumn(name="cveprov_vid",referencedColumnName="cve_prov", insertable=false,updatable=false,nullable=false)
	private Proveedor prov;//un proveedor para muchos videojuegos
	public Proveedor getProveedor()
	{
		return prov;
		
	}
	public void setProveedor(Proveedor prov)//para que hibernate inyecte sus instancias de proveedor
	{
		this.prov=prov;
	}
	private int cveprov_vid;
	private int inv_vid;
	
	
	
	public Videojuego()
	{}	
	public Videojuego(int cve_vid, String tit_vid, float pre_vid, int cveprov_vid, int inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;
		this.cveprov_vid = cveprov_vid;
		this.inv_vid = inv_vid;
	}
	
	public void setcve_vid(int cve_vid) {
		this.cve_vid = cve_vid;
	}
	
	public String gettit_vid() {
		return tit_vid;
	}
	public void settit_vid(String tit_vid) {
		this.tit_vid = tit_vid;
	}
	public float getpre_vid() {
		return pre_vid;
	}
	public void setpre_vid(float pre_vid) {
		this.pre_vid = pre_vid;
	}
	public int getcveprov_vid() {
		return cveprov_vid;
	}
	public void setcveprov_vid(int cveprov_vid) {
		this.cveprov_vid = cveprov_vid;
	}
	public int getinv_vid() {
		return inv_vid;
	}
	public void setinv_vid(int inv_vid) {
		this.inv_vid = inv_vid;
	}
	public int getcve_vid() {
		return cve_vid;
	}
	
	public static void insertar(int cve,String titulo,float precio,int cvep, int inv) throws SQLException, DataBaseException
	{	
		 String query = "INSERT INTO videojuegos(cve_vid,tit_vid,pre_vid,cveprov_vid,inv_vid) VALUES ";
		 query +="("+cve+",'"+titulo+"',"+precio+","+cvep+","+inv+")";
		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		 Session session = factoriaS.openSession();
		 Transaction transaccion = session.beginTransaction();
		 try {
		        session.createNativeQuery(query).executeUpdate();
		        transaccion.commit();
		    } catch (Exception e) {
		        transaccion.rollback();
		        throw e;
		    } finally {
		        session.close();
		    }
	}
	public static List<Videojuego> buscartodos() throws SQLException, DataBaseException
	{
		SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		Session session = factoriaS.openSession();
		Query consulta = session.createQuery("from Videojuego videojuegos");
		List<Videojuego> lista=consulta.list();
		session.close();
		return lista;
	}
	
	public static Videojuego seleccionarvid(int cve) throws SQLException
	{
	   String query = "SELECT * FROM videojuegos WHERE cve_vid="+cve;
	   SessionFactory factoriaS= HibernateHelper.getsessionfactory();
	   Session session = factoriaS.openSession();
	   List<Videojuego> lista = null;
	   
	   try {
		  lista= session.createNativeQuery(query, Videojuego.class).list();
		} catch (Exception e) {
		    // Manejo de la excepción
		    e.printStackTrace();
		}

		if (lista != null && !lista.isEmpty()) {
		    return lista.get(0);
		} else {
		    // Manejo cuando la lista está vacía o es nula
		    return null; // O puedes lanzar una excepción personalizada, lanzar un mensaje de error, etc.
		}	   
	}
	
	public static void actuaizarVideojuego(int cve,String titulo,float precio,int cvep, int inv) throws SQLException, DataBaseException
	{
		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		 Session session = factoriaS.openSession();
		String query="UPDATE videojuegos SET tit_vid='"+titulo+"',pre_vid="+precio+",cveprov_vid="+cvep+",inv_vid="+inv+" WHERE cve_vid="+cve+"";
		Transaction transaccion = session.beginTransaction();
		 try {
		        session.createNativeQuery(query).executeUpdate();
		        transaccion.commit();
		    } catch (Exception e) {
		        transaccion.rollback();
		        throw e;
		    } finally {
		        session.close();
		    }
	}
	public static void EliminarVideojuego(int cve) throws SQLException, DataBaseException
	{
		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		 Session session = factoriaS.openSession();
		String query="DELETE FROM videojuegos WHERE cve_vid="+cve+"";
		Transaction transaccion = session.beginTransaction();
		 try {
		        session.createNativeQuery(query).executeUpdate();
		        transaccion.commit();
		    } catch (Exception e) {
		        transaccion.rollback();
		        throw e;
		    } finally {
		        session.close();
		    }	
	}

}
