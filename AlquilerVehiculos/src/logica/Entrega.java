 package logica;

import java.time.LocalDateTime;
import java.util.*;

public class Entrega {
	private int id;
    private LocalDateTime fecha;
    private String seguro;
    private double km;
    private double combustible;
    private String cocheAsignado;
    private String empleadoRealiza;

    private Coche mCoche;
    private Reserva mRerserva;
    private Devolucion mDevolucion;
    private Empleado mEmpleado;
    private ArrayList<Danyo> mDanyo = new ArrayList<Danyo>();

    public Entrega (int id,LocalDateTime fecha, String seguro,double km, 
    		double combustible,String cocheAsignado,String empleadoRealiza) {
     this.id = id;
     this.fecha=fecha;
     this.seguro=seguro;
     this.km=km;
     this.combustible=combustible;
     this.cocheAsignado = cocheAsignado;
     this.empleadoRealiza = empleadoRealiza;
    }

    public int getId() {
    	return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

	public String getCocheAsignado() {
	  return cocheAsignado;
	 }

	 public void setCocheAsignado(String cocheAsignado) {
	  this.cocheAsignado = cocheAsignado;
	 }

	 public String getEmpleadoRealiza() {
	  return empleadoRealiza;
	 }

	 public void setEmpleadoRealiza(String empleadoRealiza) {
	  this.empleadoRealiza = empleadoRealiza;
	 }

}