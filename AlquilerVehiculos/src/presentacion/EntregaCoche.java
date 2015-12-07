package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.event.ActionEvent;
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

	public void close(ActionEvent event) {
		try {
			Stage stage = (Stage) close_btn.getScene().getWindow();
			stage.close();
			System.out.println("Back in the 90's. I was in a very famous TV show... ");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
