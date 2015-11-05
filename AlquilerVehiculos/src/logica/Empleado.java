package logica;
/*AlquilerVehiculos*/
public class Empleado {
	private String nombre;
	private String administrador;

	   public Empleado (String nombre,String administrador) {
		   this.nombre=nombre;
		   this.administrador=administrador;
	    }


	 public String getNombre () {
        return nombre;
    }


    public void setNombre (String val) {
        this.nombre = val;
    }



    public String getAdministrador () {
    	return administrador;
    }
    public void setAdministradir (String administrador) {
    	this.administrador=administrador;
    }

    public Empleado () {
    }

}

