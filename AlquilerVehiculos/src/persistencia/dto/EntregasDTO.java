package persistencia.dto;

import java.time.LocalDateTime;

public class EntregasDTO {

	private int id;
	private LocalDateTime fecha;
	private String tipoSeguro;
	private Double kms;
	private Double combustible;
	private String cocheAsignado;
	private String empleadoRealiza;

	public EntregasDTO(int id,LocalDateTime fecha,String tipoSeguro,Double kms,Double combustible,String cocheAsignado,String empleadoRealiza) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoSeguro = tipoSeguro;
		this.kms = kms;
		this.combustible = combustible;
		this.cocheAsignado = cocheAsignado;
		this.empleadoRealiza = empleadoRealiza;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public Double getKms() {
		return kms;
	}

	public void setKms(Double kms) {
		this.kms = kms;
	}

	public Double getCombustible() {
		return combustible;
	}

	public void setCombustible(Double combustible) {
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
