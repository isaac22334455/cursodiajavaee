package mx.com.cursodia.javaee.databaseh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databasehelper 
{
  
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost/gamers";
    private static final String usuario="root";
	private static final String clave="";
			
	public int modificarvideojuego(String query) throws SQLException
	{
		   Connection con = null;
		   Statement stm = null;
		   int filas = 0;
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(url,usuario,clave);
			stm= con.createStatement();
    	    filas = stm.executeUpdate(query);
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar"+e.getMessage()); 
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		   }
		   finally
		   {
		 	   if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return filas;	  
	}
	
	public ResultSet seleccionarvideojuegos(String query)throws SQLException
	{
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		 
		   try
		   {
			Class.forName(Driver);
			con= DriverManager.getConnection(url,usuario,clave);
			stm= con.createStatement();
		    rs= stm.executeQuery(query);
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar"+e.getMessage()); 
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		   }
		   finally
		   {
		 	 //  if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return rs;	  
	}
}
