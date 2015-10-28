package logica;

import java.util.*;

public class Entrega {
    private String fecha;
    private String seguro;
    private int km;
    private int combustible;
    private Coche mCoche;
    private Reserva mRerserva;
    private Devolucion mDevolucion;
    private Empleado mEmpleado;
    private ArrayList<Daño> mDaño = new ArrayList<Daño>();

    public Entrega (String fecha, String seguro,int km, int combustible) {
    	this.fecha=fecha;
    	this.seguro=seguro;
    	this.km=km;
    	this.combustible=combustible;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
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

