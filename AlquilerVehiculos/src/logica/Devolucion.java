package logica;

import java.util.*;

public class Devolucion {

	private String fecha;
	private int totalacobrar;
	private int cobrado;
	private int km;
	private int combustible;
	private Empleado mEmpleado;
	private Entrega mEntrega;
	private Reserva mReserva;
	private Coche coche;

	private ArrayList<Danyo> mDanyo = new ArrayList<Danyo>();


    public Devolucion(String fecha, int totalacobrar, int cobrado, int km, int combustible, Empleado mEmpleado,
		Entrega mEntrega, Reserva mReserva, Coche coche, ArrayList<Danyo> mDanyo) {

    	super();
    	this.fecha = fecha;
    	this.totalacobrar = totalacobrar;
    	this.cobrado = cobrado;
    	this.km = km;
    	this.combustible = combustible;
    	this.mEmpleado = mEmpleado;
    	this.mEntrega = mEntrega;
    	this.mReserva = mReserva;
    	this.coche = coche;
    	this.mDanyo = mDanyo;
    }

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

    public Empleado getmEmpleado() {
    	return mEmpleado;
    }

    public void setmEmpleado(Empleado mEmpleado) {
    	this.mEmpleado = mEmpleado;
    }

    public Entrega getmEntrega() {
    	return mEntrega;
    }

    public void setmEntrega(Entrega mEntrega) {
    	this.mEntrega = mEntrega;
    }

    public Reserva getmReserva() {
    	return mReserva;
    }

    public void setmReserva(Reserva mReserva) {
    	this.mReserva = mReserva;
    }

    public Coche getCoche() {
    	return coche;
    }

    public void setCoche(Coche coche) {
    	this.coche = coche;
    }

    public ArrayList<Danyo> getmDanyo() {
    	return mDanyo;
    }

    public void setmDanyo(ArrayList<Danyo> mDanyo) {
    	this.mDanyo = mDanyo;
    }

}

