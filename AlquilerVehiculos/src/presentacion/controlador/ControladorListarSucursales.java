package presentacion.controlador;

import java.awt.Button;
import java.net.URI;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Sucursal;

public class ControladorListarSucursales extends ControladorCasoDeUso {
	 @FXML
	 private TableView<Sucursal> sucursales;
	 @FXML
	 private TableColumn<Sucursal, Integer> id;
	 @FXML
	 private TableColumn<Sucursal, String> direccion;
	 @FXML
	 private Button aceptar;
	 @Override
	 public void initialize(URI location, ResourceBundle resources)
	 {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("LISTADO DE SUCURSALES");
	 aceptar.setOnAction(event -> dialog.close());
	 id.setCellValueFactory(param -> new
	ReadOnlyObjectWrapper<>(param.getValue().getId()));
	 direccion.setCellValueFactory(param -> new
	ReadOnlyObjectWrapper<>(param.getValue().getDireccion()));

	this.sucursales.getItems().addAll(AlquilerVehiculos.dameAlquilerVehiculos().listarsucursales());
	 }
	}