/**
 * 
 */
function validacion2()
 {
	 var n1, n2, n3, n4, n5;
	 
	 n1=document.getElementById("cve").value;
	 n2=document.getElementById("tit").value;
	 n3=document.getElementById("pre").value;
	 n4=document.getElementById("cvep").value;
	 n5=document.getElementById("inv").value;
	 
	 if(n1==""||n2==""||n3==""||n5=="")
	 {
		 debugger;
		 alert("campos vacios ");
		 return;
	 }
	 else
	 {
		document.forms[0].action = "ModificarVideojuego.do?cve="+n1+"&tit="+n2+"&pre="+n3+"&cvep="+n4+"&inventario="+n5;
		document.forms[0].method= "post";
		document.forms[0].submit();
		alert("todo correcto");
		
	 }
 }

 function validacion()
 {
	 var n1, n2, n3, n4, n5;
	 
	 n1=document.getElementById("cve").value;
	 n2=document.getElementById("tit").value;
	 n3=document.getElementById("pre").value;
	 n4=document.getElementById("cvep").value;
	 n5=document.getElementById("inv").value;
	 
	 if(n1==""||n2==""||n3==""||n5=="")
	 {
		 debugger;
		 alert("campos vacios ");
		 return;
	 }
	 else
	 {
		document.forms[0].action = "InsertarVideojuego.do?cve="+n1+"&tit="+n2+"&pre="+n3+"&cvep="+n4+"&inventario="+n5;
		document.forms[0].method= "post";
		document.forms[0].submit();
		alert("todo correcto");
		
	 }
 }
function aplicar()
{ 
	  var select = document.getElementById("cvep");
  var selectedProveedor = select.value;
  
  var tabla = document.getElementById("tabla");
  var filas = tabla.getElementsByTagName("tr");

  for (var i = 1; i < filas.length; i++) { // Comenzamos desde 1 para omitir la fila de encabezado
    var celdaProveedor = filas[i].getElementsByTagName("td")[3]; // Utilizamos el índice 3 para la columna del proveedor
    
    if (selectedProveedor === "todos" || celdaProveedor.textContent === selectedProveedor) {
      filas[i].style.display = "";
    } else {
      filas[i].style.display = "none";
    }
  }
}