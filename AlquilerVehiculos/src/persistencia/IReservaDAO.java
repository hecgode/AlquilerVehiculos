//IReservaDAO
package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.util.List;

import persistencia.dto.ReservaDTO;
import excepciones.*;

public interface IReservaDAO {
 public ReservaDTO buscarReserva(int identificador)throws DAOExcepcion;

 public List <ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion;

 public void crearReserva(ReservaDTO reserva) throws DAOExcepcion;
 public List<ReservaDTO> obtenerReservas() throws DAOExcepcion;

}
