package persistencia;
import java.util.List;

import excepciones.*;
import persistencia.dto.*;

public class DAL {
	private static DAL dal;
	ISucursalDAO sucursaldao;
	IReservaDAO reservadao;
	IClienteDAO clientedao;
	ICategoriaDAO catDAO;

	public List<CategoriaDTO> obtenerCategorias() {
		try {
		return catDAO.obtenerCategorias();
		} catch (DAOExcepcion e) {
		return null;
		}


	}
}

