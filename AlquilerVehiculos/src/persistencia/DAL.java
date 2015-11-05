package persistencia;
import java.util.List;

import excepciones.*;
import persistencia.dto.*;
/*AlquilerVehiculos*/
public class DAL {
	private static DAL dal;
	ISucursalDAO sucursaldao;
	IReservaDAO reservadao;
	IClienteDAO clientedao;
	ICategoriaDAO catDAO;

private DAL() throws DAOExcepcion{
		catDAO = new CategoriaDAOImp();
		clientedao = new ClienteDAOImp();
		sucursaldao = new SucursalDAOImp();

	}


	public List<CategoriaDTO> obtenerCategorias() {
		try {
		return catDAO.obtenerCategorias();
		} catch (DAOExcepcion e) {
		return null;
		}


	}


	public List<SucursalDTO> obtenerSucursales() {
		try {
			return sucursaldao.obtenerSucursales();

		} catch (DAOExcepcion e) {
			return null;
			}



	}

	//Patron Singleton
		public static DAL dameDAL() throws DAOExcepcion{
			if(dal==null)
				dal=new DAL();
			return dal;
		}

}

