package com.cursodia.javaee.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cursodia.javaee.DBH.DatabaseHlper;
import com.cursodia.javaee.beans.Videojuego;

public class VideojuegoDAOJDBCImpl extends GenericDAOJDBCImpl<Videojuego,Integer> implements VideojuegoDAO
{
	@Override
	public List<Videojuego> sortByProv(int cveprov)
	{
		  Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<Videojuego> Lista= new ArrayList<Videojuego>();
		   try
		   {
			con= DatabaseHlper.getConecction();
			stm= con.createStatement();
			rs= stm.executeQuery("SELECT * FROM videojuegos WHERE cveprov_vid="+cveprov); 
			while(rs.next())
			   {
				 Lista.add(new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
			    			rs.getInt("cveprov_vid"),rs.getInt("inv_vid")));
			    }
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar: "+e.getMessage()); 
		 	 // throw new DataBaseException("error al cargar la clase",e);
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		 	 // throw new DataBaseException("error de SQL",e);
		   }
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		return Lista;
	}
}
