package persistencia;
import java.util.List;

import excepciones.*;
import persistencia.dto.*;
/*AlquilerVehiculos ultima modificacion 06/10/15*/
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
		reservadao = new ReservaDAOImp();

	}


	public List<CategoriaDTO> obtenerCategorias() {
		try {
		return catDAO.obtenerCategorias();
		} catch (DAOExcepcion e) {
		return null;
		}	}


	public List<SucursalDTO> obtenerSucursales() {
		try {
			return sucursaldao.obtenerSucursales();

		} catch (DAOExcepcion e) {
			return null;			}	}

	public List<ReservaDTO> obtenerReservas(int iden) {
		try {
			return reservadao.obtenerReservasPorSucursalOrigen(iden);

		} catch (DAOExcepcion e) {
			return null;
			}	}

public void crearCliente(ClienteDTO cl)
	{
		try {
			clientedao.crearCliente(cl);
		} catch (DAOExcepcion e) {

			}
	}

public void CrearReserva (ReservaDTO res)

{
	try {
		reservadao.crearReserva(res);
	} catch (DAOExcepcion e) {

		}


}


	//Patron Singleton
		public static DAL dameDAL() throws DAOExcepcion{
			if(dal==null)
				dal=new DAL();
			return dal;
		}

}

