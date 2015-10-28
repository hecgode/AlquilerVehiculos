package logica;

import java.util.*;

public class Devolucion {



    private String fecha;

private int totalacobrar;
private int cobrado;
private int km;
private int combustible;

        public Devolucion(String fecha, int totalacobrar, int cobrado, int km, int combustible, Empleado mEmpleado,
		Entrega mEntrega, ArrayList<Daño> mDaño) {
	super();
	this.fecha = fecha;
	this.totalacobrar = totalacobrar;
	this.cobrado = cobrado;
	this.km = km;
	this.combustible = combustible;
	this.mEmpleado = mEmpleado;
	this.mEntrega = mEntrega;
	this.mDaño=mDaño;
}

		private Empleado mEmpleado;

    private Entrega mEntrega;


    private ArrayList<Daño> mDaño = new ArrayList<Daño>();



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalacobrar() {
        return totalacobrar;
    }

    public void setTotalacobrar(int totalacobrar) {
        this.totalacobrar = totalacobrar;
    }

    public int getCobrado() {
        return cobrado;
    }

    public void setCobrado(int cobrado) {
        this.cobrado = cobrado;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }


}

