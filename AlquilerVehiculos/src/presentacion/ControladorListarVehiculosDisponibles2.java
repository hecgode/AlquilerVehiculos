package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Button;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Coche;
import logica.Reserva;
import logica.Sucursal;

public class ControladorListarVehiculosDisponibles2 extends ControladorCasoDeUso {
	 @FXML
	 private TableView<Coche> coches;
	 @FXML
	 private TableColumn<Coche, String> matricula;
	 @FXML
	 private TableColumn<Coche, Integer> kms;
	 @FXML
	 private TableColumn<Coche, String> categoria;
	 @FXML
	 private Button aceptar;

	 @FXML
	 public void aceptar (ActionEvent eve) {
		 this.stage.close();

	 }

	 public void boot() throws DAOExcepcion, LogicaExcepcion {

		 matricula.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getMatricula()));
					 kms.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getKm()));
					 categoria.setCellValueFactory(param -> new
								ReadOnlyObjectWrapper<>(param.getValue().getCategoria()));


					this.coches.getItems().addAll( AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(AlquilerVehiculos.dameAlquiler().getCocheNumScurusal()));

	 }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE SUCURSALES");
		 try {
			boot();
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@FXML
    public void abrir(ActionEvent event) throws IOException, DAOExcepcion {
  		stage.close();
   }
}
