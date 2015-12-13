package presentacion;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Entrega;
import logica.Reserva;

public class EntregaCoche extends ControladorCasoDeUso {

	@FXML
	private Button close_btn;


	@FXML
	private TextField seguro;
	@FXML
	private TextField km;
	@FXML
	private TextField combustible;
	@FXML
	private TextField empleadoRealiza;
	@FXML
	private ComboBox<String> cbx;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stubs
		ObservableList<String> clientes =
			    FXCollections.observableArrayList("12345678A","23456789B","34567890C" );
		cbx.setItems(clientes);
	}

	public void realizarEntrega() throws DAOExcepcion
	{
		if(Double.valueOf(km.getText().toString())<0 || Double.valueOf(combustible.getText().toString())<0)
		{
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Introduce valores positivos");
			return;
		}
		try
		{
			Entrega en = new Entrega(AlquilerVehiculos.dameAlquiler().getCocheId(),
					AlquilerVehiculos.dameAlquiler().getCocheFechaE(),seguro.getText().toString(),
					Double.valueOf(km.getText().toString()),Double.valueOf(combustible.getText().toString()),
					AlquilerVehiculos.dameAlquiler().getCocheMatricula(),
					this.cbx.getSelectionModel().getSelectedItem().toString());


			//Entrega en = new Entrega(AlquilerVehiculos.dameAlquiler().getCocheId(),AlquilerVehiculos.dameAlquiler().getCocheFechaE(),seguro.getText().toString(),2.0,4.0,AlquilerVehiculos.dameAlquiler().getCocheMatricula(),"23456789B");
				AlquilerVehiculos.dameAlquiler().crearEntrega(en);
				AlquilerVehiculos.createAlert("INFORMACION", AlertType.INFORMATION, "Entrega Realizada con exito");

		}catch(Exception err) {
			System.out.println("1.- "+AlquilerVehiculos.dameAlquiler().getCocheId()+" 2.- "+AlquilerVehiculos.dameAlquiler().getCocheFechaE()+"3.- "+AlquilerVehiculos.dameAlquiler().getCocheMatricula());
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Se ha producido un error");
		}
	}

	private void parametros() throws DAOExcepcion {
    	try{

        }catch(Exception err) {
        	AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Selecciona una reserva previamente");
        }
       }

	@FXML
    public void abrir(ActionEvent event) throws IOException, DAOExcepcion {
  	  	parametros();
  		Parent root = FXMLLoader.load(getClass().getResource("EntregarCoche.fxml"));
  		Scene scene = new Scene(root);
  		stage.setScene(scene);
  		stage.setTitle("VER COCHES");
  		stage.show();
		stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));

   }

	public void close(ActionEvent event) {
		try {
			Stage stage = (Stage) close_btn.getScene().getWindow();
			stage.close();
			System.out.println("Back in the 90's. I was in a very famous TV show... ");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
