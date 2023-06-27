package com.cursodia.javaee.beans;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cursodia.javaee.DBH.DatabaseHlper;
import com.cursodia.javaee.DBH.HibernateHelper;

public class Proveedor 
{
	int cve_prov;
	String nom_prov;
	 public Proveedor() {}
	 
	public Proveedor(int cve_prov, String nom_prov) 
	{
		super();
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
	}
	public String getNom_prov() {
		return nom_prov;
	}
	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}
	public void setCve_prov(int cve_prov) {
		this.cve_prov = cve_prov;
	}

	public int getCve_prov() {
		return cve_prov;
	}
	
	public static List<Proveedor> buscarProvedorCveName() throws SQLException
	{
		 SessionFactory factoriaS= HibernateHelper.getsessionfactory();
		 Session session = factoriaS.openSession();
		 List<Proveedor> lista = session.createQuery("from Proveedor proveedores").list();
			session.close();
			return lista;
	}

}
