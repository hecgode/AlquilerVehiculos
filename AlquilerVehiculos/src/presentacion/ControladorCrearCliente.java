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



			 if(dni.getText().length()<=0 || nombreApellidos.getText().length()<=0 || poblacion.getText().length()<=0 || direccion.getText().length()<=0 || codigoPostal.getText().length()<=0 || digitosTC.getText().length()<=0
					 || cvc.getText().length()<=0 || tipoTarjeta.getText().length()<=0) {
				 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "comprueba que ningun campo este vacio");
			 }
			 else {
		 			AlquilerVehiculos.dameAlquiler().crearCliente(nuevoCliente);
					AlquilerVehiculos.createAlert("Informacion", AlertType.INFORMATION, "cliente creado con exito");
					stage.close();
			 }
		 }
		 catch(Exception e) {
			 String pantallazo = "error producido en: ";
			try{Integer.parseInt(mesTC.getText());}
			catch(Exception err1)
			{
				//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del mes incorrecto");
				pantallazo += " mes";
			}
			try{Integer.parseInt(anyoTC.getText());}
			catch(Exception err1)
			{
				//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del a�o incorrecto");
				if(!pantallazo.equals("error producido en: "))
				{
					pantallazo += ", año";
				}
				else
				{
					pantallazo += "año ";
				}
			}
			try{Integer.parseInt(cvc.getText());}
			catch(Exception err1)
			{
				//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo de cvc incorrecto");
				if(!pantallazo.equals("error producido en: "))
				{
					pantallazo += ", cvc";
				}
				else
				{
					pantallazo += "cvc ";
				}
			}
			try{LocalTime local = null;LocalDateTime.of(fechaCarnet.getValue(),local.MIDNIGHT);}
			catch(Exception err1)
			{
				//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo de cvc incorrecto");
				if(!pantallazo.equals("error producido en: "))
				{
					pantallazo += ", fecha";
				}
				else
				{
					pantallazo += "fecha ";
				}
			}
			pantallazo += ".";
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, pantallazo);
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