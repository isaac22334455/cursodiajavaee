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
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
//aqui llegan los datos mediante el xml que se creo llamado webxml
public class ControladorVideojuegos extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	//este do obtiene una peticion y una respuesta de los tipos que se muestra
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		//System.out.println("entro al controlador");
		try {
	    RequestDispatcher despachador = null;//atiende estas peticiones el despachador
		if(request.getServletPath().equals("/mostrarvideojuegos.do"))// se captura el servletpat la ruta de la cual viene la peticion
		{
			List<Videojuego> listaVideojuegos = Videojuego.buscartodos();
			request.setAttribute("listaVideojuegos",listaVideojuegos);//se le asigna un atributo para acceder a el y otro atributo
			
			List<Proveedor> listaprovedores = Proveedor.buscarProvedorCveName();
			request.setAttribute("listaprovedores",listaprovedores);
			
			despachador=request.getRequestDispatcher("mostrarvideojuegos.jsp");//despues de que haga su trabajo esta sera su pagina vista su objetivo
			despachador.forward(request, response);//despues se le hace un forward se le agrega todo lo que se empaqueto en el recuest y el respons es de que ya realizo su trabajo y que ahora si se ejecute en este caso el mostrar videojuegos	
		}
		
		else if(request.getServletPath().equals("/FormInsertarVideojuego.do"))
		{
			String clave = request.getParameter("CVE");
			if(Objects.isNull(clave))
			{}
			else
			{
				int cve= Integer.parseInt(clave);
				//System.out.println("Valor de cveVid: " + cve);
				Videojuego vid =Videojuego.seleccionarvid(cve);
				request.setAttribute("vid",vid);//se le asigna un atributo para acceder a el y otro atributo
			}
					
			List<Proveedor> listaprovedores = Proveedor.buscarProvedorCveName();
			request.setAttribute("listaprovedores",listaprovedores);
			
			despachador=request.getRequestDispatcher("FormInsertarVideojuego.jsp");//despues de que haga su trabajo esta sera su pagina vista su objetivo
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/InsertarVideojuego.do"))
		{
			   int cve= Integer.parseInt(request.getParameter("cve"));
			   String titulo =request.getParameter("tit");
			   float precio = Float.parseFloat(request.getParameter("pre"));
			   int cvep = Integer.parseInt(request.getParameter("cvep"));
			   int inventario=Integer.parseInt(request.getParameter("inv"));
			   Videojuego.insertar(cve, titulo, precio, cvep, inventario);
			   response.sendRedirect("mostrarvideojuegos.do");	
			   //despachador.forward(request, response);//despues se le hace un forward se le agrega todo lo que se empaqueto en el recuest y el respons es de que ya realizo su trabajo y que ahora si se ejecute en este caso el mostrar videojuegos	
		}
		else if(request.getServletPath().equals("/ModificarVideojuego.do"))
		{
			   int cve= Integer.parseInt(request.getParameter("cve"));
			   String titulo =request.getParameter("tit");
			   float precio = Float.parseFloat(request.getParameter("pre"));
			   int cvep = Integer.parseInt(request.getParameter("cvep"));
			   int inventario=Integer.parseInt(request.getParameter("inv"));
			   Videojuego.actuaizarVideojuego(cve, titulo, precio, cvep, inventario);
			   response.sendRedirect("mostrarvideojuegos.do");	
			   //despachador.forward(request, response);//despues se le hace un forward se le agrega todo lo que se empaqueto en el recuest y el respons es de que ya realizo su trabajo y que ahora si se ejecute en este caso el mostrar videojuegos	
		}
		} catch (SQLException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
