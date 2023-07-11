package com.cursodia.javaee.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
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
	//por cada videojuego crea un "PROXI" de proveedor
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
	
	
	
}
