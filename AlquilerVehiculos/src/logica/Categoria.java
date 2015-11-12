package logica;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.util.*;

public class Categoria {

	private String nombre;
	private double precioIli;
    private double preciokm;
    private double preciokmmodkm;
	private double precioSeguroRiesgos;
    private double precioSeguroTerceros;
    private String catsup;


	public Categoria catsup2;
    private ArrayList<Coche> coches = new ArrayList<Coche>();



	public Categoria(String nombre, double precioModIlimitada, double precioModKms, double precioKMModKms,
			double precioSeguroTRiesgo, double precioSeguroTerceros2, String nombreCategoriaSuperior) {
		// TODO Auto-generated constructor stub

		super();
		this.nombre = nombre;
		this.precioIli = precioIli;
		this.preciokm = preciokm;
		this.preciokmmodkm = preciokmmodkm;
		this.precioSeguroRiesgos = precioSeguroRiesgos;
		this.precioSeguroTerceros = precioSeguroTerceros;
		this.catsup = catsup;

	}






	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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

	public ArrayList<Coche> getCoches() {
		return coches;
	}
	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}

	    public Categoria getCatsup2() {
			return catsup2;
		}
		public void setCatsup2(Categoria catsup2) {
			this.catsup2 = catsup2;
	}




}

