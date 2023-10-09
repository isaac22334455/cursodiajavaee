package com.cursodia.javaee.acciones;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.IOC.AbstractFactory;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;

public class FormularioInsertarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Proveedor> listaprovedores = null;
		try {
			listaprovedores = AbstractFactory.getInstance("JPA").getProveedor().buscarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaprovedores",listaprovedores);
		return "FormularioInsertarVideojuego.jsp";
	}

}
