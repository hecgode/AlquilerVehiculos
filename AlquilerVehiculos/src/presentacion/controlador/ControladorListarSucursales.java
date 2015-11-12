package presentacion.controlador;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Button;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.AlquilerVehiculos;
import logica.Cliente;
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

	 @FXML
	 public void aceptar (ActionEvent eve) throws LogicaExcepcion, DAOExcepcion

	 {
		 id.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getIdentificador()));
					 direccion.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getDireccion()));
					 AlquilerVehiculos al = new AlquilerVehiculos();
					this.sucursales.getItems().addAll(al.listarSucursales());
					

					//AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);

}




	 @FXML
	 public void cancelar (ActionEvent eve)

	 {
		 stage.close();

	 }










	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE SUCURSALES");

		}


}