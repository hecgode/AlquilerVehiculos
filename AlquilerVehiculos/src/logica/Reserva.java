package logica;

import java.time.LocalDateTime;

/*AlquilerVehiculos*/
public class Reserva {
	private int identificador;
    private LocalDateTime fechaR;
    private LocalDateTime fechaD;
    private int modalidad;
    private String dni;
    private String nombre;
    private int idSucR;
    private int idSucD;
    private Cliente mCliente;
    private Categoria mCategoria;
    private Entrega entrega;
 	private Sucursal mDevolucion;
    private Sucursal mRegogida;


	public Reserva(int identificador, LocalDateTime fechaR, LocalDateTime fechaD, int modalidad, String dni,
			String nombre, int idSucR, int idSucD, Cliente mCliente, Categoria mCategoria, Entrega entrega,
			Sucursal mDevolucion, Sucursal mRegogida) {
		super();
		this.identificador = identificador;
		this.fechaR = fechaR;
		this.fechaD = fechaD;
		this.modalidad = modalidad;
		this.dni = dni;
		this.nombre = nombre;
		this.idSucR = idSucR;
		this.idSucD = idSucD;
		this.mCliente = mCliente;
		this.mCategoria = mCategoria;
		this.entrega = entrega;
		this.mDevolucion = mDevolucion;
		this.mRegogida = mRegogida;
	}
	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public LocalDateTime getFechaR() {
		return fechaR;
	}


	public void setFechaR(LocalDateTime fechaR) {
		this.fechaR = fechaR;
	}


	public LocalDateTime getFechaD() {
		return fechaD;
	}


	public void setFechaD(LocalDateTime fechaD) {
		this.fechaD = fechaD;
	}


	public int getModalidad() {
		return modalidad;
	}


	public void setModalidad(int modalidad) {
		this.modalidad = modalidad;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getIdSucR() {
		return idSucR;
	}


	public void setIdSucR(int idSucR) {
		this.idSucR = idSucR;
	}


	public int getIdSucD() {
		return idSucD;
	}


	public void setIdSucD(int idSucD) {
		this.idSucD = idSucD;
	}


	public Cliente getmCliente() {
		return mCliente;
	}


	public void setmCliente(Cliente mCliente) {
		this.mCliente = mCliente;
	}


	public Categoria getmCategoria() {
		return mCategoria;
	}


	public void setmCategoria(Categoria mCategoria) {
		this.mCategoria = mCategoria;
	}


	public Entrega getEntrega() {
		return entrega;
	}


	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}


	public Sucursal getmDevolucion() {
		return mDevolucion;
	}


	public void setmDevolucion(Sucursal mDevolucion) {
		this.mDevolucion = mDevolucion;
	}


	public Sucursal getmRegogida() {
		return mRegogida;
	}


	public void setmRegogida(Sucursal mRegogida) {
		this.mRegogida = mRegogida;
	}







}

