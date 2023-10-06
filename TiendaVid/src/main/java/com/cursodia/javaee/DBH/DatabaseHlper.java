package com.cursodia.javaee.DBH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseHlper<T> //<T>UTILIZAR GENERICOS
{
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost/gamers";
	private static final String Usuario="root";
	private static final String Clave="";
	
	public static Connection getConecction() throws ClassNotFoundException, SQLException
	{
	   Class.forName(Driver);
	   return DriverManager.getConnection(Url,Usuario,Clave);
	}
}
