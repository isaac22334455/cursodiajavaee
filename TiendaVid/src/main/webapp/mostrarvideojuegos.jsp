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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<br>
<h1>Listado de Videojuegos</h1>
 <div class="row">
  <div class="col">
    <select class="form-select bg-dark text-light" name="cvep" id="cvep">
      <option value="todos">Mostrar todos</option>
      <c:forEach var="proveedor" items="${listaprovedores}">
         <option value="${proveedor.nom_prov}"><c:out value="${proveedor.nom_prov}" /></option>
      </c:forEach>
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
    <th>ACCION</th>
  </tr>
  </thead>
  <tbody>
 <c:forEach var="v" items="${listaVideojuegos}">
    <tr class="table-dark">
        <td align="center"><c:out value="${v.cve_vid}" /></td>
        <td align="center"><c:out value="${v.tit_vid}" /></td>
        <td align="right"><c:out value="${v.pre_vid}" /></td>
        <td align="center"><c:out value="${v.provedor}" /></td>
        <td align="center"><c:out value="${v.inv_vid}" /></td>
        <td align="center"><a type="button" class="btn btn-primary" href="FormInsertarVideojuego.do?CVE=${v.cve_vid}"><i class="fas fa-pencil-alt"></i></a></td>
        <td align="center"><a type="button" class="btn btn-primary" href="FormInsertarVideojuego.do?CVE=${v.cve_vid}"><i class="fas fa-trash-alt"></i></a></td>
    </tr>
</c:forEach>
</tbody>
</table>
<a type="button"class="btn btn-dark" href="FormInsertarVideojuego.do">INSERTAR VIDEOJUEGO</a>
</div>
</body>
</html>