package pruebas;

public class pruebas {

	public static void main(String[] args) 
	{
		String query ="SELECT * FROM videojuegos";
		String entidad = query.replace("SELECT * FROM ","");
		entidad = entidad.substring(0,entidad.length()-1);
		System.out.println(entidad);

	}

}
