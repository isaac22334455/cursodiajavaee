package com.cursodia.javaee.acciones;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.IOC.AbstractFactory;

import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;

public class ModificarProveedorAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		   int cve= Integer.parseInt(request.getParameter("cve"));
		   String nom =request.getParameter("nom");
		   String imei =request.getParameter("imei");
		   String tel = request.getParameter("tel");
		   System.out.println(cve);
		   try {
			   AbstractFactory.getInstance("JDBC").getProveedor().
			   guardarCambios(new Proveedor(cve, nom, imei, tel));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MostrarProveedor.do";
	}

}
