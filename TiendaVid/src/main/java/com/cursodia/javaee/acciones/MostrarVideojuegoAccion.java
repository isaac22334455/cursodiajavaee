package com.cursodia.javaee.acciones;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;

public class MostrarVideojuegoAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Videojuego> listaVideojuegos = null;
		List<Proveedor> listaprovedores = null;
		try {
			listaVideojuegos = Videojuego.buscartodos();
			listaprovedores= Proveedor.buscarProvedorCveName();
		} catch (SQLException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaVideojuegos",listaVideojuegos);//se le asigna un atributo para acceder a el y otro atributo
		request.setAttribute("listaprovedores",listaprovedores);
		return "mostrarvideojuegos.jsp";
	}

}
