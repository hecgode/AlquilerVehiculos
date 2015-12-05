package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregasDTO;

public class IEntregasDAOImp implements IEntregasDAO {


	protected ConnectionManager connManager;

	public IEntregasDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	@Override
	public List<EntregasDTO> ObtenerEntregas() throws DAOExcepcion {

		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from ENTREGA");
			connManager.close();

			List <EntregasDTO> listaEntregas = new ArrayList<EntregasDTO>();

			try {

				while (rs.next()) {

				EntregasDTO entrega = new EntregasDTO(
								rs.getInt("ID"),
								LocalDateTime.of(rs.getDate("FECHA").toLocalDate(), rs.getTime("FECHA").toLocalTime()),
								rs.getString("TIPOSEGURO"),
								rs.getDouble("KMS"),
								rs.getDouble("COMBUSTIBLE"),
								rs.getString("COCHEASIGNADO"),
								rs.getString("EMPLEADOREALIZA"));


							listaEntregas.add(entrega);
				}
					return listaEntregas;

			} catch (Exception e) { throw new DAOExcepcion(e);}

		} catch (SQLException e) { throw new DAOExcepcion(e);}
	      catch (DAOExcepcion e) { throw e;}

	}
}