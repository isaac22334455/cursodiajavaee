package com.cursodia.javaee.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.IOC.AbstractFactory;

import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;

public class InsertarProveedorAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		   int cve= Integer.parseInt(request.getParameter("cve"));
		   String nom =request.getParameter("nom");
		   String imei =request.getParameter("imei");
		   String num = request.getParameter("num");
		   try {
			   AbstractFactory.getInstance("JDBC").getProveedor().insertar(new Proveedor(cve, nom, imei, num));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "MostrarProveedor.do";//retorna un String lo que se espera en el string el componente o la llamada que va a ejecutar
		            // despues de regresar de este.
	}

}
