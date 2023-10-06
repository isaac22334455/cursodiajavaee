package com.cursodia.javaee.acciones;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cursodia.javaee.IOC.AbstractFactory;
import com.cursodia.javaee.dao.VideojuegoDAO;

public class BorrarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		 int cve= Integer.parseInt(request.getParameter("CVE"));
		 try {
			 VideojuegoDAO viddao =AbstractFactory.getInstance("JDBC").getVideojuegoDAO();
			 viddao.borrar(viddao.seleccionar(cve));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "MostrarVideojuego.do";
	}
	

}
