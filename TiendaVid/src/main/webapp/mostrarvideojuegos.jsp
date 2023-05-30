<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LISTA VIDEOJUEGOS</title>
</head>
<body>

<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<% 
  ResultSet rs= null;
  try
  {   
	  rs=Videojuego.buscartodos();
	  while(rs.next())
	  {%>
	    <%=rs.getInt("cve_vid")%>
	    <%=rs.getString("tit_vid")%>
	    <%=rs.getFloat("pre_vid")%>
	    <%=rs.getInt("cveprov_vid")%>
	    <%=rs.getInt("inv_vid")%>
	      <br>
	  <%}
  }catch(SQLException e)
  {
	  System.out.println("error al cargar"+e.getMessage()); 
  }
  finally
  {
	   if(rs !=null)rs.close();   
  }
%>
<a href="formulariovideojuegoInsertarVideojuego.jsp">INSERTAR VIDEOJUEGO</a>
</body>
</html>