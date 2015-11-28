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
			Reserva nuevaReserva = new Reserva(Integer.parseInt(id.getText()),LocalDateTime.of(recogida.getValue(),local.MIDNIGHT),LocalDateTime.of(devol.getValue(),local.NOON),moda.getText(),dnic.getText(),
					 nombre.getText(),Integer.parseInt(ud1.getText()),Integer.parseInt(ud2.getText()));


			 if(id.getText().length()<=0 || moda.getText().length()<=0 || dnic.getText().length()<=0 || nombre.getText().length()<=0)
			 {
				 AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "comprueba que ningun campo este vacio");
			 }
			 else
			 { 
								
			
			if (nuevaReserva != null) {
				 
				 
				 
				 
				 								if (AlquilerVehiculos.dameAlquiler().buscaClientes(dnic.getText())==false) {
				 										 									
				 													 									Alert alert = new Alert(AlertType.ERROR);
				 									alert.setTitle("ERROR");
				 									alert.setHeaderText(null);
				 									alert.setContentText("Â¡CLiente no existe!");
				 									alert.showAndWait();
				 									stage.close();
				 								}
				 								

												 AlquilerVehiculos.dameAlquiler().crearReserva(nuevaReserva);
												 AlquilerVehiculosApp.createAlert("InformaciÃ³n", AlertType.INFORMATION, "Reserva creada con Ã©xito");
												 stage.close();
			}
						 //Invocamos el servicio encargado de Crear un nuevo cliente

		 }
		 }


		 catch(Exception e) {
			 LocalTime local = null ;
			 //AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "Â¡Faltan datos!");
			 String pantallazo = "error producido en: ";
				try{Integer.parseInt(id.getText());}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del mes incorrecto");
					pantallazo += " id";
				}
				try{LocalDateTime.of(recogida.getValue(),local.MIDNIGHT);}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del año incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", fecha recogida";
					}
					else
					{
						pantallazo += "fecha recogida ";
					}
				}
				try{LocalDateTime.of(devol.getValue(),local.NOON);}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del año incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", fecha devolucion";
					}
					else
					{
						pantallazo += "fecha devolucion ";
					}
				}
				try{Integer.parseInt(ud1.getText());}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del año incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", ud1";
					}
					else
					{
						pantallazo += "ud1 ";
					}
				}
				try{Integer.parseInt(ud2.getText());}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del año incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", ud2";
					}
					else
					{
						pantallazo += "ud2 ";
					}
				}
				pantallazo += ".";
				AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, pantallazo);

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
