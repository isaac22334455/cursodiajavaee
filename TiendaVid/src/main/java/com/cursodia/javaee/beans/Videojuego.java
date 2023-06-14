package com.cursodia.javaee.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cursodia.javaee.DBH.DatabaseHlper;
public class Videojuego 
{
	private int cve_vid;
	private String tit_vid;
	private float pre_vid;
	private int cveprov_vid;
	private int inv_vid;
	
	private String nomprov_vid;
	
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
	
	public Videojuego(int cve_vid, String tit_vid, float pre_vid,String nomprov_vid, int inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;		
		this.inv_vid = inv_vid;
		this.nomprov_vid=nomprov_vid;
	}
	
	public String getNomprov_vid() {
		return nomprov_vid;
	}
	public void setNomprov_vid(String nomprov_vid) {
		this.nomprov_vid = nomprov_vid;
	}
	public String getTit_vid() {
		return tit_vid;
	}
	public void setTit_vid(String tit_vid) {
		this.tit_vid = tit_vid;
	}
	public float getPre_vid() {
		return pre_vid;
	}
	public void setPre_vid(float pre_vid) {
		this.pre_vid = pre_vid;
	}
	public int getCveprov_vid() {
		return cveprov_vid;
	}
	public void setCveprov_vid(int cveprov_vid) {
		this.cveprov_vid = cveprov_vid;
	}
	public int getInv_vid() {
		return inv_vid;
	}
	public void setInv_vid(int inv_vid) {
		this.inv_vid = inv_vid;
	}
	public int getCve_vid() {
		return cve_vid;
	}
	
	
	//public static ResultSet buscarTodoslosProvedores() throws SQLException
	//{
	//	String query = "SELECT DISTINCT cveprov_vid FROM videojuegos";
	//	DatabaseHlper dbh = new DatabaseHlper();
	//	return dbh.seleccionarvideojuegos(query);	
	//}
	public static void insertar(int cve,String titulo,float precio,int cvep, int inv) throws SQLException
	{
		 String query = "INSERT INTO videojuegos(cve_vid,tit_vid,pre_vid,cveprov_vid,inv_vid) VALUES ";
		 query +="("+cve+",'"+titulo+"',"+precio+","+cvep+","+inv+")";
		 DatabaseHlper dbh = new DatabaseHlper();
		 dbh.modificarVideojuego(query);
	}
	public static List<Videojuego> buscartodos() throws SQLException
	{
		String query = "SELECT a.cve_vid,a.tit_vid, b.nom_prov provedor,a.pre_vid,a.inv_vid FROM videojuegos a INNER JOIN proveedores b ON a.cveprov_vid = b.cve_prov ";
		
		DatabaseHlper dbh = new DatabaseHlper();
		 return dbh.seleccionarvideojuegos(query);
	}
	
	public static Videojuego seleccionarvid(int cve) throws SQLException
	{
	   String query = "SELECT * FROM videojuegos WHERE cve_vid="+cve;
	   DatabaseHlper dbh = new DatabaseHlper();
	   List<Videojuego> lista = null;
	   
	   try {
		    lista = dbh.seleccionarvideojuego(query);
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
	
	public static int actuaizarVideojuego(int cve,String titulo,float precio,int cvep, int inv) throws SQLException
	{
		String query="UPDATE videojuegos SET tit_vid='"+titulo+"',pre_vid="+precio+",cveprov_vid="+cvep+",inv_vid="+inv+" WHERE cve_vid="+cve+"";
		DatabaseHlper dbh = new DatabaseHlper();
		int n=dbh.modificarVideojuego(query);
		return n;
	}

}
