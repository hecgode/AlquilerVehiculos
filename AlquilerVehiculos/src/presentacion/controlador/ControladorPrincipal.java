package presentacion.controlador;

//import java.awt.event.ActionEvent;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ControladorPrincipal {
	 private static final String CREAR_CLIENTE = "presentacion/controlador/crear-cliente.fxml";
	// private static final String LISTAR_RESERVAS_SUCURSAL = "presentacion/controlador/listarreservas-sucursal.fxml";
	 private static final String LISTAR_SUCURSALES = "presentacion/controlador/listarsucursales.fxml";

	 private Stage primaryStage;
	 @FXML
	 void listarSucursales(ActionEvent event) throws LogicaExcepcion {
	 initCasoDeUso(LISTAR_SUCURSALES,
	ControladorListarSucursales.class).show();
	 }
	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
	 initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show();
	 }
	 @FXML
	 public void crearReserva(ActionEvent event) {
	 // TODO implementar el manejador del C.U. Crear Reserva
	 }
	 @FXML
	 public void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion {
	 //TODO implementar el manejador del C.U. Listar reservas de una sucursal
	 }
	 @FXML
	 public void salir(ActionEvent event) {
		 Object source = event.getSource();
		 Platform.exit();
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