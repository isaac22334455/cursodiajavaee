<%@ page import="com.cursodia.javaee.beans.Proveedor"%>
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
		<h1 class="mt-5">FORMULARIO ALTA PROVEEDORES</h1>
		<hr><br>
		<form class="form-group" action="InsertarProveedor.do" method="GET">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="cve">CLAVE:</label><br>
						<input type="text" id="cve" name="cve" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="nom">NOMBRE:</label><br>
						<input type="nom" id="nom" name="nom" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="imei">CORREO ELECTRONICO:</label><br>
						<input  id="imei" name="imei" class="form-control"><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="num">NUMERO:</label><br>
						<input  id="num" name="num" class="form-control"><br>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-dark">ACEPTAR</button>
		</form>
	</div>
</c:if>
<c:if test="${not empty param.CVE}">
	<div class="container">
		<h1 class="mt-5">FORMULARIO MODIFICAR PROVEEDOR</h1>
		<hr><br>
		<form class="form-group" action="ModificarProveedor.do" method="GET">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="cve">CLAVE:</label><br>
						<input type="text" id="cve" name="cve" value="${prov.cve_prov}"class="form-control"readonly><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="nom">NOMBRE:</label><br>
						<input type="nom" id="nom" name="nom"value="${prov.nom_prov}" class="form-control"><br>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="imei">CORREO ELECTRONICO:</label><br>
						<input  id="imei" name="imei" value="${prov.imei_prov}"class="form-control"><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="tel">NUMERO:</label><br>
						<input  id="tel" name="tel" value="${prov.tel_prov}"class="form-control"><br>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-dark">ACEPTAR</button>
		</form>
	</div>
</c:if>

</body>
</html>