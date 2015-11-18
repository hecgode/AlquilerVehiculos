package presentacion;


import java.net.URL;
import java.sql.Time;
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
import logica.Reserva;

public class ControladorCrearReserva extends ControladorCasoDeUso {
	// private static final Logger LOG =	Logger.getLogger(ControladorCrearCliente.class.getName());
	 @FXML
	 private TextField id;
	 @FXML
	 private DatePicker recogida;
	 @FXML
	 private DatePicker devol;
	 @FXML
	 private TextField moda;
	 @FXML
	 private TextField dnic;
	 @FXML
	 private TextField nombre;
	 @FXML
	 private TextField ud1;
	 @FXML
	 private TextField ud2;;
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
			LocalTime local = null ;
			Reserva nuevaReserva = new Reserva(Integer.parseInt(id.getText()),LocalDateTime.of(recogida.getValue(),local.MIDNIGHT),LocalDateTime.of(devol.getValue(),local.NOON),Integer.parseInt(moda.getText()),dnic.getText(),
					 nombre.getText(),Integer.parseInt(ud1.getText()),Integer.parseInt(ud2.getText()));
			
			 //if (nuevaReserva != null) {

												 AlquilerVehiculos.dameAlquiler().crearReserva(nuevaReserva);
												// }
						 //Invocamos el servicio encargado de Crear un nuevo cliente

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
		 stage.setTitle("CREAR RESERVA");


	 
	 }
	}
