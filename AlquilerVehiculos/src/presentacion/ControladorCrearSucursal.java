package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Sucursal;

public class ControladorCrearSucursal extends ControladorCasoDeUso {
	// private static final Logger LOG =	Logger.getLogger(ControladorCrearCliente.class.getName());
	 @FXML
	 private TextField id;
	 @FXML
	 private TextField direccion;

	 private Button cancelar, aceptar;
	 private Sucursal nuevaSucursal;

	 @FXML
	 private Label label;

	 @FXML
	 public void aceptar (ActionEvent eve) throws DAOExcepcion
	 {
		 try {
			 nuevaSucursal = new Sucursal(Integer.parseInt(id.getText()),direccion.getText());

						 if (nuevaSucursal != null) {
						 //Invocamos el servicio encargado de Crear un nuevo cliente
							 AlquilerVehiculos al = new AlquilerVehiculos();
							 al.anyadirSucursal(nuevaSucursal);
						//AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);
						 }
		 }
		 catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("¡No se han introducido datos!");
			alert.showAndWait();
		 }
	 }

	 @FXML
	 public void cancelar (ActionEvent eve) {
		 stage.close();

	 }
	 @Override


	 public void initialize(URL location, ResourceBundle resources) {

		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR CLIENTE");


	 }
	}

