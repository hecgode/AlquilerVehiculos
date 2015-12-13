package presentacion;


import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Categoria;
import logica.Reserva;
import logica.Sucursal;

public class ControladorCrearReserva extends ControladorCasoDeUso {

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
	 private Button p;
	 @FXML
	 private Button cancelar;
	 @FXML
	 private TableColumn<Sucursal, Integer> id_r;
	 @FXML
	 private TableColumn<Sucursal, Integer> id_d;
	 @FXML
	 private Label label;
	 @FXML
	 private Label pre;
	 @FXML
	 ComboBox<String> cbx;
	 @FXML
	 ComboBox<String> cbx2;
	 @FXML
	 ComboBox<String> cbx3;
	 @SuppressWarnings("static-access")
	@FXML

	public void aceptar (ActionEvent eve) throws DAOExcepcion {
		 try {
				LocalTime local = null ;
				Reserva nuevaReserva = new Reserva(Integer.parseInt(id.getText()),LocalDateTime.of(recogida.getValue(),local.MIDNIGHT),LocalDateTime.of(devol.getValue(),local.NOON),moda.getText(),dnic.getText(),
						 this.cbx3.getSelectionModel().getSelectedItem().toString(),Integer.parseInt(this.cbx2.getSelectionModel().getSelectedItem().toString()),Integer.parseInt(this.cbx2.getSelectionModel().getSelectedItem().toString()));

			if(AlquilerVehiculos.dameAlquiler().comprobarReservasID(Integer.parseInt(id.getText())) == false)
			{
				AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "id de la reserva existente,elija otro");
			}
			else
			{
				 if(id.getText().length()<=0 || moda.getText().length()<=0 || dnic.getText().length()<=0) {
					 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "comprueba que ningun campo este vacio");
				 }
				 else {
					 if (nuevaReserva != null) {
						 if (AlquilerVehiculos.dameAlquiler().buscaClientes(dnic.getText())==false) {
							 AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "¡Cliente no existe!");
					}
					else {
						 AlquilerVehiculos.dameAlquiler().crearReserva(nuevaReserva);
						 AlquilerVehiculos.createAlert("Información", AlertType.INFORMATION, "Reserva creada con éxito");
						 stage.close();
					 }
				}
			 }
			}
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 LocalTime local = null ;
			 String pantallazo = "error producido en: ";
				try {
					Integer.parseInt(id.getText());
				}
				catch(Exception err1) {

					pantallazo += " id";
				}
				try {
					LocalDateTime.of(recogida.getValue(),local.MIDNIGHT);
				}
				catch(Exception err1) {

					if(!pantallazo.equals("error producido en: ")) {
						pantallazo += ", fecha recogida";
					}
					else {
						pantallazo += "fecha recogida ";
					}
				}
				try {
					LocalDateTime.of(devol.getValue(),local.NOON);
				}
				catch(Exception err1){
					if(!pantallazo.equals("error producido en: ")){
						pantallazo += ", fecha devolucion";
					}
					else {
						pantallazo += "fecha devolucion ";
					}
				}
				pantallazo += ".";
				AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, pantallazo);

		 }
	}

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

	 public void cargarpre() throws DAOExcepcion {
		 try {
			 List<Categoria> aux2 = AlquilerVehiculos.dameAlquiler().getmCategoria();
			 ObservableList<String> precios =
					    FXCollections.observableArrayList( );
			 for (int i=0;i<aux2.size();i++)
				 if (aux2.get(i).getNombre()==this.cbx3.getSelectionModel().getSelectedItem().toString()) {
					precios.addAll(String.valueOf("\tIlimitada: "+aux2.get(i).getPrecioModIlimitada())+"€\n");
					precios.addAll(String.valueOf("\tModKms: "+aux2.get(i).getPrecioModKms())+"€\n");
			 		precios.addAll(String.valueOf("\tSeguro: "+aux2.get(i).getPrecioSeguroTRiesgo())+"€\n");
			 		precios.add(String.valueOf("\tSeguro terceros: "+aux2.get(i).getPrecioSeguroTerceros())+"€\n");
			 		precios.add(String.valueOf("\tKMModKms: "+aux2.get(i).getPrecioKMModKms())+"€\n");
				 }
			 String parameter = precios.toString();
			 parameter = parameter.substring(1, parameter.length()-1);
			 String chain = parameter.replaceAll(",", " ");
			 AlquilerVehiculos.createAlert("PRECIOS", AlertType.INFORMATION, chain);
		 } catch(Exception e) {
			 AlquilerVehiculos.createAlert("CUIDADO", AlertType.INFORMATION, "Faltan datos");
		 }
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
		stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));

		try {
			boot();
		} catch (DAOExcepcion | LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
