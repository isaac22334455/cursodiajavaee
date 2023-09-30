<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
 <link rel="stylesheet" href="CSS/estilos.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
 <script src="JS/valid.js"></script>
<title>LISTA PROVEEDORES</title>
</head>
<body>
<%@page import="java.util.List" %>
<%@ page import="com.cursodia.javaee.beans.Proveedor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

  <nav class="w-100 d-flex mt-4 justify-content-end">
   <span class="mx-2">
        <a type="button"class="btn btn-secondary" href="FormularioInsertarProveedor.do">INSERTAR PROVEEDOR</a>
    </span>
    <span class="mx-2">
        <a type="button"class="btn btn-secondary" href="FormularioInsertarVideojuego.do">INSERTAR VIDEOJUEGO</a>
    </span>
    <span class="mx-2">
        <a type="button"class="btn btn-secondary" href="MostrarProveedor.do">MOSTRAR PROVEEDORES</a>
    </span>
    <span class="mx-2">
        <a type="button"class="btn btn-secondary" href="MostrarVideojuego.do">MOSTRAR VIDEOJUEGOS</a>
    </span>
 </nav>
<hr>

<table id="tabla" class="table table-bordered ">
 <thead>
    <tr align="center" class="table-dark">
    <th>CLAVE</th>
    <th>NOMBRE</th>
    <th>CORREO ELECTRONICO</th>
    <th>TELEFONO</th>
    <th>ACCION</th>
  </tr>
  </thead>
  <tbody>
 <c:forEach var="p" items="${listaprovedores}">
    <tr class="table-dark">
        <td align="center"><c:out value="${p.cve_prov}" /></td>
        <td align="center"><c:out value="${p.nom_prov}" /></td>
        <td align="center"><c:out value="${p.imei_prov}" /></td>
        <td align="center"><c:out value="${p.tel_prov}" /></td>
        <td align="center"><a type="button" class="btn btn-primary" href="FormularioModificarProveedor.do?CVE=${p.cve_prov}"><i class="fas fa-pencil-alt"></i></a></td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>