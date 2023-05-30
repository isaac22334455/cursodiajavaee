/**
 * 
 */

 function validacion()
 {
	 var n1, n2, n3, n4, n5;
	 
	 n1=document.getElementById("cve").value;
	 n2=document.getElementById("tit").value;
	 n3=document.getElementById("pre").value;
	 n4=document.getElementById("cvep").value;
	 n5=document.getElementById("inv").value;
	 
	 if(n1==""||n2==""||n3==""||n4==""||n5=="")
	 {
		 debugger;
		 alert("campos vacios ");
		 return;
	 }
	 else
	 {
		document.forms[0].action = "InsertarVideojuego.jsp?cve="+n1+"&tit="+n2+"&pre="+n3+"&cvep="+n4+"&inventario="+n5;
		document.forms[0].method= "post";
		document.forms[0].submit();
		alert("todo correcto");
		
	 }
 }