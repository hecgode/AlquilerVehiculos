package presentacion;


import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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
import logica.Categoria;
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
	 private TableColumn<Sucursal, Integer> id_r;
	 private Cliente nuevoCliente;
	 @FXML
	 private TableColumn<Sucursal, Integer> id_d;
	 @FXML
	 private Label label;
	 @FXML
	 ComboBox<String> cbx;
	 @FXML
	 ComboBox<String> cbx2;
	 @FXML
	 ComboBox<String> cbx3;


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
					 this.cbx3.getSelectionModel().getSelectedItem().toString(),Integer.parseInt(this.cbx2.getSelectionModel().getSelectedItem().toString()),Integer.parseInt(this.cbx2.getSelectionModel().getSelectedItem().toString()));
					 //Integer.parseInt(ud1.getText()),Integer.parseInt(ud2.getText()));


			 if(id.getText().length()<=0 || moda.getText().length()<=0 || dnic.getText().length()<=0)
			 {
				 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "comprueba que ningun campo este vacio");
			 }
			 else
			 {
				 if (nuevaReserva != null) {
					 if (AlquilerVehiculos.dameAlquiler().buscaClientes(dnic.getText())==false) {
						 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "¡Cliente no existe!");
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


				pantallazo += ".";
				AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, pantallazo);

		 }}






	 @FXML
	 public void cancelar (ActionEvent eve) {
		 stage.close();

	 }
	 @Override


	 public void boot() throws DAOExcepcion, LogicaExcepcion {
		 ObservableList<String> suc =
		    FXCollections.observableArrayList( );
		 List<Sucursal> aux = AlquilerVehiculos.dameAlquiler().getmSucursal();
		 for (int i=0;i<aux.size();i++)
			 suc.add(Integer.toString(aux.get(i).getIdentificador()));

		 ObservableList<String> cat =
				    FXCollections.observableArrayList( );

		 List<Categoria> aux2 = AlquilerVehiculos.dameAlquiler().getmCategoria();
		 for (int i=0;i<aux2.size();i++)
			 cat.add(aux2.get(i).getNombre());




		 	cbx.setItems(suc);
		 	cbx2.setItems(suc);
		 	cbx3.setItems(cat);

	 }


	 public void actualizar () throws DAOExcepcion {
		 ObservableList<String> suc =
				    FXCollections.observableArrayList( );
		 List<Sucursal> aux = AlquilerVehiculos.dameAlquiler().getmSucursal();
		 for (int i=0;i<aux.size();i++)
			 suc.add(Integer.toString(aux.get(i).getIdentificador()));


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
