package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import logica.AlquilerVehiculos;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
							rs.getString("MODALIDADALQUILER"),
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
			String str = "select * from RESERVA where  SUCURSALRECOGIDA  = "+idSucursal+"";
				ResultSet rs = connManager.queryDB(str);
					connManager.close();


			try{
				while (rs.next()){

				}
				List<ReservaDTO> RESER = new ArrayList<ReservaDTO>();



					while(rs.next()) {
						ReservaDTO RES = new ReservaDTO(
								rs.getInt("ID"),
								LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
								LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
								rs.getString("MODALIDADALQUILER"),
								rs.getString("CLIENTEREALIZA"),
								rs.getString("CATEGORIA"),
								rs.getInt("SUCURSALRECOGIDA"),
								rs.getInt("SUCURSALDEVOLUCION"));
						 RESER.add(RES);

					}
					return RESER;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}

	}

	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try {
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime dateTime = reserva.getFechaRecogida();
				String formattedDataRecogida=dateTime.format(formatter);
				LocalDateTime dateTime2 = reserva.getFechaDevolucion();
				String formattedDataEntrega=dateTime2.format(formatter);
				connManager.connect();
			//	connManager.connect();
				String str = "insert into RESERVA values ("+reserva.getId()+",'"+formattedDataRecogida+"','"+formattedDataEntrega+"','"+reserva.getModalidadAlquiler()+"','"+reserva.getNombreCategoria()+"','"+reserva.getDniCliente()+"',"+reserva.getIdSucursalRecogida()+","+reserva.getIdSucursalDevolucion()+")";
				connManager.updateDB(str);
				connManager.close();

		}
		catch(Exception e) {
			throw new DAOExcepcion(e);
		}
	}



	public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		// TODO Auto-generated method stub
				try{
					connManager.connect();
					ResultSet rs=connManager.queryDB("select * from RESERVA");
					connManager.close();

					List<ReservaDTO> listaresDTO = new ArrayList<ReservaDTO>();

					try{
						while (rs.next()){

							ReservaDTO resDTO = new ReservaDTO(
									rs.getInt("ID"),
									LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),rs.getTime("FECHARECOGIDA").toLocalTime()),
									LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),rs.getTime("FECHADEVOLUCION").toLocalTime()),
									rs.getString("MODALIDADALQUILER"),
									rs.getString("CATEGORIA"),
									rs.getString("CLIENTEREALIZA"),
									rs.getInt("SUCURSALRECOGIDA"),
									rs.getInt("SUCURSALDEVOLUCION"));
						listaresDTO.add(resDTO);
						}
						return listaresDTO;
					}
					catch (Exception e){	throw new DAOExcepcion(e);}
				}
				catch (SQLException e){	throw new DAOExcepcion(e);}
				catch (DAOExcepcion e){		throw e;}
	}


	@Override
	public List<ReservaDTO> obtenerReservasSinEntrega() throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA WHERE ID NOT IN(SELECT E.id FROM ENTREGA E)");
			connManager.close();

			List<ReservaDTO> listaresDTO = new ArrayList<ReservaDTO>();

			try{
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),rs.getTime("FECHARECOGIDA").toLocalTime()),
							LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),rs.getTime("FECHADEVOLUCION").toLocalTime()),
							rs.getString("MODALIDADALQUILER"),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
				listaresDTO.add(resDTO);
				}
				return listaresDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}
	}
}
