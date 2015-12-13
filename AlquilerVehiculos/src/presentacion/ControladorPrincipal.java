package presentacion;

//import java.awt.event.ActionEvent;
import javafx.event.*;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ControladorPrincipal {
	 private static final String CREAR_CLIENTE = "crear-cliente.fxml";
	 private static final String Crear_Reserva = "Crear-reserva.fxml";
	 private static final String LISTAR_SUCURSALES = "listarsucursales.fxml";
	 private static final String LISTAR_CATEGORIAS = "listarcategorias.fxml";
	 private static final String Crear_Sucursal = "CrearSucursal.fxml";
	 private static final String LISTAR_CLIENTES = "listarclientes.fxml";
	 private static final String LISTAR_RESERVA_SUCURSAL = "listarreservasucursal.fxml";
	 private static final String ENTREGAR_COCHE_RESERVADO = "EntregarCocheReservado.fxml";
	 private static final String INSERTAR_COCHE_BASE_DE_DATOS = "InsertarCocheBaseDeDatos.fxml";
	 private static final String LISTAR_VEHICULOS_DISPONIBLES = "listarVehiculosDisponibles.fxml";
	 private static final String LISTAR_VEHICULOS_DISPONIBLES2 = "listarVehiculosDisponibles2.fxml";

	 private Stage primaryStage;


	 @FXML
	 private ImageView i1;

	 @FXML
	 void ListarVehiculosDisponibles2(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_VEHICULOS_DISPONIBLES2, ControladorListarVehiculosDisponibles2.class).show();
	 }

	 @FXML
	 void ListarVehiculosDisponibles(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_VEHICULOS_DISPONIBLES, ControladorListarVehiculosDisponibles.class).show();
	 }

	 @FXML
	 void InsertarCocheBaseDeDatos(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(INSERTAR_COCHE_BASE_DE_DATOS, EntregaCoche.class).show();
	 }

	 @FXML
	 void EntregarCocheReservado(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(ENTREGAR_COCHE_RESERVADO, ControladorEntregarCocheReservado.class).show();
	 }

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
		 exit();
	 }

	 public void exit() {
		 Alert alert = new Alert(AlertType.CONFIRMATION, "¿De verdad quieres salir?", ButtonType.YES, ButtonType.NO);
		 Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));

		 alert.showAndWait();

		 if (alert.getResult() == ButtonType.YES) {
			 Platform.exit();
		 }
		 else
			 alert.close();
	 }



	 @FXML
	 void about(ActionEvent event) {

		 
		 	
		 Alert alert = new Alert(AlertType.INFORMATION);
		 Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));


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
		 Platform.setImplicitExit(false);

		 primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		     @Override
		     public void handle(WindowEvent event) {
		    	 exit();
		    	 event.consume();
		     }
		 });
	 }

	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,
		Class<T> controlClass) {
		 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,
		primaryStage, ControladorPrincipal.this);
	 }
	}