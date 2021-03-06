package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
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
import logica.Categoria;

public class ControladorListarCategorias  extends ControladorCasoDeUso {

	@FXML
	 private TableView<Categoria> categorias;

	 @FXML
	 private TableColumn<Categoria, String> nombre;
	 @FXML
	 private TableColumn<Categoria, Double> precioIli;
	 @FXML
	 private TableColumn<Categoria, Double> preciokm;
	 @FXML
	 private TableColumn<Categoria, Double> precioSeguroRiesgos;
	 @FXML
	 private TableColumn<Categoria, Double> precioSeguroTerceros;
	 @FXML
	 private TableColumn<Categoria, String> catsup;
	 @FXML
	 private TableColumn<Categoria, Double> preciokmmodkm;
	 @FXML
	 private Button aceptar;

	 private Categoria nuevaCategoria;


	 public void boot() throws DAOExcepcion, LogicaExcepcion {
		 nombre.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
		 precioIli.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioModIlimitada()));
		 preciokm.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioModKms()));
		 		 precioSeguroRiesgos.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroTRiesgo()));
		 precioSeguroTerceros.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroTerceros()));
		 catsup.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoriaSuperior()));
		 preciokmmodkm.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioKMModKms()));

		 			AlquilerVehiculos al = new AlquilerVehiculos();
		 			this.categorias.getItems().addAll(al.listarCategoria());

	 }

	 @Override
		public void initialize(URL location, ResourceBundle resources) {
			 stage = new Stage(StageStyle.DECORATED);
			 stage.setTitle("LISTADO DE CATEGORIAS");
				stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));

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
