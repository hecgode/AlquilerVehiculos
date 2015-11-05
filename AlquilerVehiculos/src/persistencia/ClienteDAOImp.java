package persistencia;
/*AlquilerVehiculos*/
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDateTime;

import excepciones.DAOExcepcion;
import persistencia.dto.ClienteDTO;
import java.sql.Date;
public class ClienteDAOImp implements IClienteDAO {


	protected ConnectionManager connManager;

	public ClienteDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	 public ClienteDTO buscarCliente(String dni)throws DAOExcepcion {

		 			try{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI= '"+dni+"'");
				connManager.close();
				LocalDateTime dateTime = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime());



				if (rs.next())
					return new ClienteDTO(
								rs.getString("DNI"),
								rs.getString("NOMBREYAPELLIDOS"),
								rs.getString("DIRECCION"),
								rs.getString("POBLACION"),
								rs.getString("CODPOS"),
								LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime()),
								rs.getString("DIGITOS"),
								rs.getInt("MES"),
								rs.getInt("ANYO"),
								rs.getInt("VCV"),
								rs.getString("TIPO"));


					return null;
			}
			catch (SQLException e){	throw new DAOExcepcion(e);}
		}



	 public void crearCliente(ClienteDTO cliente) throws DAOExcepcion
	 {
		 	try {
		 		connManager.connect();
		 		connManager.updateDB("insert into CLIENTE (DNI,NOMBREYAPELLIDOS,DIRECCION,"
		 				+ "				POBLACION, CODIGOPOSTAL,FECHA,DIGITOS,MES,A�O"
		 				+ "					CVC,TIPO) values('"+cliente.getDni()+","+cliente.getNombreyApellidos()+","+
		 										cliente.getDireccion()+","+cliente.getCodPostal()+","+cliente.getFechaCanetConducir()+","+
		 										cliente.getDigitosTC()+","+cliente.getMesTC()+","+cliente.getAnyoTC()+","+cliente.getCvcTC()+
		 										","+cliente.getTipoTC()+")");
		 		connManager.close();
			 	}
		 	catch (Exception e){	throw new DAOExcepcion(e);}




	 }
}
