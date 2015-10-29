package logica;


public class Reserva {
	private int identificador;
    private String fechaR;
    private String fechaD;
    private String modalidad;
    private Cliente mCliente;

    // atributo de enlace
    private Empleado refEmpleado;
    private String num_reserva;
    private String empleado;
    // fin del atributo de enlace

    private Categoria mCategoria;
  private Entrega entrega;

    public Entrega getEntrega() {
	return entrega;
}

public void setEntrega(Entrega entrega) {
	this.entrega = entrega;
}

	private Sucursal mDevolucion;
    private Sucursal mRegogida;




    public Reserva(int identificador, String fechaR, String fechaD, String modalidad, Cliente mCliente,
			Categoria mCategoria, Sucursal mDevolucion, Sucursal mRegogida) {
		super();
		this.identificador = identificador;
		this.fechaR = fechaR;
		this.fechaD = fechaD;
		this.modalidad = modalidad;
		this.mCliente = mCliente;
		this.mCategoria = mCategoria;
		this.mDevolucion = mDevolucion;
		this.mRegogida = mRegogida;
	}

	public String getFechaR() {
        return fechaR;
    }

    public void setFechaR(String fechaR) {
        this.fechaR = fechaR;
    }

    public String getFechaD() {
        return fechaD;
    }

    public void setFechaD(String fechaD) {
        this.fechaD = fechaD;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }



}

