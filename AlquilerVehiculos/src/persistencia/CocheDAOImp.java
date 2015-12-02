package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.CocheDTO;

public class CocheDAOImp implements ICocheDAO {
	

	protected ConnectionManager connManager;

	public CocheDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	@Override
	public List<CocheDTO> obTenerCoches() throws DAOExcepcion {
		
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from COCHE");
			connManager.close();
			
			List <CocheDTO> listaC = new ArrayList<CocheDTO>();
			
			try {
				
				while (rs.next()) {
					
				CocheDTO coche = new CocheDTO(
								rs.getString("MATRICULA"),
								rs.getDouble("KM"),
								rs.getInt("MSUCURSAL"),
								rs.getString("CATEGORIA"),
								rs.getString("NOMBRE"));


							listaC.add(coche);
				}
					return listaC;
				
			} catch (Exception e) { throw new DAOExcepcion(e);}
			
		} catch (SQLException e) { throw new DAOExcepcion(e);}
	      catch (DAOExcepcion e) { throw e;}

	}
}
	
	

