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

	public List<CochesDispDTO> ObtenerCochesDisponibles(int sucursal) throws DAOExcepcion {
		List <CochesDispDTO> listaCoches = new ArrayList<CochesDispDTO>();
		  try{
		   connManager.connect();
		   ResultSet rs = connManager.queryDB("SELECT * FROM COCHE WHERE SUCURSAL ="+sucursal);
		   if(rs.wasNull())
			   connManager.close();
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
		    } catch (Exception e) { throw new DAOExcepcion(e);}


		      return listaCoches;

		  } catch (SQLException e) { throw new DAOExcepcion(e);}
		       catch (DAOExcepcion e) { throw e;}

		 }

	public List<CochesDispDTO> ObtenerCochesDisponibles(int sucursal, String categoria) throws DAOExcepcion {
		  try{
		   int intentos = 1;
		   List <CochesDispDTO> listaCoches = new ArrayList<CochesDispDTO>();
		   while(listaCoches.isEmpty() == true && intentos <5)
		   {
		   connManager.connect();
		   ResultSet rs = connManager.queryDB("SELECT * FROM COCHE C WHERE C.SUCURSAL ="+sucursal+" AND C.MATRICULA NOT IN(SELECT E.COCHEASIGNADO FROM ENTREGA E WHERE C.MATRICULA = E.COCHEASIGNADO)");
		   if(rs.wasNull())
		   connManager.close();

		     if(intentos != 1)
		     {
		      switch(categoria)
		      {
		       case "economy":categoria = "sed\u00e1n";break;
		       case "sed\u00e1n":categoria = "luxury";break;
		       default:intentos = 5;break;
		      }
		     }
		    try {

		     while (rs.next()) {
		    	System.out.print(rs.getString("NOMBRE"));

		      if(rs.getString("NOMBRE").equals(categoria)) {
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