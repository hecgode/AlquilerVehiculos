package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.SucursalDTO;

public class SucursalDAOImp implements ISucursalDAO {
	protected ConnectionManager connManager;


	public SucursalDAOImp() throws DAOExcepcion {
		super();
		try{
			connManager= new ConnectionManager("alquilervehiculosBD");
			}
			catch (ClassNotFoundException e){
				throw new DAOExcepcion(e);
				}
		}

	public List<SucursalDTO> obtenerSucursales() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from SUCURSAL");
			connManager.close();

			List<SucursalDTO> listasucDTO = new ArrayList<SucursalDTO>();

			try{
				while (rs.next()){

					SucursalDTO sucDTO = new SucursalDTO(
							rs.getInt("ID"),
							rs.getString("DIRECCION")			);
				listasucDTO.add(sucDTO);
				}
				return listasucDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}

	}








		// TODO Auto-generated method stub
		//return null;
	}


