package presentacion;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Entrega;

public class EntregaCoche extends ControladorCasoDeUso {

	@FXML
	private Button close_btn;

	
	@FXML
	private TextField seguro;
	@FXML
	private TextField km;
	@FXML
	private TextField combustible;
	@FXML
	private TextField empleadoRealiza;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stubs
	}

	public void realizarEntrega() throws DAOExcepcion
	{
		try
		{
			Entrega en = new Entrega(AlquilerVehiculos.dameAlquiler().getCocheId(),
					AlquilerVehiculos.dameAlquiler().getCocheFechaE(),seguro.getText().toString(),
					Double.valueOf(km.getText().toString()),Double.valueOf(combustible.getText().toString()),
					AlquilerVehiculos.dameAlquiler().getCocheMatricula(),
					empleadoRealiza.getText().toString());
				
				AlquilerVehiculos.dameAlquiler().crearEntrega(en);
				AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Entrega Realizada con éxito");
				
		}catch(Exception err)
		{
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Se ha producido un error");
		}
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
