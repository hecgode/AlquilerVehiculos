package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.*;

public interface ICocheDAO {


	 public List<CocheDTO> obTenerCoches(int suc)throws DAOExcepcion ;

}
