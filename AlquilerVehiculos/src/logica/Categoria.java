package logica;

import java.util.*;

public class Categoria {
	private String nombre;
    private double precioIli;
    private double preciokm;
    private double preciokmmodkm;
    public double getPrecioIli() {
		return precioIli;
	}



	public void setPrecioIli(double precioIli) {
		this.precioIli = precioIli;
	}



	public double getPreciokm() {
		return preciokm;
	}



	public void setPreciokm(double preciokm) {
		this.preciokm = preciokm;
	}



	private double precioSeguroRiesgos;
    private double precioSeguroTerceros;

    private Categoria catsup;
    private ArrayList<Coche> coches = new ArrayList<Coche>();



    public Categoria(String nombre, double d, double e, double preciokmmodkm, double precioSeguroRiesgos,
			double precioSeguroTerceros) {
		super();
		this.nombre = nombre;
		this.precioIli = d;
		this.preciokm = e;
		this.preciokmmodkm = preciokmmodkm;
		this.precioSeguroRiesgos = precioSeguroRiesgos;
		this.precioSeguroTerceros = precioSeguroTerceros;

	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public void setPrecioIli(int precioIli) {
		this.precioIli = precioIli;
	}





	public void setPreciokm(int preciokm) {
		this.preciokm = preciokm;
	}



	public double getPreciokmmodkm() {
		return preciokmmodkm;
	}



	public void setPreciokmmodkm(double preciokmmodkm) {
		this.preciokmmodkm = preciokmmodkm;
	}



	public double getPrecioSeguroRiesgos() {
		return precioSeguroRiesgos;
	}



	public void setPrecioSeguroRiesgos(double precioSeguroRiesgos) {
		this.precioSeguroRiesgos = precioSeguroRiesgos;
	}



	public double getPrecioSeguroTerceros() {
		return precioSeguroTerceros;
	}



	public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
		this.precioSeguroTerceros = precioSeguroTerceros;
	}







	public Categoria getCatsup() {
		return catsup;
	}



	public void setCatsup(Categoria catsup) {
		this.catsup = catsup;
	}



	public ArrayList<Coche> getCoches() {
		return coches;
	}



	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}



	public void setSuperior(Categoria buscarCategoria) {
		// TODO Auto-generated method stub

	}





}

