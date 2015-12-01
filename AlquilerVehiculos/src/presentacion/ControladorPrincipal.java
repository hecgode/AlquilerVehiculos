package presentacion;

//import java.awt.event.ActionEvent;
import javafx.event.*;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ControladorPrincipal {
	 private static final String CREAR_CLIENTE = "crear-cliente.fxml";
	 private static final String Crear_Reserva = "Crear-reserva.fxml";
	 private static final String LISTAR_SUCURSALES = "listarsucursales.fxml";
	 private static final String LISTAR_CATEGORIAS = "listarcategorias.fxml";
	 private static final String Crear_Sucursal = "CrearSucursal.fxml";
	 private static final String LISTAR_CLIENTES = "listarclientes.fxml";
	 private static final String LISTAR_RESERVA_SUCURSAL = "listarreservasucursal.fxml";

	 private Stage primaryStage;

	 @FXML
	 private ImageView i1;

	 @FXML
	 void listarSucursales(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_SUCURSALES, ControladorListarSucursales.class).show();
	 }

	 @FXML
	 void listarcategorias(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_CATEGORIAS, ControladorListarCategorias.class).show();
	 }

	 @FXML
	 void listarClientes(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_CLIENTES, ControladorListarClientes.class).show();
	 }

	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show();
	 }

	 @FXML
	 void crearReserva(ActionEvent event) {
	  initCasoDeUso(Crear_Reserva, ControladorCrearReserva.class).show();
	 }
	 @FXML
	 void listarReservaSucursal(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_RESERVA_SUCURSAL, ControladorListarReservaSucursales.class).show();
	 }

	 @FXML
	 void CrearSuc(ActionEvent event) throws LogicaExcepcion {
		  initCasoDeUso(Crear_Sucursal, ControladorCrearSucursal.class).show();

	 }

	 @FXML
	 void salir(ActionEvent event) {
		 Platform.exit();
	 }

	 @FXML
	 void about(ActionEvent event) {
		 	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ABOUT");
			alert.setHeaderText(null);
			alert.setContentText("Autores de la aplicacion:\n"
					+ "Hector Gomez\n"
					+ "Luis Adelantado\n"
					+ "Zaquiel Rodriguez\n"
					+ "Pablo Domingo Gallardo\n");
			alert.showAndWait();
	 }

	 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
		 i1.setImage(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "TheCar.png" )));
	 }

	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,
		Class<T> controlClass) {
		 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,
		primaryStage, ControladorPrincipal.this);
	 }






	}