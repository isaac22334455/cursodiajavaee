package com.cursodia.javaee.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion //clase abstracta Accion
{
	public abstract String ejecutar(HttpServletRequest request,HttpServletResponse response);//metodo
	
	public static Accion getAccion(String tipo)
	{
		System.out.println(tipo);
		Accion accion= null;
		if(tipo.equals("mostrarvideojuegos.do"))
		{
			accion=new MostrarVideojuegoAccion();
		}
		else if(tipo.equals("FormularioInsertarVideojuego.do"))
		{
			accion= new FormularioInsertarVideojuegoAccion();
		}
		else if(tipo.equals("FormularioModificarVideojuego.do"))
		{
			accion= new FormularioModificarVideojuegoAccion();
		}
		else if(tipo.equals("InsertarVideojuego.do"))
		{
			accion = new InsertarVideojuegoAccion();
		}
		else if(tipo.equals("ModificarVideojuego.do"))
		{
			accion = new ModificarVideojuegoAccion();
		}
		else if(tipo.equals("EliminarVideojuego.do"))
		{
			accion = new BorrarVideojuegoAccion();
		}
		return accion;
	}
}
