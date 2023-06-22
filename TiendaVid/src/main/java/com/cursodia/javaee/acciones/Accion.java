package com.cursodia.javaee.acciones;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion //clase abstracta Accion
{
	public abstract String ejecutar(HttpServletRequest request,HttpServletResponse response);//metodo
	
	public static Accion getAccion(String tipo)
	{
		//se aplico reflexion
		Accion accion= null;
		//System.out.println(tipo);//quitar /
		tipo = tipo.substring(1,tipo.length());
		tipo = tipo.substring(0,tipo.length()-3);
		String text = Accion.class.getPackage()+"."+tipo+"Accion";
		
		text = text.substring(8,text.length());//quita el packague name
		try {
			Class c=Class.forName(text);	
		    accion= (Accion) c.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException |InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(text);
		System.out.println(accion);
		return accion;
	}
		
}
