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
import javafx.scene.image.Image;
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
	 public void aceptar (ActionEvent eve) throws DAOExcepcion {
		 try {
			 if(direccion.getText().length()<=0)
				 throw new Exception();
			 nuevaSucursal = new Sucursal(Integer.parseInt(id.getText()),direccion.getText());

						 if (nuevaSucursal != null) {
						 //Invocamos el servicio encargado de Crear un nuevo cliente

							 AlquilerVehiculos.dameAlquiler().crearSucursal(nuevaSucursal);
								AlquilerVehiculos.createAlert("Informacion", AlertType.INFORMATION, "Sucursal creada con exito");
								stage.close();

						//AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);
						 }
		 }
		 catch(Exception e) {
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Faltan datos");
		 }
	 }

	 @FXML
	 public void cancelar (ActionEvent eve) {
		 stage.close();

	 }
	 @Override


	 public void initialize(URL location, ResourceBundle resources) {

		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR SUCURSAL");
			stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));



	 }
	}

