package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	 public void crearEntrega(EntregasDTO entrega) throws DAOExcepcion {
		  // TODO Auto-generated method stub
		  try {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		    int id = entrega.getId();
		    LocalDateTime dateTime1 = entrega.getFechaE();
		    String formattedDataRecogida=dateTime1.format(formatter);
		    String seguro = entrega.getTipoSeguro();
		    Double kms = entrega.getKms();
		    Double combustible = entrega.getCombustible();
		    String cocheAsignado = entrega.getCocheAsignado();
		    String empleadoRealiza = entrega.getEmpleadoRealiza();
		    connManager.connect();
		    String str = "INSERT INTO ENTREGA VALUES ("+id+",'"+formattedDataRecogida+"','"+seguro+"',"+kms+","+combustible+",'"+cocheAsignado+"','"+empleadoRealiza+"')";
		    connManager.updateDB(str);
		    connManager.close();

		  }
		  catch(Exception e) {
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
								LocalDateTime.of(rs.getDate("FECHAE").toLocalDate(), rs.getTime("FECHAE").toLocalTime()),
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