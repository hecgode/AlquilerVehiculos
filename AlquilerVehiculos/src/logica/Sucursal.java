package logica;

import java.util.*;

import excepciones.DAOExcepcion;
import persistencia.DAL;
import persistencia.dto.CocheDTO;
import persistencia.dto.ReservaDTO;

public class Sucursal {

    private String direccion;
	private int identificador;
	private DAL dal;
	private static Sucursal Sucursal;


    private ArrayList<Empleado> mEmpleado = new ArrayList<Empleado>();
    private ArrayList<Coche> mCoche = new ArrayList<Coche>() ;
    private ArrayList<Reserva> mRecogida = new ArrayList<Reserva>();
    private ArrayList<Reserva> mDevolucion = new ArrayList<Reserva>();
    private ArrayList<Reserva> mReserva = new ArrayList<Reserva>();

    public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

    public Sucursal(int identificador ,String direccion) throws DAOExcepcion {
    	this.identificador=identificador;
    	this.direccion=direccion;
    	this.dal = DAL.dameDAL();

    }






    public void cargarCochesPorSucursal(int suc) throws DAOExcepcion {
		  List<CocheDTO> listaresdto = dal.dameDAL().listarCoches(suc);
		  for (CocheDTO coche : listaresdto) {
			  anyadirCoche(new Coche(coche.getMatricula(),coche.getKm(),coche.getmSucursal(),coche.getCategoria(),coche.getNombre()));
		  }
	  }

	private void anyadirCoche(Coche coche) {
		mCoche.add(coche);

	}

	public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



}
