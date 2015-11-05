package excepciones;
/*AlquilerVehiculos*/
@SuppressWarnings("serial")
public class LogicaExcepcion extends Exception {

	public LogicaExcepcion(String message) {
		super(message);
	}

	public LogicaExcepcion(Exception e) {
		super(e.getMessage());
	}

}
