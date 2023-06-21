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
public class ControladorVideojuegos extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	//este do obtiene una peticion y una respuesta de los tipos que se muestra
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Accion accion = null;// instansiamos la abstracta
		RequestDispatcher despachador = null;//atiende estas peticiones el despachador
		if(request.getServletPath().equals("/mostrarvideojuegos.do"))// se captura el servletpat la ruta de la cual viene la peticion
		{
			despachador=request.getRequestDispatcher(accion.getAccion("mostrarvideojuegos.do").ejecutar(
					request, response));
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/FormInsertarVideojuego.do"))
		{	
			despachador=request.getRequestDispatcher(accion.getAccion("FormularioInsertarVideojuego.do").ejecutar(request, response));
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/FormModificarVideojuego.do"))
		{
			despachador=request.getRequestDispatcher(accion.getAccion("FormularioModificarVideojuego.do").ejecutar(request, response));
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/InsertarVideojuego.do"))
		{		
			   response.sendRedirect(accion.getAccion("InsertarVideojuego.do").ejecutar(request, response));	
	    }
		else if(request.getServletPath().equals("/ModificarVideojuego.do"))
		{  
			response.sendRedirect(accion.getAccion("ModificarVideojuego.do").ejecutar(request, response));	
		}
		else if(request.getServletPath().equals("/EliminarVideojuego.do"))
		{  
			response.sendRedirect(accion.getAccion("EliminarVideojuego.do").ejecutar(request, response));	
		}
	}	
}
