package logica;


public class Da�o {


private String zona;
private String descripcion;
    public Da�o (String zona,String descripcion) {
    	this.zona=zona;
    	this.descripcion=descripcion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

