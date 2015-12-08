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
	private TextField id;
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
			int ejemplo1 =Integer.valueOf(id.getText().toString());
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 1");
			LocalDateTime ejemplo2 = AlquilerVehiculos.dameAlquiler().getCocheFechaE();
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 2");
			String ejemplo3 = seguro.getText().toString();
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 3");
			double ejemplo4 = Double.valueOf(km.getText().toString());
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 4");
			double ejemplo5 = Double.valueOf(combustible.getText().toString());
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 5");
			String ejemplo6 = AlquilerVehiculos.dameAlquiler().getCocheMatricula();
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 6");
			String ejemplo7 = empleadoRealiza.getText().toString();
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "prueba 7");
			Entrega en = new Entrega(Integer.valueOf(id.getText().toString()),
					AlquilerVehiculos.dameAlquiler().getCocheFechaE(),seguro.getText().toString(),
					Double.valueOf(km.getText().toString()),Double.valueOf(combustible.getText().toString()),
					AlquilerVehiculos.dameAlquiler().getCocheMatricula(),
					empleadoRealiza.getText().toString());
				
				//AlquilerVehiculos.dameAlquiler().crearEntrega(en);
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
