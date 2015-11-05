//IClienteDAO
package persistencia;
/*AlquilerVehiculos*/
import persistencia.dto.ClienteDTO;
import excepciones.*;

public interface IClienteDAO {
 public ClienteDTO buscarCliente(String dni)throws DAOExcepcion;

 public void crearCliente(ClienteDTO cliente) throws DAOExcepcion;
}
