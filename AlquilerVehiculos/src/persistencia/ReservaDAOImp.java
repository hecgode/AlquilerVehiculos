package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.ReservaDTO;

import java.time.LocalDateTime;


public class ReservaDAOImp implements IReservaDAO{


	protected ConnectionManager connManager;


	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}


	public ReservaDTO buscarReserva(int identificador) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where ID="+idSucursal);
			connManager.close();

			List<ReservaDTO> listaresDTO = new ArrayList<ReservaDTO>();

			try{
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("fechaRecogida").toLocalDate(),rs.getTime("fechaRecogida").toLocalTime()),
							LocalDateTime.of(rs.getDate("fechaDevolucion").toLocalDate(),rs.getTime("fechaDevolucion").toLocalTime()),
							rs.getInt("modalidadAlquiler"),
							rs.getString("dniCliente"),
							rs.getString("nombreCategoria"),
							rs.getInt("idSucursalRecogida"),
							rs.getInt("idSucursalDevolucion"));
				listaresDTO.add(resDTO);
				}
				return listaresDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}
	}

	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion {
		// TODO Auto-generated method stub

	}
}
