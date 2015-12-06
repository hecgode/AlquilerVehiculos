package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
		this.coches.getItems().addAll(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(2,"luxury"));
    }

	public void cerrar(ActionEvent event) {
		Stage stage = (Stage) button1.getScene().getWindow();
		stage.close();
	}
}
