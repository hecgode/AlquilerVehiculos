package presentacion;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.sun.javafx.logging.Logger;

import excepciones.DAOExcepcion;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Cliente;

public class ControladorCrearCliente extends ControladorCasoDeUso {
	// private static final Logger LOG =	Logger.getLogger(ControladorCrearCliente.class.getName());
	 @FXML
	 private TextField dni;
	 @FXML
	 private TextField nombreApellidos;
	 @FXML
	 private TextField direccion;
	 @FXML
	 private TextField anyoTC;
	 @FXML
	 private TextField mesTC;
	 @FXML
	 private TextField codigoPostal;
	 @FXML
	 private TextField poblacion;
	 @FXML
	 private DatePicker fechaCarnet;
	 @FXML
	 private TextField cvc;
	 @FXML
	 private TextField tipoTarjeta;
	 @FXML
	 private TextField digitosTC;
	 @FXML
	 private Button aceptar;
	 @FXML
	 private Button cancelar;
	 private Cliente nuevoCliente;

	 @FXML
	 private Label label;
	 @FXML
	 public void aceptar (ActionEvent eve) throws DAOExcepcion
	 {
		
		 try {
			 LocalTime local = null;

			 nuevoCliente = new Cliente(
					 dni.getText(),
					 nombreApellidos.getText(),
					 
						direccion.getText(),
						 poblacion.getText(),
						 codigoPostal.getText(),
						 LocalDateTime.of(fechaCarnet.getValue(),local.MIDNIGHT),
					 digitosTC.getText(), Integer.parseInt(mesTC.getText()),
						Integer.parseInt(anyoTC.getText()),
						 Integer.parseInt(cvc.getText()), tipoTarjeta.getText());

						 if (nuevoCliente != null) {
						 //Invocamos el servicio encargado de Crear un nuevo cliente
							 AlquilerVehiculos.dameAlquiler().crearCliente(nuevoCliente);

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