package com.cursodia.javaee.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursodia.javaee.IOC.AbstractFactory;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;
public class FiltrarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Videojuego> listaVideojuegos = null;
		List<Proveedor> listaprovedores = null;
		try {
			if(request.getParameter("CVE").equals("todos"))
			{
			  listaVideojuegos =AbstractFactory.getInstance("JPA").getVideojuegoDAO().buscarTodos();
			}
			else
			{
			  int cve = Integer.parseInt(request.getParameter("CVE"));	
			  listaVideojuegos =AbstractFactory.getInstance("JDBC").getVideojuegoDAO().sortByProv(cve) ;
			}
			listaprovedores = AbstractFactory.getInstance("JPA").getProveedor().buscarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaVideojuegos",listaVideojuegos);//se le asigna un atributo para acceder a el y otro atributo
		request.setAttribute("listaprovedores",listaprovedores);
		return "mostrarvideojuegos.jsp";
	}

}
