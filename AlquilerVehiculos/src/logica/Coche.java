package logica;


public class Coche {


	private String matricula;
	private int km;

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

	private Sucursal mSucursal;

	 public Coche (String matricula, int km) {
		 this.matricula=matricula;
		 this.km=km;
	 }





}

