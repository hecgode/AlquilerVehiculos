package presentacion;

//import java.awt.event.ActionEvent;
import javafx.event.*;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorPrincipal {
	 private static final String CREAR_CLIENTE = "crear-cliente.fxml";
	// private static final String LISTAR_RESERVAS_SUCURSAL = "listarreservas-sucursal.fxml";
	 private static final String LISTAR_SUCURSALES = "listarsucursales.fxml";
	 private static final String LISTAR_CLIENTES = "listarclientes.fxml";


	 private Stage primaryStage;

	 @FXML
	 void listarSucursales(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_SUCURSALES, ControladorListarSucursales.class).show();
	 }

	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show();
	 }

	 @FXML
	 void listarClientes(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_CLIENTES, ControladorListarClientes.class).show();
	 }

	 /*
	 @FXML
	 void crearReserva(ActionEvent event) {
	 // TODO implementar el manejador del C.U. Crear Reserva
	 }
	 @FXML
	 void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion {
	 //TODO implementar el manejador del C.U. Listar reservas de una sucursal
	 }*/

	 @FXML
	 void salir(ActionEvent event) {
		 Platform.exit();
	 }

	 @FXML
	 void about(ActionEvent event) {
		 	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ABOUT");
			alert.setHeaderText(null);
			alert.setContentText("Autores de la aplicación:\n"
					+ "Héctor Gómez\n"
					+ "Luis Adelantado\n"
					+ "Zaquiel Rodríguez\n"
					+ "Pablo\n");
			alert.showAndWait();
	 }

	 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	 }

	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,
		Class<T> controlClass) {
		 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,
		primaryStage, ControladorPrincipal.this);
	 }






	}