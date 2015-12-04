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
	ICocheDAO cocheDAO;

private DAL() throws DAOExcepcion{
		catDAO = new CategoriaDAOImp();
		clientedao = new ClienteDAOImp();
		sucursaldao = new SucursalDAOImp();
		reservadao = new ReservaDAOImp();
		cocheDAO = new CocheDAOImp();

	}



public List<CocheDTO> listarCoches (int suc) throws DAOExcepcion {
	try {
		return  cocheDAO.obTenerCoches(suc);
		} catch (DAOExcepcion e) {
			return null;
		}
}

public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
	try {
		return  clientedao.obTenerClientes();
		} catch (DAOExcepcion e) {
			return null;
		}
}

public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
	try {
		return reservadao.obtenerReservas();
		} catch (DAOExcepcion e) {
			return null;
		}
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

	public List<ReservaDTO> obtenerReservasPORSUCURSAL(int iden) {
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

public void CrearSucursal (SucursalDTO suc)

{
	try {
		sucursaldao.crearSucursal(suc);
	} catch (DAOExcepcion e) {

		}


}

public ClienteDTO buscarCliente(String dni)
{
	ClienteDTO cl = null;
	try {
		cl = clientedao.buscarCliente(dni);
		} catch (DAOExcepcion e) {

		}
	return cl;


}



public CategoriaDTO buscarCategoria(String nombre)
{
	CategoriaDTO cl = null;
	try {
		cl = catDAO.buscarCategoria(nombre);
		} catch (DAOExcepcion e) {

		}
	return cl;
}



	//Patron Singleton
		public static DAL dameDAL() throws DAOExcepcion{
			if(dal==null)
				dal=new DAL();
			return dal;
		}

}

