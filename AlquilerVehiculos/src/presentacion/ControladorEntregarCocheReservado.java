package presentacion;

import javafx.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.*;

import java.awt.Button;
import java.io.IOException;
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
 			stage.getIcons().add(new Image(AlquilerVehiculosApp.class.getResourceAsStream( "coche.png" )));

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
                AlquilerVehiculos.createAlert("Sin reservas", AlertType.INFORMATION, "No hay reservas para el ID introducido");
        		e.printStackTrace();
        }
    }

    public void mostrar() throws DAOExcepcion {
    	try {
    		Reserva res = sucursales.getSelectionModel().getSelectedItem();
            String resu = res.getDniCliente();
            int b;
            //Sucursal y categoria La categopria se obtiene en getDNIcliente()
            String categoria0 = res.getDniCliente();
            int sucursal = res.getIdSucursalRecogida();
            //System.out.println("Hasta aquí");
            //id_0.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
            //Fecha_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
            //Fecha_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
            //modalidad.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
            //nombre_cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreCategoria()));
            //categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
            //Lugar_recogida.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalRecogida()));
            //Lugar_devol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getIdSucursalDevolucion()));
            //this.sucursales.getItems().addAll(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0));
            /*System.out.println(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0));
            if(String.valueOf(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0))=="[]") {
            	AlquilerVehiculos.createAlert("COCHE SELECCIONADO", AlertType.INFORMATION, "No hay coches para esta reserva");
            }
            else {
            	 AlquilerVehiculos.createAlert("COCHE SELECCIONADO", AlertType.INFORMATION, String.valueOf(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0)));
            }*/
            //System.out.println(sucursal);
            //System.out.println(categoria0);
            //System.out.println(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0));
           // AlquilerVehiculos.createAlert("COCHE SELECCIONADO", AlertType.INFORMATION, String.valueOf(AlquilerVehiculos.dameAlquiler().obtenerCochesDisp(sucursal, categoria0)));
    	} catch(Exception e) {
    		AlquilerVehiculos.createAlert("NO HAY COCHE SELECCIONADO", AlertType.INFORMATION, "No hay nada seleccionado.");
    	}

    }

    private void parametros() throws DAOExcepcion {
    	try{
	        Reserva res = sucursales.getSelectionModel().getSelectedItem();
	        String categoria0 = res.getDniCliente();
	        int sucursal = res.getIdSucursalDevolucion();
	        AlquilerVehiculos.dameAlquiler().setCocheCategoria(categoria0);
	        AlquilerVehiculos.dameAlquiler().setCocheSucursal(sucursal);
	        AlquilerVehiculos.dameAlquiler().setCocheFechaE(res.getFechaRecogida());
	        AlquilerVehiculos.dameAlquiler().SetCocheId(res.getId());
        }catch(Exception err) {
        	AlquilerVehiculos.createAlert("ERROR", AlertType.ERROR, "Selecciona una reserva previamente");
        }
       }

    public void cerrar(ActionEvent event) {

    	stage.close();
    }

      @FXML
      public void abrir(ActionEvent event) throws IOException, DAOExcepcion {
    	  	parametros();
    		Parent root = FXMLLoader.load(getClass().getResource("EntregarCoche.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("VER COCHES");
    		stage.show();
     }
}
