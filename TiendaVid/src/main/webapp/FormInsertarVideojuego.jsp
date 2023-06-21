
<%@ page import="com.cursodia.javaee.beans.Proveedor"%>
<%@ page import="com.cursodia.javaee.beans.Videojuego"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Objects"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- para usar las funciones c -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html =lang "es">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
 <link rel="stylesheet" href="CSS/estilos.css">
<meta charset="utf-8"> 
  <script src="JS/valid.js"></script>
<title>form</title>

</head>
<body>
<c:if test="${empty param.CVE}">
	<div class="container">
		<h1 class="mt-5">FORMULARIO ALTA VIDEOJUEGOS</h1>
		<hr><br>
		<form class="form-group" action="InsertarVideojuego.do" method="GET">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="cve">CLAVE:</label><br>
						<input type="text" id="cve" name="cve" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="tit">TITULO:</label><br>
						<input type="text" id="tit" name="tit" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="pre">PRECIO:</label><br>
						<input type="number" id="pre" name="pre" class="form-control"><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="prov">PROVEEDOR:</label><br>
						<select class="form-select" name="cvep" id="cvep">
							<c:forEach var="v" items="${listaprovedores}">
								<option value="${v.cve_prov}">${v.nom_prov}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="inv">INVENTARIO:</label><br>
						<input type="text" id="inv" name="inv" class="form-control"><br><br>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-dark">ACEPTAR</button>
		</form>
	</div>
</c:if>
<c:if test="${not empty param.CVE}">
	<div class="container">
		<h1 class="mt-5">FORMULARIO ALTA VIDEOJUEGOS</h1>
		<hr><br>
		<form class="form-group" action="ModificarVideojuego.do" method="GET">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="cve">CLAVE:</label><br>
						<input type="text" id="cve" name="cve" value="${vid.cve_vid}" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="tit">TITULO:</label><br>
						<input type="text" id="tit" name="tit" value="${vid.tit_vid}" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="pre">PRECIO:</label><br>
						<input type="number" id="pre" name="pre" value="${vid.pre_vid}" class="form-control"><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="prov">PROVEEDOR:</label><br>
						<select class="form-select" name="cvep" id="cvep">
							<c:forEach var="v" items="${listaprovedores}">
								<c:if test="${v.cve_prov == vid.cveprov_vid}">
									<option value="${v.cve_prov}" selected>${v.nom_prov}</option>
								</c:if>
								<c:if test="${v.cve_prov != vid.cveprov_vid}">
									<option value="${v.cve_prov}">${v.nom_prov}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="inv">INVENTARIO:</label><br>
						<input type="text" id="inv" name="inv" value="${vid.inv_vid}" class="form-control"><br><br>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-dark">ACEPTAR</button>
		</form>
	</div>
</c:if>

</body>
</html>