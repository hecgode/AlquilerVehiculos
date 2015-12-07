package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.*;

public interface IEntregasDAO {
	 public List<EntregasDTO> ObtenerEntregas()throws DAOExcepcion;
	 public void crearEntrega(EntregasDTO entrega) throws DAOExcepcion;
}