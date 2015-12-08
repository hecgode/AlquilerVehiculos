package logica;

public class Coche {


	private String matricula;
	private String categoria;
	private int km;

	private Sucursal mSucursal;

	public Coche (String matricula, int km,String categoria) {
		this.matricula=matricula;
		this.km=km;
		this.categoria = categoria;
	}
	
	 public String getCategoria() {
	        return categoria;
	    }

	    public void setCategoria(String matricula) {
	        this.categoria = categoria;
	    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}

