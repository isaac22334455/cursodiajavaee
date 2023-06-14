<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
 <link rel="stylesheet" href="CSS/estilos.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
 <script src="JS/valid.js"></script>
<title>LISTA VIDEOJUEGOS</title>
</head>
<body>

<%@page import="java.util.List" %>
<%@ page import="com.cursodia.javaee.beans.Videojuego"%>
<%@ page import="com.cursodia.javaee.beans.Proveedor"%>

<div class="container">
<br>
<h1>Listado de Videojuegos</h1>
    <div class="row w-50">
 
  <div class="col">
    <select class="form-select bg-dark text-light" name="cvep" id="cvep">
      <option value="todos">Mostrar todos</option>
      <% 
      List<Proveedor> lista = Proveedor.buscarProvedorCveName();
        for (Proveedor v:lista)
        { %>
          <option value="<%= v.getNom_prov() %>"><%= v.getNom_prov() %></option>   
        <% }
      %>
    </select>
  </div>
  <div class="col">
    <a type="button" onclick="aplicar()" class="btn btn-success"><i class="fas fa-filter"></i></a>
  </div>
</div>

<hr>
<table id="tabla" class="table table-bordered ">
 <thead>
    <tr align="center" class="table-dark">
    <th>CLAVE</th>
    <th>TITULO</th>
    <th>PRECIO</th>
    <th>PROVEEDOR</th>
    <th>CANTIDAD</th>
    <th>ACCION</th>
  </tr>
  </thead>
  <tbody>
  <% 	
	  //extraer valores del form

	  List<Videojuego> lista2 = Videojuego.buscartodos();
	  for(Videojuego v:lista2)
	  {%>
	  <tr class="table-dark">
	  <td align="center"><%=v.getCve_vid()%></td>
	  <td align="center"><%=v.getTit_vid()%></td>
	  <td align="right"> <%=v.getPre_vid()%></td>
	  <td align="center"><%=v.getNomprov_vid()%></td>
	  <td align="center"><%=v.getInv_vid()%></td>
	  <td align="center"><a type="button"class="btn btn-primary" href="FormInsertarVideojuego.jsp?CVE=<%=v.getCve_vid()%>"><i class="fas fa-pencil-alt"></i> </a> </td>
	   </tr> 
	     
	  <% }
%>
</tbody>
</table>
<a type="button"class="btn btn-dark" href="FormInsertarVideojuego.jsp">INSERTAR VIDEOJUEGO</a>
</div>
</body>
</html>