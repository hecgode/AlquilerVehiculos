package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/

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
			try {
				connManager.connect();
				ResultSet rs = connManager.queryDB("SELECT * FROM RESERVA WHERE ID="+identificador);
				connManager.close();

				if(rs.next()) {
					return new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
							LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
							rs.getInt("MODALIDADALQUILER"),
							rs.getString("CLIENTEREALIZA"),
							rs.getString("CATEGORIA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));

				}
				else
					return null;
			} catch(SQLException e) {
				throw new DAOExcepcion(e);
			}
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
		try {
			connManager.connect();
			connManager.updateDB("insert into RESERVA  (ID, FECHARECOGIDA, FECHADEVOLUCION, MODALIDADALQUILER, CATEGORIA, CLIENTEREALIZA, SUCURSALRECOGIDA, SUCURSALDEVOLUCION) values"
			+"('"+reserva.getId()+"','"+reserva.getFechaRecogida()+"','"
					+reserva.getFechaDevolucion()+"','"+reserva.getModalidadAlquiler()
					+"','"+reserva.getNombreCategoria()+"','"+reserva.getDniCliente()
					+"','"+reserva.getIdSucursalRecogida()+"','"
					+reserva.getFechaDevolucion());
			connManager.close();

		}
		catch(Exception e) {
			throw new DAOExcepcion(e);
		}
	}



}
