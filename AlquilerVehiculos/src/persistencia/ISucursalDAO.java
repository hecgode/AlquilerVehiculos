//ISucursalDAO
package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.*;

public interface ISucursalDAO {
 public List <SucursalDTO> obtenerSucursales() throws DAOExcepcion;
 public void crearSucursal(SucursalDTO suc) throws DAOExcepcion ;
}
