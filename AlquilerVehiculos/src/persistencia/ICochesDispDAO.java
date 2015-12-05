package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.*;

public interface ICochesDispDAO {


	 public List<CochesDispDTO> ObtenerCochesDisponibles(String sucursal, String categoria)throws DAOExcepcion ;

}