package presentacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Coche;
import logica.Reserva;

public class ControladorCoches extends ControladorCasoDeUso{

	@FXML
    private TextField id;
	@FXML
	private TableView<Coche> coches;
	@FXML
    private TableColumn<Coche, String> id_0;
    @FXML
    private TableColumn<Coche, Integer> id_1;
    @FXML
    private Button button1;

	@Override
    public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
             stage = new Stage(StageStyle.DECORATED);
             stage.setTitle("COCHES");
             try {
				boot();
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

	public void boot() throws DAOExcepcion {
		id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getMatricula()));
		id_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKm()));
		int sucursal = AlquilerVehiculos.dameAlquiler().getCocheSucursal();
		String categoria = AlquilerVehiculos.dameAlquiler().getCocheCategoria();
		this.coches.getItems().addAll(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal,categoria));
    }

	public void reservar() throws IOException, DAOExcepcion {
		Coche coche = null;
		try{
			coche = coches.getSelectionModel().getSelectedItem();
			AlquilerVehiculos.dameAlquiler().setCocheMatricula(coche.getMatricula());
		}catch(Exception err) {
			AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Selecciona un coche previamente");
	    }
		Parent root = FXMLLoader.load(getClass().getResource("InsertarCocheBaseDeDatos.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("INSERTAR DATOS RESERVA");
		stage.setResizable(false);
		stage.show();
	}

	public void cerrar(ActionEvent event) {
		Stage stage = (Stage) button1.getScene().getWindow();
		stage.close();
	}
}
