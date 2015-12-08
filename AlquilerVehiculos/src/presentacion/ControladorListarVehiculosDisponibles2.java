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
import logica.Reserva;
import logica.Sucursal;

public class ControladorListarVehiculosDisponibles2 extends ControladorCasoDeUso {
	 @FXML
	 private TableView<Sucursal> sucursales;
	 @FXML
	 private TableColumn<Sucursal, Integer> id;
	 @FXML
	 private TableColumn<Sucursal, String> direccion;
	 @FXML
	 private Button aceptar;

	 @FXML
	 public void aceptar (ActionEvent eve) {
		 stage.close();

	 }

	 public void boot() throws DAOExcepcion, LogicaExcepcion {
		 
		 id.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getIdentificador()));
					 direccion.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getDireccion()));


					this.sucursales.getItems().addAll( AlquilerVehiculos.dameAlquiler().listarSucursales());

	 }

	 private void parametros() throws DAOExcepcion {
	    	try{
		        Sucursal suc = sucursales.getSelectionModel().getSelectedItem();
		        AlquilerVehiculos.dameAlquiler().SetCocheNumSucursal(suc.getIdentificador());
	        }catch(Exception err) {
	        	AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Selecciona una reserva previamente");
	        }
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
  	  	parametros();
  		Parent root = FXMLLoader.load(getClass().getResource("listarVehiculosDisponibles2.fxml"));
  		Scene scene = new Scene(root);
  		stage.setScene(scene);
  		stage.setTitle("COCHES DISPONIBLES DE LA SUCURSAL");
  		stage.show();
   }
}
