package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
				//LocalDateTime dateTime = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime());



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




public void crearCliente(ClienteDTO cliDTO) throws DAOExcepcion {
                        try{
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                LocalDateTime dateTime = cliDTO.getFechaCanetConducir();
                                String formattedDateTime=dateTime.format(formatter);
                                connManager.connect();
                                String str = "insert into CLIENTE (DNI,NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL,FECHACARNETCONDUCIR,DIGITOSTC, MESTC, \"añoTC\", CVCTC, TIPOTC) values ('"+cliDTO.getDni()+"','"+cliDTO.getNombreyApellidos()+"','"+cliDTO.getDireccion()+"','"+cliDTO.getPoblacion()+"','"+cliDTO.getCodPostal()+"','"+formattedDateTime+"','"+cliDTO.getDigitosTC()+"',"+cliDTO.getMesTC()+","+cliDTO.getAnyoTC()+","+cliDTO.getCvcTC()+",'"+cliDTO.getTipoTC()+"')";
                                connManager.updateDB(str);
                                connManager.close();
                        }
                        catch (Exception e){        throw new DAOExcepcion(e);}
                }
}
