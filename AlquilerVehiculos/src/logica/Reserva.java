/*AlquilerVehiculos ultima modificacion 06/10/15*/

package logica;

public class Reserva {
	private int identificador;
    private String fechaR;
    private String fechaD;
    private String modalidad;


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
    public int getIdentificador() {
  		return identificador;
  	}

  	public void setIdentificador(int identificador) {
  		this.identificador = identificador;
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

  	private Cliente mCliente;

      private Categoria mCategoria;
    private Entrega entrega;

      public Entrega getEntrega() {
  	return entrega;
  }

  public void setEntrega(Entrega entrega) {
  	this.entrega = entrega;
  }



}

