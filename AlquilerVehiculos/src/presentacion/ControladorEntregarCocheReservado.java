package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.*;

import java.awt.Button;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.AlquilerVehiculos;
import logica.Cliente;
import logica.Sucursal;

public class ControladorEntregarCocheReservado extends ControladorCasoDeUso {

	@FXML
    private TextField id;
    @FXML
    private Button cancelar;
    @FXML
    private TableView<Reserva> sucursales;
    @FXML
    private TableColumn<Reserva, Integer> id_0;
    @FXML
    private TableColumn<Reserva, LocalDateTime> Fecha_recogida;
    @FXML
    private TableColumn<Reserva, Integer> Lugar_recogida;
    @FXML
    private TableColumn<Reserva, LocalDateTime> Fecha_devol;
    @FXML
    private TableColumn<Reserva, Integer> Lugar_devol;
    @FXML
    private TableColumn<Reserva, String> modalidad;
    @FXML
    private TableColumn<Reserva, String> nombre_cliente;
    @FXML
    private TableColumn<Reserva, String> categoria;
    @FXML
    private Label label;
    int identificador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
             stage = new Stage(StageStyle.DECORATED);
             stage.setTitle("COCHES SIN RESERVA");
             try {
				boot();
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    public void boot() throws DAOExcepcion {
    	sucursales.getItems().clear();
        try {
        		//getNombreCategoria() devuelve el DNI del cliente.
        		//getDNI() devuelve el nombre de la categoría.
                id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
                Fecha_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
                Fecha_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
                modalidad.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
                nombre_cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoria()));
                categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
                Lugar_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalRecogida()));
                Lugar_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalDevolucion()));

                this.sucursales.getItems().addAll(AlquilerVehiculos.dameAlquiler().obtenerCochesSinReserva());

        } catch(Exception e) {
                //AlquilerVehiculos.createAlert("Sin reservas", AlertType.INFORMATION, "No hay reservas para el ID introducido");
        		e.printStackTrace();
        }
    }

    public void mostrar() throws DAOExcepcion {
            Reserva res = sucursales.getSelectionModel().getSelectedItem();
            String resu = res.getDniCliente();
            //Sucursal y categoria La categopria se obtiene en getDNIcliente()

            String categoria0 = res.getNombreCategoria();
            int sucursal = res.getIdSucursalDevolucion();
            /*id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
            Fecha_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
            Fecha_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
            modalidad.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
            nombre_cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoria()));
            categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
            Lugar_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalRecogida()));
            Lugar_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalDevolucion()));
            //this.sucursales.getItems().addAll(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0));*/
            System.out.println(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0));
            AlquilerVehiculos.createAlert("COCHE SELECCIONADO", AlertType.CONFIRMATION, String.valueOf(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0)));
    }

    public void cerrar(ActionEvent event) {
            stage.close();
    }
}
