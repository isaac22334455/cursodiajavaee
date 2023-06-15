package com.cursodia.javaee.DBH;

public class DataBaseException extends Exception
{
	private static final long serialVersionUID = 1L;
	private Exception cause;

	public DataBaseException() {
	    super(); // invocar el constructor de la clase padre
	}

	public DataBaseException(String message, Throwable cause) {
	    super(message, cause);
	    this.cause = (Exception) cause;
	}

	public DataBaseException(String message) {
	    super(message);
	}

	public DataBaseException(Throwable cause) {
	    super(cause);
	    this.cause = (Exception) cause;
	}

	public Exception getException() {
	    return this.cause;
	}

}
