package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

	public ClienteDTO buscarCliente(String dni) throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI = '"+dni+"'");
			connManager.close();
			
			if(rs.next()){
				
				LocalDateTime dateTime=LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
				return new ClienteDTO(
						rs.getString("DNI"),
						rs.getString("NOMBREAPELLIDOS"),
						rs.getString("DIRECCION"),
						rs.getString("POBLACION"),
						rs.getString("CODPOSTAL"),
						dateTime,
						rs.getString("DIGITOSTC"),
						rs.getInt("MESTC"),
						rs.getInt("AÑOTC"),
						rs.getInt("CVCTC"),
						rs.getString("TIPOTC"));
			}
			else
				return null;
		}
		catch(SQLException e){throw new DAOExcepcion(e);}
		
						
			
	}



	 public List<ClienteDTO> obTenerClientes()throws DAOExcepcion {

				try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("SELECT * FROM CLIENTE");
			connManager.close();
			//LocalDateTime dateTime = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime());

			List<ClienteDTO> lic = new ArrayList<ClienteDTO>();

			while (rs.next()) {
				LocalDateTime dateTime=LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
				ClienteDTO  cl= new ClienteDTO(
						rs.getString("DNI"),
						rs.getString("NOMBREAPELLIDOS"),
						rs.getString("DIRECCION"),
						rs.getString("POBLACION"),
						rs.getString("CODPOSTAL"),
						dateTime,
						rs.getString("DIGITOSTC"),
						rs.getInt("MESTC"),
						rs.getInt("AÑOTC"),
						rs.getInt("CVCTC"),
						rs.getString("TIPOTC"));

			lic.add(cl);





			}
				return lic;
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
	}




public void crearCliente(ClienteDTO cliDTO) throws DAOExcepcion {
                        try{
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                LocalDateTime dateTime = cliDTO.getFechaCanetConducir();
                                String formattedDateTime=dateTime.format(formatter);
                                connManager.connect();
                                String str = "insert into CLIENTE (DNI,NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL,FECHACARNETCONDUCIR,DIGITOSTC, MESTC, \"a�oTC\", CVCTC, TIPOTC) values ('"+cliDTO.getDni()+"','"+cliDTO.getNombreyApellidos()+"','"+cliDTO.getDireccion()+"','"+cliDTO.getPoblacion()+"','"+cliDTO.getCodPostal()+"','"+formattedDateTime+"','"+cliDTO.getDigitosTC()+"',"+cliDTO.getMesTC()+","+cliDTO.getAnyoTC()+","+cliDTO.getCvcTC()+",'"+cliDTO.getTipoTC()+"')";
                                connManager.updateDB(str);
                                connManager.close();
                        }
                        catch (Exception e){        throw new DAOExcepcion(e);}
                }
}
