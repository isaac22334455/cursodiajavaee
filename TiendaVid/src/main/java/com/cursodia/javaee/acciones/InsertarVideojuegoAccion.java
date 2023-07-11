package com.cursodia.javaee.acciones;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.beans.Videojuego;
import com.cursodia.javaee.dao.VideojuegoDAO;

public class InsertarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
	{
		   int cve= Integer.parseInt(request.getParameter("cve"));
		   String titulo =request.getParameter("tit");
		   float precio = Float.parseFloat(request.getParameter("pre"));
		   int cvep = Integer.parseInt(request.getParameter("cvep"));
		   int inventario=Integer.parseInt(request.getParameter("inv"));
		   try {
			VideojuegoDAO.insertar(cve, titulo, precio, cvep, inventario);
			} catch (SQLException | DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "MostrarVideojuego.do";//retorna un String lo que se espera en el string el componente o la llamada que va a ejecutar
		            // despues de regresar de este.
	}

}
