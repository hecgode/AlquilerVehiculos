package presentacion.controlador;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
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
	 public void aceptar (ActionEvent eve)
	 
	 {
		 nuevoCliente = new Cliente(dni.getText(), nombreApellidos.getText(),
					direccion.getText(),
					 poblacion.getText(), codigoPostal.getText(),
					null, digitosTC.getText(),
					 Integer.parseInt(mesTC.getText()),
					Integer.parseInt(anyoTC.getText()),
					 Integer.parseInt(cvc.getText()), tipoTarjeta.getText());
					 if (nuevoCliente != null) {
					 //Invocamos el servicio encargado de Crear un nuevo cliente
						 AlquilerVehiculos al = new AlquilerVehiculos();
						 al.crearCliente(nuevoCliente);
					//AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);

}
	 } 
	 
	 
	 
	 @FXML
	 public void cancelar (ActionEvent eve)
	 
	 {
		 stage.close();

	 } 
	 @Override
	 
	 
	 public void initialize(URL location, ResourceBundle resources)
	 {

		 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("CREAR CLIENTE");


	 }
	}