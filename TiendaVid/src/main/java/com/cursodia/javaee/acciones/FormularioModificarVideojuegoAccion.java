package com.cursodia.javaee.acciones;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cursodia.javaee.beans.Proveedor;
import com.cursodia.javaee.beans.Videojuego;
import com.cursodia.javaee.dao.ProveedorDAOJPAImpl;
import com.cursodia.javaee.dao.VideojuegoDAOJPAImpl;

public class FormularioModificarVideojuegoAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String clave = request.getParameter("CVE");
	    int cve= Integer.parseInt(clave);
			//System.out.println("Valor de cveVid: " + cve);
	    Videojuego vid = null;
	    List<Proveedor> listaprovedores = null;
		try {
			vid =new VideojuegoDAOJPAImpl().seleccionar(cve);
			listaprovedores = ProveedorDAOJPAImpl.buscarProvedorCveName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("vid",vid);//se le asigna un atributo para acceder a el y otro atributo		
		request.setAttribute("listaprovedores",listaprovedores);
		return "FormularioInsertarVideojuego.jsp";
	}

}
