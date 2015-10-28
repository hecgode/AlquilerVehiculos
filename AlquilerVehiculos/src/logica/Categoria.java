package logica;

import java.util.*;

public class Categoria {
	private String nombre;
    private int precioIli;
    private int preciokm;
    private double preciokmmodkm;
    private double precioSeguroRiesgos;
    private double precioSeguroTerceros;

    private Categoria catsup;
    private ArrayList<Coche> coches = new ArrayList<Coche>();



    public Categoria(String nombre, int precioIli, int preciokm, double preciokmmodkm, double precioSeguroRiesgos,
			double precioSeguroTerceros) {
		super();
		this.nombre = nombre;
		this.precioIli = precioIli;
		this.preciokm = preciokm;
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



	public int getPrecioIli() {
		return precioIli;
	}



	public void setPrecioIli(int precioIli) {
		this.precioIli = precioIli;
	}



	public int getPreciokm() {
		return preciokm;
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





}

