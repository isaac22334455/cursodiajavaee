package com.cursodia.javaee.acciones;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.beans.Proveedor;

public class FormularioInsertarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Proveedor> listaprovedores = null;
		try {
			listaprovedores = Proveedor.buscarProvedorCveName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaprovedores",listaprovedores);
		return "FormularioInsertarVideojuego.jsp";
	}

}
