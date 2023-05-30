<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- IMPORTS -->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%
   //extraer valores del form
   int cve= Integer.parseInt(request.getParameter("cve"));
   String titulo =request.getParameter("tit");
   float precio = Float.parseFloat(request.getParameter("pre"));
   int cvep = Integer.parseInt(request.getParameter("cvep"));
   int inventario=Integer.parseInt(request.getParameter("inv"));
   
   Connection con = null;
   Statement stm = null;
   
   int filas=0;
   try
   {
	    Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/gamers","root","");
		stm= con.createStatement();
		
		String query = "INSERT INTO videojuegos(cve_vid,tit_vid,pre_vid,cveprov_vid,inv_vid) VALUES ";
		query +="("+cve+",'"+titulo+"',"+precio+","+cvep+","+inventario+")";
		filas = stm.executeUpdate(query);
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
 	   if(stm != null)stm.close();
 	   //if(con != null)con.close(); 
   }
  
     response.sendRedirect("FormInsertarVideojuego.jsp");
 %>
