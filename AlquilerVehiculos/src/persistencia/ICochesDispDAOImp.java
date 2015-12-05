package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.CochesDispDTO;

public class ICochesDispDAOImp implements ICochesDispDAO {


	protected ConnectionManager connManager;

	public ICochesDispDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	@Override
	public List<CochesDispDTO> ObtenerCochesDisponibles(String sucursal, String categoria) throws DAOExcepcion {

		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("SELECT * FROM COCHE WHERE SUCURSAL="+sucursal+" AND CATEGORIA="+categoria);
			if(rs.wasNull())
				System.out.println("Consulta vacía");
			connManager.close();

			List <CochesDispDTO> listaCoches = new ArrayList<CochesDispDTO>();

			try {

				while (rs.next()) {

				CochesDispDTO coche = new CochesDispDTO(
								rs.getString("MATRICULA"),
								rs.getDouble("KMSACTUALES"),
								rs.getInt("SUCURSAL"),
								rs.getString("CATEGORIA"),
								rs.getString("NOMBRE"));


							listaCoches.add(coche);
				}
					return listaCoches;

			} catch (Exception e) { throw new DAOExcepcion(e);}

		} catch (SQLException e) { throw new DAOExcepcion(e);}
	      catch (DAOExcepcion e) { throw e;}

	}
}