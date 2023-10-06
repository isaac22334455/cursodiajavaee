package com.cursodia.javaee.acciones;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.IOC.AbstractFactory;

import com.cursodia.javaee.beans.Videojuego;
import com.cursodia.javaee.dao.VideojuegoDAOJPAImpl;

public class ModificarVideojuegoAccion extends Accion
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
			   AbstractFactory.getInstance("JDBC").getVideojuegoDAO().
			   guardarCambios(new Videojuego(cve, titulo, precio, cvep, inventario));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MostrarVideojuego.do";
	}

}
