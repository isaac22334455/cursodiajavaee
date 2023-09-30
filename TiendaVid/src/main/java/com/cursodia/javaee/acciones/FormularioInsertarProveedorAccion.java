package com.cursodia.javaee.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioInsertarProveedorAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			return "FormularioInsertarProveedor.jsp";
	}

}
