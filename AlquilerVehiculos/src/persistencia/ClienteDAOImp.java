package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			
				if (rs.next())
					return new ClienteDTO(
								rs.getString("DNI"),
								rs.getString("NOMBREYAPELLIDOS"),
								rs.getString("DIRECCION"),
								rs.getString("POBLACION"),
								rs.getString("CODPOS"),
								rs.getDate("FECHACARNETCONDUCIR"),
								rs.getString("DIGITOS"),
								rs.getInt("MES"),
								rs.getInt("AÑO"),
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
		 				+ "				POBLACION, CODIGOPOSTAL,FECHA,DIGITOS,MES,AÑO"
		 				+ "					CVC,TIPO) values('"+cliente.getDni()+","+cliente.getNombreyApellidos()+","+
		 										cliente.getDireccion()+","+cliente.getCodPostal()+","+cliente.getFechaCanetConducir()+","+
		 										cliente.getDigitosTC()+","+cliente.getMesTC()+","+cliente.getAnyoTC()+","+cliente.getCvcTC()+
		 										","+cliente.getTipoTC()+")");
		 		connManager.close();
			 	}
		 	catch (Exception e){	throw new DAOExcepcion(e);}
		  
		 
		 
		 
	 }
}
