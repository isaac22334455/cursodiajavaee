<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- IMPORTS -->
<%@page import="mx.com.cursodia.javaee.beans.Videojuego" %>
<%
   //extraer valores del form
   int cve= Integer.parseInt(request.getParameter("cve"));
   String titulo =request.getParameter("tit");
   float precio = Float.parseFloat(request.getParameter("pre"));
   int cvep = Integer.parseInt(request.getParameter("cvep"));
   int inventario=Integer.parseInt(request.getParameter("inv"));
   Videojuego.insertar(cve, titulo, precio, cvep, inventario);
     response.sendRedirect("mostrarvideojuegos.jsp");
 %>
