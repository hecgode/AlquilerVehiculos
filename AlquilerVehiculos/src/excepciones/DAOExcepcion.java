package excepciones;
/*AlquilerVehiculos*/
@SuppressWarnings("serial")
public class DAOExcepcion extends Exception {

	public DAOExcepcion(String message) {
		super(message);
	}

	public DAOExcepcion(Exception e) {
		super(e.getMessage());
	}

}
