package com.cursodia.javaee.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
import com.cursodia.javaee.dao.ProveedorDAO;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;
import com.cursodia.javaee.dao.VideojuegoDAOJPAImpl;

public class MostrarProveedorAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Proveedor> listaprovedores = null;
		try {
			//listaVideojuegos = new VideojuegoDAOJPAImpl().buscarTodos();
			listaprovedores= new ProveedorDAOJPAImpl().buscarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.setAttribute("listaVideojuegos",listaVideojuegos);//se le asigna un atributo para acceder a el y otro atributo
		request.setAttribute("listaprovedores",listaprovedores);
		return "mostrarProveedores.jsp";
	}

}
