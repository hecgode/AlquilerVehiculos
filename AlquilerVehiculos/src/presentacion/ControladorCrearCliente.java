package presentacion;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.Cliente;

public class ControladorCrearCliente extends ControladorCasoDeUso {
	 private static final Logger LOG =	Logger.getLogger(ControladorCrearCliente.class.getName());
	 @FXML
	 private TextField dni;
	 @FXML
	 private TextField nombreApellidos;
	 @FXML
	 private TextField direccion;
	 @FXML
	 private TextField añoTC;
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
	 @Override
	 public void initialize(URL location, ResourceBundle resources)
	 {
	 
		 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("CREAR CLIENTE");
	 cancelar.setOnAction(ActionEvent -> 
		 stage.close() );
	
	 aceptar.setOnAction(event -> {
	 nuevoCliente = new Cliente(dni.getText(), nombreApellidos.getText(),
	direccion.getText(),
	 poblacion.getText(), codigoPostal.getText(),
	fechaCarnet.getValue(), digitosTC.getText(),
	 Integer.parseInt(mesTC.getText()),
	Integer.parseInt(añoTC.getText()),
	 Integer.parseInt(cvc.getText()), tipoTarjeta.getText());
	 if (nuevoCliente != null) {
	 //Invocamos el servicio encargado de Crear un nuevo cliente

	AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);
	 LOG.log(Level.INFO, "Se ha creado un nuevo Cliente: " +
	nuevoCliente);
	 } else {
	 LOG.log(Level.INFO, "No se ha podido crear un nuevo cliente.");
	 }
	 dialog.close();
	 });
	 }
	}