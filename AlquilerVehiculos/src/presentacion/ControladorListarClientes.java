package presentacion;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Sucursal;
import java.net.URI;
import java.net.URL;

public class ControladorListarClientes extends ControladorCasoDeUso {
    @FXML
	 private TableView<Cliente> clientes;
	 @FXML
	 private TableColumn<Cliente, String> dni;
	 @FXML
	 private TableColumn<Cliente, String> nombreyApellidos;
	 @FXML
	 private TableColumn<Cliente, String> direccion;
	 @FXML
	 private TableColumn<Cliente, String> poblacion;
	 @FXML
	 private TableColumn<Cliente, String> codigopostal;
	 @FXML
	 private TableColumn<Cliente, LocalDateTime> fecha;
	 @FXML
	 private TableColumn<Cliente, String> digitos;
	 @FXML
	 private TableColumn<Cliente, Integer> mes;
	 @FXML
	 private TableColumn<Cliente, Integer > año;
	 @FXML
	 private TableColumn<Cliente, Integer> cvc;
	 @FXML
	 private TableColumn<Cliente, String> tipo;

	 @FXML
	 public void aceptar (ActionEvent eve) {
		 stage.close();
	 }

	 public void boot() throws DAOExcepcion, LogicaExcepcion {

		 	dni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdendificador()));
		 	nombreyApellidos.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreyApellidos()));
			direccion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDireccion()));
			poblacion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPoblacion()));
			codigopostal.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCodPostal()));
			fecha.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaCarnet()));
			digitos.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDigitos()));
			 mes.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getMes()));
			 año.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAnyo()));
			 cvc.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCvc()));
			 tipo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getTipo()));
			 AlquilerVehiculos al = new AlquilerVehiculos();
				this.clientes.getItems().addAll(al.listarClientes());
	 }




		@Override
		public void initialize(URL location, ResourceBundle resources) {
			 Stage stage = new Stage(StageStyle.DECORATED);
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



















}
