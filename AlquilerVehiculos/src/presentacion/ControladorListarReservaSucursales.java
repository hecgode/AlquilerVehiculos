package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.*;

import java.awt.Button;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
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
	private TableColumn<Reserva, String> modalidad;
	@FXML
	private TableColumn<Reserva, String> nombre_cliente;
	@FXML
	private TableColumn<Reserva, String> categoria;
	@FXML
	private Label label;
	int identificador;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE SUCURSALES RESERVA");
			stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));


	}

	public void buscar(ActionEvent event) throws DAOExcepcion {
		sucursales.getItems().clear();
		try {
			identificador = Integer.parseInt(id.getText());
			id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
			Fecha_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
			Fecha_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
			modalidad.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
			nombre_cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
			categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoria()));
			Lugar_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalRecogida()));
			Lugar_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalDevolucion()));
		//	categorias.setCellValueFactory(value);//AL.cargaReservasPorSucursal(identificador);
			List<Reserva> res = AlquilerVehiculos.dameAlquiler().listarReservas(identificador);
			if(res.isEmpty())
				throw new IllegalStateException();

			this.sucursales.getItems().addAll(AlquilerVehiculos.dameAlquiler().listarReservas(identificador));

		} catch(Exception e) {
			AlquilerVehiculos.createAlert("Sin reservas", AlertType.INFORMATION, "No hay reservas para el ID introducido");
		}
	}

	public void mostrar() throws DAOExcepcion {
		Reserva res = sucursales.getSelectionModel().getSelectedItem();
		String resu = res.getDniCliente();
		String textaco = AlquilerVehiculos.dameAlquiler().buscarCat(resu);
		textaco = textaco.substring(1, textaco.length()-1);
		textaco = textaco.replaceAll(",", " ");
		label.setText(textaco);
	}

	public void cerrar(ActionEvent event) {
		stage.close();
	}
}