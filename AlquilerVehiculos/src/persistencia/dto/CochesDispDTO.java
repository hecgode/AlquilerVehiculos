package persistencia.dto;

import logica.Sucursal;

public class CochesDispDTO {

	private String matricula;
	private double km;
	private int mSucursal;
	private String Categoria;
	private String nombre;


	public CochesDispDTO(String matricula, double km, int mSucursal, String categoria, String nombre) {
		super();
		this.matricula = matricula;
		this.km = km;
		this.mSucursal = mSucursal;
		Categoria = categoria;
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public int getmSucursal() {
		return mSucursal;
	}
	public void setmSucursal(int mSucursal) {
		this.mSucursal = mSucursal;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}