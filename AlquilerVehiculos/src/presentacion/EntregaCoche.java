package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;

public class EntregaCoche extends ControladorCasoDeUso {

	@FXML
	private Button close_btn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stubs
	}

	public void close() {
		try {
			stage.close();
			System.out.println("BACK IN THE 90 I WAS ON A VERY FAMOUS TV SHOW... NANA ");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
