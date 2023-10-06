package com.cursodia.javaee.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cursodia.javaee.DBH.DatabaseHlper;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
public abstract class GenericDAOJDBCImpl<T, Id extends Serializable> implements GenericDAO<T,Id>
{
	  private Class<T> clasedepersistencia;
	   @SuppressWarnings("unchecked")
	public GenericDAOJDBCImpl()
	   {
		   
		   this.clasedepersistencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	   }
	@SuppressWarnings("unchecked")
	@Override
	   public T seleccionar (Id id)
	   {
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<T> obj= new ArrayList<T>();
		   try
		   {
			con= DatabaseHlper.getConecction();
			stm= con.createStatement();
			if(clasedepersistencia.getSimpleName().equalsIgnoreCase("Videojuego"))
			{
			   rs= stm.executeQuery("SELECT * FROM videojuegos WHERE cve_vid="+id); 
			   while(rs.next())
			    {
			    	obj.add((T) new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
			    			rs.getInt("cveprov_vid"),rs.getInt("inv_vid")));
			    }
			}
			else if(clasedepersistencia.getSimpleName().equalsIgnoreCase("Proveedor"))
			{
			   rs= stm.executeQuery("SELECT * FROM proveedores WHERE cve_prov="+id); 
			   while(rs.next())
				{
				  obj.add((T) new Proveedor(rs.getInt("cve_prov"),rs.getString("nom_prov"),rs.getString("imei_prov"),
				    	  rs.getString("tel_prov")));
				}
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
		return obj.get(0);
	   }
	   @SuppressWarnings("unchecked")
	@Override
	   public List<T> buscarTodos()
		{
		   
		   Connection con = null;
		   Statement stm = null;
		   ResultSet rs= null;
		   List<T> lista=  new ArrayList<T>();
		   try
		   {
			con= DatabaseHlper.getConecction();
			stm= con.createStatement();
			if(clasedepersistencia.getSimpleName().equalsIgnoreCase("Videojuego"))
			{
			   rs= stm.executeQuery("SELECT * FROM videojuegos"); 
			   while(rs.next())
				{
				  lista.add((T) new Videojuego(rs.getInt("cve_vid"),rs.getString("tit_vid"),rs.getFloat("pre_vid"),
				  rs.getInt("cveprov_vid"),rs.getInt("inv_vid")));
				}
			}
			else if(clasedepersistencia.getSimpleName().equalsIgnoreCase("Proveedor"))
			{
				rs= stm.executeQuery("SELECT * FROM videojuegos"); 
				while(rs.next())
			    {
				  lista.add((T) new Proveedor(rs.getInt("cve_prov"),rs.getString("nom_prov"),rs.getString("imei_prov"),
				    	  rs.getString("tel_prov")));
			    }
			}
		   }catch(ClassNotFoundException e)
		   {
		 	  System.out.println("error al cargar: "+e.getMessage()); 
		   }
		   catch(SQLException e)
		   {
		 	   System.out.println("error al acceder"+e.getMessage()); 
		   }
		   finally
		   {
		 	   //if(stm != null)stm.close();
		 	   //if(con != null)con.close(); 
		   }
		   return lista;
		}
	   
	   @Override
	    public void borrar(T objeto)
	    {
		    Connection con = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		        con = DatabaseHlper.getConecction();
		        
		        if (objeto instanceof Videojuego) {
		            Videojuego videojuego = (Videojuego) objeto;
		            pstmt = con.prepareStatement("DELETE FROM videojuegos WHERE cve_vid = ?");
		            pstmt.setInt(1, videojuego.getcve_vid());
		        } else if (objeto instanceof Proveedor) {
		            Proveedor proveedor = (Proveedor) objeto;
		            pstmt = con.prepareStatement( "DELETE FROM proveedores WHERE cve_prov = ?");
		            pstmt.setInt(1, proveedor.getCve_prov()); 
		            } else {
		            throw new IllegalArgumentException("Tipo de objeto no válido para eliminar.");
		        }
		        pstmt.executeUpdate();
		       }catch(ClassNotFoundException e)
			   {
			 	  System.out.println("error al cargar: "+e.getMessage()); 
			   }
			   catch(SQLException e)
			   {
			 	   System.out.println("error al acceder"+e.getMessage()); 
			   }finally 
			   {
		        try {
		            if (pstmt != null) {
		                pstmt.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
			 
	    }
	    @Override
		public void insertar(T objeto)
		{
	    	 Connection con=null;
	    	 PreparedStatement pstmt = null;
			 
			  int filas=0;
			  try
				{
					
				    con = DatabaseHlper.getConecction();
				    if (objeto instanceof Videojuego) {
			            Videojuego videojuego = (Videojuego) objeto;
			            String insertQuery = "INSERT INTO videojuegos (cve_vid, tit_vid, pre_vid, cveprov_vid, inv_vid) VALUES (?, ?, ?, ?, ?)";
			            pstmt = con.prepareStatement(insertQuery);
			            pstmt.setInt(1, videojuego.getcve_vid());
			            pstmt.setString(2, videojuego.gettit_vid());
			            pstmt.setFloat(3, videojuego.getpre_vid());
			            pstmt.setInt(4, videojuego.getcveprov_vid());
			            pstmt.setInt(5, videojuego.getinv_vid());
			        } else if (objeto instanceof Proveedor) {
			            Proveedor proveedor = (Proveedor) objeto;
			            String insertQuery = "INSERT INTO proveedores (cve_prov, nombre_prov, direccion_prov, telefono_prov) VALUES (?, ?, ?, ?)";
			            pstmt = con.prepareStatement(insertQuery);
			            pstmt.setInt(1, proveedor.getCve_prov());
			            pstmt.setString(2, proveedor.getNom_prov());
			            pstmt.setString(3, proveedor.getImei_prov());
			            pstmt.setString(4, proveedor.getTel_prov());
			        } else {
			            throw new IllegalArgumentException("Tipo de objeto no válido para insertar.");
			        }
			        pstmt.executeUpdate();	
				 }catch(ClassNotFoundException e)
				   {
				 	  System.out.println("error al cargar: "+e.getMessage());
				   }
				   catch(SQLException e)
				   {
				 	   System.out.println("error al acceder"+e.getMessage()); 
				   }
				   finally
				   {
				 	   //if(stm != null)stm.close();
				 	   //if(con != null)con.close(); 
				   }
				
		}
	    @Override
		public void guardarCambios(T objeto)
		{
	    	  Connection con = null;
	    	    PreparedStatement pstmt = null;

	    	    try {
	    	        con = DatabaseHlper.getConecction();
	    	        
	    	        if (objeto instanceof Videojuego) {
	    	            Videojuego videojuego = (Videojuego) objeto;
	    	            String updateQuery = "UPDATE videojuegos SET tit_vid = ?, pre_vid = ?, cveprov_vid = ?, inv_vid = ? WHERE cve_vid = ?";
	    	            pstmt = con.prepareStatement(updateQuery);
	    	            pstmt.setString(1, videojuego.gettit_vid());
	    	            pstmt.setFloat(2, videojuego.getpre_vid());
	    	            pstmt.setInt(3, videojuego.getcveprov_vid());
	    	            pstmt.setInt(4, videojuego.getinv_vid());
	    	            pstmt.setInt(5, videojuego.getcve_vid());
	    	        } else if (objeto instanceof Proveedor) {
	    	            Proveedor proveedor = (Proveedor) objeto;
	    	            String updateQuery = "UPDATE proveedores SET nom_prov = ?, imei_prov = ?, tel_prov = ? WHERE cve_prov = ?";
	    	            pstmt = con.prepareStatement(updateQuery);
	    	            pstmt.setString(1, proveedor.getNom_prov());
	    	            pstmt.setString(2, proveedor.getImei_prov());
	    	            pstmt.setString(3, proveedor.getTel_prov());
	    	            pstmt.setInt(4, proveedor.getCve_prov());
	    	        } else {
	    	            throw new IllegalArgumentException("Tipo de objeto no válido para actualizar.");
	    	        }

	    	        // Ejecutar la sentencia UPDATE
	    	        pstmt.executeUpdate();
	    	    } catch(ClassNotFoundException e)
				   {
				 	  System.out.println("error al cargar: "+e.getMessage());
				   }
				   catch(SQLException e)
				   {
				 	   System.out.println("error al acceder"+e.getMessage()); 
				   }finally {
	    	        // Asegúrate de cerrar la conexión y el PreparedStatement en este bloque "finally"
	    	        try {
	    	            if (pstmt != null) {
	    	                pstmt.close();
	    	            }
	    	            if (con != null) {
	    	                con.close();
	    	            }
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	        }
	    	    }
		}   
}
