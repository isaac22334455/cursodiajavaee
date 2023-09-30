package com.cursodia.javaee.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;

public class FormularioModificarProveedorAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String clave = request.getParameter("CVE");
	    int cve= Integer.parseInt(clave);
			//System.out.println("Valor de cveVid: " + cve);
	    Proveedor prov = null;
	   
		try {
			prov =new ProveedorDAOJPAImpl().seleccionar(cve);
			//listaprovedores = ProveedorDAO.buscarProvedorCveName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prov",prov);//se le asigna un atributo para acceder a el y otro atributo		
		//request.setAttribute("listaprovedores",listaprovedores);
		return "FormularioInsertarProveedor.jsp";
	}

}
