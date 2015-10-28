package logica;


public class Cliente {
	private int idendificador;

    private String nombreyApellidos;
    private String direccion;

    private String poblacion;
    private int codPostal;
    private String fechaCarnet;
    private int digitos;
   private int mes;
    private int año;
    private int cvc;
    private String tipo;





	public int getIdendificador() {
		return idendificador;
	}


	public void setIdendificador(int idendificador) {
		this.idendificador = idendificador;
	}


	public Cliente(int idendificador, String nombreyApellidos, String direccion, String poblacion, int codPostal,
			String fechaCarnet, int digitos, int mes, int año, int cvc, String tipo) {
		super();
		this.idendificador = idendificador;
		this.nombreyApellidos = nombreyApellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
		this.fechaCarnet = fechaCarnet;
		this.digitos = digitos;
		this.mes = mes;
		this.año=año;
		this.cvc = cvc;
		this.tipo = tipo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombreyApellidos() {
		return nombreyApellidos;
	}


	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}


	public int getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getFechaCarnet() {
		return fechaCarnet;
	}


	public void setFechaCarnet(String fechaCarnet) {
		this.fechaCarnet = fechaCarnet;
	}


	public int getDigitos() {
		return digitos;
	}


	public void setDigitos(int digitos) {
		this.digitos = digitos;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}




	public int getAño() {
		return año;
	}


	public void setAño(int año) {
		this.año = año;
	}


	public int getCvc() {
		return cvc;
	}


	public void setCvc(int cvc) {
		this.cvc = cvc;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





}




