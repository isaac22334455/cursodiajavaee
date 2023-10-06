package com.cursodia.javaee.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.DBH.DataBaseException;
import com.cursodia.javaee.acciones.Accion;
import com.cursodia.javaee.acciones.InsertarVideojuegoAccion;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
//aqui llegan los datos mediante el xml que se creo llamado webxml
public class Controlador extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	//este do obtiene una peticion y una respuesta de los tipos que se muestra
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		//se aplico reflexion
		//se respeta el principio -OCP-
		String url= request.getServletPath();
		Accion accion = null;// instansiamos la abstracta
		RequestDispatcher despachador = null;//atiende estas peticiones el despachador
		accion= Accion.getAccion(url);
		despachador= request.getRequestDispatcher(accion.ejecutar(request, response));
		despachador.forward(request, response);
	}	
}
