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

	public List<CochesDispDTO> ObtenerCochesDisponibles(int sucursal, String categoria) throws DAOExcepcion {
		  try{
		   int intentos = 1;
		   List <CochesDispDTO> listaCoches = new ArrayList<CochesDispDTO>();
		   while(listaCoches.isEmpty() == true && intentos <5)
		   {
		   connManager.connect();
		   ResultSet rs = connManager.queryDB("SELECT * FROM COCHE WHERE SUCURSAL ="+sucursal);
		   System.out.println("HASTA AQUÃ  BIEN");
		   if(rs.wasNull())
		    System.out.println("Consulta vacÃ­a");
		   connManager.close();

		     if(intentos != 1)
		     {
		      switch(categoria)
		      {
		       case "economy":categoria = "sedán";break;
		       case "sedán":categoria = "luxury";break;
		       default:intentos = 5;break;
		      }
		     }
		    try {

		     while (rs.next()) {

		      if(rs.getString("CATEGORIA") == categoria) {
		       CochesDispDTO coche = new CochesDispDTO(
		         rs.getString("MATRICULA"),
		         rs.getDouble("KMSACTUALES"),
		         rs.getInt("SUCURSAL"),
		         rs.getString("CATEGORIA"),
		         rs.getString("NOMBRE"));


		       listaCoches.add(coche);
		      }

		     }
		    } catch (Exception e) { throw new DAOExcepcion(e);}
		    intentos++;
		    }

		      return listaCoches;

		  } catch (SQLException e) { throw new DAOExcepcion(e);}
		       catch (DAOExcepcion e) { throw e;}

		 }
}