package com.cursodia.javaee.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.DBH.DatabaseHlper;
public class Videojuego 
{
	private int cve_vid;
	private String tit_vid;
	private float pre_vid;
	private int cveprov_vid;
	private int inv_vid;
	
	private String provedor;
	
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
	
	public Videojuego(int cve_vid, String tit_vid, float pre_vid,String provedor, int inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;		
		this.inv_vid = inv_vid;
		this.provedor=provedor;
	}
	
	
	public void setcve_vid(int cve_vid) {
		this.cve_vid = cve_vid;
	}
	public String getprovedor() {
		return provedor;
	}
	public void setprovedor(String provedor) {
		this.provedor = provedor;
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
	
	
	//public static ResultSet buscarTodoslosProvedores() throws SQLException
	//{
	//	String query = "SELECT DISTINCT cveprov_vid FROM videojuegos";
	//	DatabaseHlper dbh = new DatabaseHlper();
	//	return dbh.seleccionarvideojuegos(query);	
	//}
	public static void insertar(int cve,String titulo,float precio,int cvep, int inv) throws SQLException, DataBaseException
	{
		 String query = "INSERT INTO videojuegos(cve_vid,tit_vid,pre_vid,cveprov_vid,inv_vid) VALUES ";
		 query +="("+cve+",'"+titulo+"',"+precio+","+cvep+","+inv+")";
		 DatabaseHlper dbh = new DatabaseHlper();
		 dbh.modificarVideojuego(query);
	}
	public static List<Videojuego> buscartodos() throws SQLException, DataBaseException
	{
		String query ="SELECT a.cve_vid, a.tit_vid, b.nom_prov provedor, a.pre_vid, a.inv_vid, a.cveprov_vid FROM videojuegos a INNER JOIN proveedores b ON a.cveprov_vid = b.cve_prov";
		
		DatabaseHlper dbh = new DatabaseHlper();
		List<Videojuego> Listaobj = dbh.seleccionarvideojuegos(query,Videojuego.class);
		// return 
		return Listaobj;
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
	
	public static void actuaizarVideojuego(int cve,String titulo,float precio,int cvep, int inv) throws SQLException, DataBaseException
	{
		String query="UPDATE videojuegos SET tit_vid='"+titulo+"',pre_vid="+precio+",cveprov_vid="+cvep+",inv_vid="+inv+" WHERE cve_vid="+cve+"";
		DatabaseHlper dbh = new DatabaseHlper();
		dbh.modificarVideojuego(query);	
	}
	public static void EliminarVideojuego(int cve) throws SQLException, DataBaseException
	{
		String query="DELETE FROM videojuegos WHERE cve_vid="+cve+"";
		DatabaseHlper dbh = new DatabaseHlper();
		dbh.EliminarVideojuego(query);
		
	}

}
