package logica;
/*AlquilerVehiculos*/

import java.time.LocalDateTime;

public class Cliente {

	public Cliente(String idendificador, String nombreyApellidos, String direccion, String poblacion, String codPostal,
			LocalDateTime fechaCarnet, String digitos, int mes, int anyo, int cvc, String tipo) {
		super();
		this.idendificador = idendificador;
		this.nombreyApellidos = nombreyApellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
		this.fechaCarnet = fechaCarnet;
		this.digitos = digitos;
		this.mes = mes;
		this.anyo = anyo;
		this.cvc = cvc;
		this.tipo = tipo;
	}

	private String idendificador;

    private String nombreyApellidos;
    private String direccion;

    private String poblacion;
    private String codPostal;
    private LocalDateTime fechaCarnet;
    private String digitos;
   private int mes;
    private int anyo;

	private int cvc;

    private String tipo;






	public String getIdendificador() {
		return idendificador;
	}

	public void setIdendificador(String idendificador) {
		this.idendificador = idendificador;
	}

	public String getNombreyApellidos() {
		return nombreyApellidos;
	}

	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public LocalDateTime getFechaCarnet() {
		return fechaCarnet;
	}

	public void setFechaCarnet(LocalDateTime fechaCarnet) {
		this.fechaCarnet = fechaCarnet;
	}

	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		this.digitos = digitos;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
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




