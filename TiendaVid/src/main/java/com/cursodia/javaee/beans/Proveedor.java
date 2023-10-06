package com.cursodia.javaee.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
@Entity
@Table(name="proveedores")
public class Proveedor 
{
	@Id
	@PrimaryKeyJoinColumn(name="cve_prov")
    int cve_prov;
	String nom_prov;
	@Fetch(value=FetchMode.SELECT)//COMO SE VAN IR LEYENDO LOS REGISTROS
	//@JoinColumn(name="cve_prov")
	@OneToMany(mappedBy = "prov", cascade = CascadeType.MERGE)
	//esta ocurriendo algo que se llama proxi en listaVideojuegos,se les dan los canales
	//no ocupan  todo el recurso pero estan redireccionadas hacia ellas
	//las anotaciones de arriva permiten crear estas multiples referencias si no estubieran
	//si se arian muchas instancias de List..Videojuegos, Solo esta referenciado en el momento que se necesita.
	//se crea un canal para mandarlo llamar.
	private  List<Videojuego> listaVideojuegos;//se referencia un provedor puede tener muchos juegos por eso la lista
	String imei_prov;
	String tel_prov;
	 public Proveedor() {}
	 
	public Proveedor(int cve_prov, String nom_prov,String imei_prov,String tel_prov) 
	{
		super();
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
		this.imei_prov=imei_prov;
		this.tel_prov=tel_prov;
	}
	
	public String getNom_prov() {
		return nom_prov;
	}
	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}
	public void setCve_prov(int cve_prov) {
		this.cve_prov = cve_prov;
	}

	public int getCve_prov() {
		return cve_prov;
	}
	public String getImei_prov() {
		return imei_prov;
	}
	public void setImei_prov(String imei_prov) {
		this.imei_prov = imei_prov;
	}
	
	
	
	public String getTel_prov() {
		return tel_prov;
	}

	public void setTel_prov(String tel_prov) {
		this.tel_prov = tel_prov;
	}

	public void setCve_prov(Integer cve_prov) {
		this.cve_prov = cve_prov;
	}

	
}
