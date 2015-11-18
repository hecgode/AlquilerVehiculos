package presentacion;

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
	 private TableColumn<Categoria, Double> preciokmmodkm;
	 @FXML
	 private TableColumn<Categoria, Double> precioSeguroRiesgos;
	 @FXML
	 private TableColumn<Categoria, Double> precioSeguroTerceros;
	 @FXML
	 private TableColumn<Categoria, String> catsup;
	 @FXML
	 private Button aceptar;

	 public void boot() throws DAOExcepcion, LogicaExcepcion {
		 nombre.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
		 precioIli.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioIli()));
		 preciokm.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPreciokm()));
		 preciokmmodkm.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPreciokmmodkm()));
		 precioSeguroRiesgos.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroRiesgos()));
		 precioSeguroTerceros.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroTerceros()));
		 catsup.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getCatsup()));

		 			this.categorias.getItems().addAll( AlquilerVehiculos.dameAlquiler().listarCategoria());

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

}
