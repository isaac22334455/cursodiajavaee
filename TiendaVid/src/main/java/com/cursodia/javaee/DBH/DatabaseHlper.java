package com.cursodia.javaee.DBH;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;

public class DatabaseHlper<T> //<T>UTILIZAR GENERICOS
{
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost/gamers";
	private static final String Usuario="root";
	private static final String Clave="";
	
	public void modificarVideojuego(String query) throws SQLException, DataBaseException 
	{
		  Connection con=null;
		  Statement stm =null;
		 
		  int filas=0;
		try
		{
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm=con.createStatement();
			stm.executeUpdate(query);	
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
	}
	
	public void EliminarVideojuego(String query) throws SQLException, DataBaseException 
	{
		  Connection con=null;
		  Statement stm =null;
		 
		  int filas=0;
		try
		{
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm=con.createStatement();
			stm.executeUpdate(query);	
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
	//generico de metodo
	//ahora a parte de la query se obtiene la clase tambien
	//el generico hace que mi metodo se adapte a lo que se le pida gracias a reflection
	public List<T> seleccionarvideojuegos(String query,Class clase)throws DataBaseException
	{
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<T> listaObjetos= new ArrayList<T>();
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(Url,Usuario,Clave);
			stm= con.createStatement();
		    rs= stm.executeQuery(query);
		    while(rs.next())
		    {
		    	T objeto = (T)Class.forName(//al obtener el nombre trae todo su contenido"ruta"
		    			clase.getName())/*trae su nombre*/.getDeclaredConstructor()/*trae su constructor declarado*/.newInstance();//y le estamos obteniendo una instancia//este objeto puede ser lo que sea un metodo un tipo o una clase
		    	Method[] metodos = objeto.getClass().getDeclaredMethods();//array de metodos//trae todos los metodos internos y se listan aqui
		    	for(int i=0;i<metodos.length;i++)
		    	{
		    		if(metodos[i].getName().startsWith("set"))//si el metodo comienza con set hablamos del seter en el bean
		    		{
		    			if((metodos[i].getName().substring(3)).equals("cve_vid"))
		    			{
		    				metodos[i].invoke(objeto, //obtiene el bjeto en este caso la clase videojuego
			    					rs.getInt(metodos[i].getName().substring(3)/*quita las primeras 3 letras*/));//
		    			}
		    			
		    			else if((metodos[i].getName().substring(3)).equals("inv_vid"))
		    			{
		    				metodos[i].invoke(objeto, //obtiene el bjeto en este caso la clase videojuego
			    					rs.getInt(metodos[i].getName().substring(3)/*quita las primeras 3 letras*/));//
		    			}
		    			else if((metodos[i].getName().substring(3)).equals("pre_vid"))
		    			{
		    				metodos[i].invoke(objeto, //obtiene el bjeto en este caso la clase videojuego
			    					rs.getFloat(metodos[i].getName().substring(3)/*quita las primeras 3 letras*/));//
		    			}
		    			else if((metodos[i].getName().substring(3)).equals("cveprov_vid"))
		    			{
		    				metodos[i].invoke(objeto, //obtiene el bjeto en este caso la clase videojuego
			    					rs.getInt(metodos[i].getName().substring(3)/*quita las primeras 3 letras*/));//
		    			}
		    			else
		    			{
		    				metodos[i].invoke(objeto, //obtiene el bjeto en este caso la clase videojuego
			    					rs.getString(metodos[i].getName().substring(3)/*quita las primeras 3 letras*/));
		    			}	
		    		}
		    	}
		    listaObjetos.add(objeto);
	    	//lista.add(new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
		    //			rs.getString("provedor"),rs.getInt("inv_vid")));
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
		   } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return listaObjetos;	  
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
		    	//lista.add(new Proveedor(rs.getInt("cve_prov"),rs.getString("nom_prov")));
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
