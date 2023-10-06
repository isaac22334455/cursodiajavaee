package com.cursodia.javaee.IOC;

public class AbstractFactory
{
	public static DAOFactory getInstance(String type) {
        if ("JPA".equalsIgnoreCase(type)) {
            return new DAOJPAFactory();
        } else if ("Hibernate".equalsIgnoreCase(type)) {
            return new DAOHibernateFactory();
        } else if("JDBC".equalsIgnoreCase(type)){
           return new DAOJDBCFactory();
        }
        else{
         throw new IllegalArgumentException("Tipo de persistencia no válido: "+type);
        }
    }

}
