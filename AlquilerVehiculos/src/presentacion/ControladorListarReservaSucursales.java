package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.*;

import java.awt.Button;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Sucursal;

public class ControladorListarReservaSucursales extends ControladorCasoDeUso {

	@FXML
	private TextField id;
	@FXML
	private Button cancelar;
	@FXML
	private TableView<Reserva> sucursales;
	@FXML
	private TableColumn<Reserva, Integer> id_0;
	@FXML
	private TableColumn<Reserva, LocalDateTime> Fecha_recogida;
	@FXML
	private TableColumn<Reserva, Integer> Lugar_recogida;
	@FXML
	private TableColumn<Reserva, LocalDateTime> Fecha_devol;
	@FXML
	private TableColumn<Reserva, Integer> Lugar_devol;
	@FXML
	private TableColumn<Reserva, Integer> modalidad;
	@FXML
	private TableColumn<Reserva, String> nombre_cliente;
	@FXML
	private TableColumn<Reserva, String> categoria;
	int identificador;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE SUCURSALES RESERVA");

	}

	public void buscar(ActionEvent event) throws DAOExcepcion {
		AlquilerVehiculos AL = new AlquilerVehiculos();
		identificador = Integer.parseInt(id.getText());
		id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
		Fecha_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
		Fecha_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
		modalidad.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
		nombre_cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
		categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoria()));
		Lugar_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalRecogida()));
		Lugar_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalDevolucion()));
		this.sucursales.getItems().addAll(AL.listarReservas(identificador));

	}

	public void cerrar(ActionEvent event) {
		stage.close();
	}
}