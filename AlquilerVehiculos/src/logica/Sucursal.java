
/*AlquilerVehiculos ultima modificacion 06/10/15*/
package logica;
import java.util.*;

public class Sucursal {

    private String direccion;

    public int getIdentificador() {
		return identificador;
	}



	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	private int identificador;

    private ArrayList<Empleado> mEmpleado = new ArrayList<Empleado>();

    private ArrayList<Coche> mCoche = new ArrayList<Coche>() ;

    private ArrayList<Reserva> mRecogida = new ArrayList<Reserva>();

    private ArrayList<Reserva> mDevolucion = new ArrayList<Reserva>();
    private ArrayList<Reserva> mReserva = new ArrayList<Reserva>();

    public Sucursal(int identificador ,String direccion) {
    	this.direccion=direccion;
    	this.identificador=identificador;
    }






	public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Reserva> listarReserva() {
        return mReserva;
    }

}
