package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.*;

public interface ICochesDispDAO {


	 public List<CochesDispDTO> ObtenerCochesDisponibles(int sucursal, String categoria)throws DAOExcepcion ;
	 public List<CochesDispDTO> ObtenerCochesDisponibles(int sucursal)throws DAOExcepcion ;

}