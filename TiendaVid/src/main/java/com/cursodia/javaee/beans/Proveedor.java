package com.cursodia.javaee.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cursodia.javaee.DBH.DatabaseHlper;

public class Proveedor 
{
	int cve_prov;
	String nom_prov;
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
	public int getCve_prov() {
		return cve_prov;
	}
	public static List<Proveedor> buscarProvedorCveName() throws SQLException
	{
		String query = "SELECT cve_prov,nom_prov FROM proveedores";
		DatabaseHlper dbh = new DatabaseHlper();
		return dbh.seleccionarProveedores(query);	
	}

}
