package com.cursodia.javaee.acciones;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.beans.Videojuego;

public class BorrarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		 int cve= Integer.parseInt(request.getParameter("CVE"));
		 try {
			Videojuego.EliminarVideojuego(cve);
		} catch (SQLException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "MostrarVideojuego.do";
	}
	

}
