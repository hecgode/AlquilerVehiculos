package presentacion;


import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.sun.javafx.logging.Logger;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Reserva;
import logica.Sucursal;

public class ControladorCrearReserva extends ControladorCasoDeUso {
	// private static final Logger LOG =	Logger.getLogger(ControladorCrearCliente.class.getName());
	 @FXML
	 private TextField id;
	 @FXML
	 private DatePicker recogida;
	 @FXML
	 private DatePicker devol;
	 @FXML
	 private TextField moda;
	 @FXML
	 private TextField dnic;
	 @FXML
	 private Button aceptar;
	 @FXML
	 private Button cancelar;
	 @FXML
	 private TableView<Sucursal> sucursales;
	 @FXML
	 private TableView<Sucursal> sucursales_d;
	 @FXML
	 private TableColumn<Sucursal, Integer> id_r;
	 private Cliente nuevoCliente;
	 @FXML
	 private TableColumn<Sucursal, Integer> id_d;
	 @FXML
	 private Label label;
	 @FXML
	 ComboBox<String> cbx;

	 public int obtenerSucuR() {
		 int suc = sucursales.getSelectionModel().getSelectedItem().getIdentificador();
		 System.out.println(suc);
		 return suc;

	 }

	 public int obtenerSucuD() {
		 int suc2 = sucursales_d.getSelectionModel().getSelectedItem().getIdentificador();
		 System.out.println(suc2);
		 return suc2;

	 }

/*


	 public int sucursalrecogia () {

		 int suc = sucursales.getSelectionModel().getSelectedItem().getIdentificador();
		 return suc;
	 }
	 public int sucursaldevol () {

		 int suc2 = sucursales_d.getSelectionModel().getSelectedItem().getIdentificador();
		 return suc2;
	 }
*/
	 public void aceptar (ActionEvent eve) throws DAOExcepcion
	 {

		 try {


			LocalTime local = null ;
			//int suc = sucursales.getSelectionModel().getSelectedItem().getIdentificador();




			Reserva nuevaReserva = new Reserva(Integer.parseInt(id.getText()),LocalDateTime.of(recogida.getValue(),local.MIDNIGHT),LocalDateTime.of(devol.getValue(),local.NOON),moda.getText(),dnic.getText(),
					 this.cbx.getSelectionModel().getSelectedItem().toString(),obtenerSucuR(),obtenerSucuD());
					 //Integer.parseInt(ud1.getText()),Integer.parseInt(ud2.getText()));


			 if(id.getText().length()<=0 || moda.getText().length()<=0 || dnic.getText().length()<=0 || this.cbx.getSelectionModel().getSelectedItem().toString().length()<=0)
			 {
				 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "comprueba que ningun campo este vacio");
			 }
			 else
			 {
				 if (nuevaReserva != null) {
					 if (AlquilerVehiculos.dameAlquiler().buscaClientes(dnic.getText())==false) {
						 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "¡Cliente no existe!");
				}

				 else if (!AlquilerVehiculos.dameAlquiler().buscarSucursal(obtenerSucuR()))
				{
					 AlquilerVehiculos.createAlert("Información", AlertType.INFORMATION, "Sucursal no existe");

				}



				 else if (!AlquilerVehiculos.dameAlquiler().buscarSucursal(obtenerSucuD()))
				 {
			 AlquilerVehiculos.createAlert("Información", AlertType.INFORMATION, "Sucursal no existe");

			 System.out.print("Sucursal no existe");

				 }
				 else {
					 AlquilerVehiculos.dameAlquiler().crearReserva(nuevaReserva);
					 AlquilerVehiculos.createAlert("Información", AlertType.INFORMATION, "Reserva creada con éxito");
					 stage.close();
				 }
			}//Invocamos el servicio encargado de Crear un nuevo cliente
		 }
}
		 catch(Exception e) {
			 e.printStackTrace();
			 LocalTime local = null ;
			 //AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "¡Faltan datos!");
			 String pantallazo = "error producido en: ";
				try{Integer.parseInt(id.getText());}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del mes incorrecto");
					pantallazo += " id";
				}
				try{LocalDateTime.of(recogida.getValue(),local.MIDNIGHT);}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del a�o incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", fecha recogida";
					}
					else
					{
						pantallazo += "fecha recogida ";
					}
				}
				try{LocalDateTime.of(devol.getValue(),local.NOON);}
				catch(Exception err1)
				{
					//AlquilerVehiculosApp.createAlert("ERROR", AlertType.ERROR, "campo del a�o incorrecto");
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", fecha devolucion";
					}
					else
					{
						pantallazo += "fecha devolucion ";
					}
				}
				try {
					obtenerSucuR();
				} catch(Exception err2) {
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", obtener sucursal recogida";
					}
					else
					{
						pantallazo += "obtener sucursal recogida ";
					}
				}
				try {
					obtenerSucuD();
				} catch(Exception err2) {
					if(!pantallazo.equals("error producido en: "))
					{
						pantallazo += ", obtener sucursal devolucion";
					}
					else
					{
						pantallazo += "obtener sucursal devolucion ";
					}
				}


				pantallazo += ".";
				AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, pantallazo);

		 }}






	 @FXML
	 public void cancelar (ActionEvent eve) {
		 stage.close();

	 }
	 @Override


	 public void boot() throws DAOExcepcion, LogicaExcepcion {
		 
		  

		 id_r.setCellValueFactory(param -> new
					ReadOnlyObjectWrapper<>(param.getValue().getIdentificador()));


					this.sucursales.getItems().addAll( AlquilerVehiculos.dameAlquiler().listarSucursales());


					 id_d.setCellValueFactory(param -> new
								ReadOnlyObjectWrapper<>(param.getValue().getIdentificador()));


								this.sucursales_d.getItems().addAll( AlquilerVehiculos.dameAlquiler().listarSucursales());

	 }

	 public void initialize(URL location, ResourceBundle resources) {

		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR RESERVA");
		 try {
			boot();
			//sucursalrecogia();
			//sucursaldevol();
		} catch (DAOExcepcion | LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	 }
	}
