package logica;


public class Coche {


	private int matricula;
	private int km;

	 private Sucursal mSucursal;

	 public Coche (int matricula, int km) {
		 this.matricula=matricula;
		 this.km=km;
	 }


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }



}

