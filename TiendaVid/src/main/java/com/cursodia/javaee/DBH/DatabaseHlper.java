package com.cursodia.javaee.DBH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;

public class DatabaseHlper 
{
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost/gamers";
	private static final String Usuario="root";
	private static final String Clave="";
	
	public int modificarVideojuego(String query) throws SQLException, DataBaseException
	{
		  Connection con=null;
		  Statement stm =null;
		 
		  int filas=0;
		try
		{
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm=con.createStatement();
			filas = stm.executeUpdate(query);	
		 }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar: "+e.getMessage()); 
		 	  throw new DataBaseException("error al cargar la clase",e);
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		 	  throw new DataBaseException("error de SQL",e);
		   }
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		return filas;
	}
	
	public List<Videojuego> seleccionarvideojuego(String query)throws SQLException, DataBaseException
	{
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<Videojuego> lista= new ArrayList<Videojuego>();
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm= con.createStatement();
		    rs= stm.executeQuery(query);
		    while(rs.next())
		    {
		    	lista.add(new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
		    			rs.getInt("cveprov_vid"),rs.getInt("inv_vid")));
		    }
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar: "+e.getMessage()); 
		 	  throw new DataBaseException("error al cargar la clase",e);
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		 	  throw new DataBaseException("error de SQL",e);
		   }
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return lista;	  
	}
	
	public List<Videojuego> seleccionarvideojuegos(String query)throws SQLException, DataBaseException
	{
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<Videojuego> lista= new ArrayList<Videojuego>();
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm= con.createStatement();
		    rs= stm.executeQuery(query);
		    while(rs.next())
		    {
		    	lista.add(new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
		    			rs.getString("provedor"),rs.getInt("inv_vid")));
		    }
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar: "+e.getMessage()); 
		 	  throw new DataBaseException("error al cargar la clase",e);
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		 	  throw new DataBaseException("error de SQL",e);
		   }
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return lista;	  
	}
	
	public List<Proveedor> seleccionarProveedores(String query)throws SQLException
	{
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<Proveedor> lista= new ArrayList<Proveedor>();
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm= con.createStatement();
		    rs= stm.executeQuery(query);
		    while(rs.next())
		    {
		    	lista.add(new Proveedor(rs.getInt("cve_prov"),rs.getString("nom_prov")));
		    }
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar"+e.getMessage()); 
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		   }
		   
		   {
		 	 if(stm != null)stm.close();
		 	   if(con != null)con.close(); 
		   }
		   return lista;	  
	}
}
