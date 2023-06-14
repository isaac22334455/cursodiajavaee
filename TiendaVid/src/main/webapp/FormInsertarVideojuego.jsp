
<%@ page import="com.cursodia.javaee.beans.Proveedor"%>
<%@ page import="com.cursodia.javaee.beans.Videojuego"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Objects"%>

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
 <%
 String clave = request.getParameter("CVE");
 if(Objects.isNull(clave))
 {%>
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
	          <select class="form-select" name="cvep"id="cvep">
	            <% 
	            List<Proveedor> lista = Proveedor.buscarProvedorCveName();
	              for (Proveedor v:lista)
	              { %>
	                <option value="<%= v.getCve_prov() %>"><%= v.getNom_prov()%></option>   
	              <% }
	            %>
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
	    <button type="button" onclick="validacion()"class="btn btn-dark">ACEPTAR</button>
	  </form>
	</div> 
 <%}
 else
 {
	 int cve= Integer.parseInt(clave);
	 Videojuego v=Videojuego.seleccionarvid(cve);
	 %> 
	 <div class="container">
	  <h1 class="mt-5">FORMULARIO ALTA VIDEOJUEGOS</h1>
	  <hr><br>
	  <form class="form-group" action="ModificarVideojuego.do" method="GET">
	    <div class="row">
	      <div class="col-md-4">
	        <div class="form-group">
	          <label for="cve">CLAVE:</label><br>
	          <input type="text" id="cve" name="cve"value="<%= v.getCve_vid() %>" class="form-control"><br>
	        </div>
	      </div>
	      <div class="col-md-4">
	        <div class="form-group">
	          <label for="tit">TITULO:</label><br>
	          <input type="text" id="tit" name="tit"value="<%= v.getTit_vid() %>" class="form-control"><br>
	        </div>
	      </div>
	      <div class="col-md-4">
	        <div class="form-group">
	          <label for="pre">PRECIO:</label><br>
	          <input type="number" id="pre" name="pre" value="<%= v.getPre_vid() %>"class="form-control"><br>
	        </div>
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-md-6">
	        <div class="form-group">
	          <label for="prov">PROVEEDOR:</label><br>
	          <select class="form-select" name="cvep"id="cvep">
	                 <% 
	            List<Proveedor> lista = Proveedor.buscarProvedorCveName();
	              for (Proveedor v2:lista)
	              { 
	                 if(v2.getCve_prov()==v.getCveprov_vid())
	                 {%>
	                	 <option value="<%= v2.getCve_prov()%>"><%= v2.getNom_prov()%></option>  
	                 <%}
	                  
	               }
	              for (Proveedor v2 : lista) {
	            	    if (v2.getCve_prov() != v.getCveprov_vid()) { // Ignorar la coincidencia previa
	            	  %>
	            	      <option value="<%= v2.getCve_prov() %>"><%= v2.getNom_prov() %></option>  
	            	  <% }
	            	  }
	            %>
	          </select>
	        </div>
	      </div>
	      <div class="col-md-6">
	        <div class="form-group">
	          <label for="inv">INVENTARIO:</label><br>
	          <input type="text" id="inv" name="inv"value="<%= v.getInv_vid() %>" class="form-control"><br><br>
	        </div>
	      </div>
	    </div>
	    <button type="button" onclick="validacion2()"class="btn btn-dark">ACEPTAR</button>
	  </form>
	</div> 
 <%}
 
 %>
</body>
</html>