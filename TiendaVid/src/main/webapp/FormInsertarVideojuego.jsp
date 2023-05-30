<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html =lang "es">
<head>
<meta charset="utf-8">
  <link rel="stylesheet" href="CSS/estilos.css">
  <script src="JS/valid.js"></script>
<title>form</title>
</head>
<body>
<h1>FORMULARIO ALTA VIDEOJUEGOS</h1>
<hr><br>
	<form action="InsertarVideojuego.do" method="GET">
	<br>
	<label for="cve">CLAVE:</label><br>
	<input type="text" id="cve"name = "cve"><br>
	
	<label for="tit">TITULO:</label><br>
	<input type="text" id="tit" name = "tit"><br>
	
	<label for="pre">PRECIO:</label><br>
	<input type="text" id="pre" name = "pre"><br>
	
	<label for="cvep">CLAVE DEL PROVEEDOR:</label><br>
	<input type="text" id="cvep" name = "cvep"><br>
	
	<label for="inv">INVENTARIO:</label><br>
	<input type="text" id="inv" name = "inv"><br><br>
	
	<button type="submit" onclick="validacion()">ACEPTAR</button>
	</form>
</body>
</html>