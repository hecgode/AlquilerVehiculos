//IClienteDAO
package persistencia;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
import persistencia.dto.ClienteDTO;

import java.util.List;

import excepciones.*;

public interface IClienteDAO {
 public ClienteDTO buscarCliente(String dni)throws DAOExcepcion;

 public void crearCliente(ClienteDTO cliente) throws DAOExcepcion;




 public List<ClienteDTO> obTenerClientes()throws DAOExcepcion ;
}
