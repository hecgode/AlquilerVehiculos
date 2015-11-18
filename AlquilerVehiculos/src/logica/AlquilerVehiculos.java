/*AlquilerVehiculos ultima modificacion 06/10/15*/

package logica;

import java.util.*;
import excepciones.*;
import persistencia.DAL;
import persistencia.dto.*;


public class AlquilerVehiculos {

    private List<Cliente> mCliente = new ArrayList<Cliente>();
    private List<Reserva> mReserva= new ArrayList<Reserva>();
    private List<Categoria> mCategoria = new ArrayList <Categoria>();
    private ArrayList<Sucursal> mSucursal = new ArrayList <Sucursal>();
	private DAL dal;
	public AlquilerVehiculos()  throws DAOExcepcion {
    	 //CargarSistema();
    	this.dal = DAL.dameDAL();
    	CargarSistema1();
	}

  void CargarSistema1() {
	cargaCategorias();
	cargaSucursales();
	//  cargaReservas();

}
  /*****************METODOS DE RESERVAS*******************************************************************************************
   * **************************************************************************************/

  private void cargaReservasporSUCURSAL() {

		// TODO Auto-generated method stub
		List<ReservaDTO> listaresdto = dal.obtenerReservasPORSUCURSAL(1);
		// Crear y a�adir todas las categorias a la colecci�n
		for (ReservaDTO sucDTO : listaresdto) {
				//anyadirReserva(new Reserva(0, null, null, null, null, null, null, null));

		}

		}



  public void crearReserva(Reserva res) {

		ReservaDTO resvaDTO = new ReservaDTO(res.getId(),res.getFechaDevolucion(),res.getFechaDevolucion(),res.getModalidadAlquiler(),
				res.getDniCliente(),res.getNombreCategoria(),res.getIdSucursalDevolucion(),res.getIdSucursalRecogida());

		anyadirReserva(res);
		dal.CrearReserva(resvaDTO);


	}


  public List<Reserva> listarReservas(String sucursal) {
      Sucursal suc = null;
      List<Reserva> lista = null;
      for (int i=0 ; i<mSucursal.size();i++)
          if ( mSucursal.get(i).getDireccion().equals(sucursal))
              suc = mSucursal.get(i);

      if (suc != null)
          lista = suc.listarReserva();
      	return lista;

  }



private void anyadirReserva(Reserva reserva) {
	mReserva.add(reserva);

}


public boolean eliminar_Reserva(int id){
	return mReserva.remove(consultar_Reservas(id));
}


public Reserva consultar_Reservas(int id) {
	Reserva cat = null;
	boolean encontrado=false;
	for (int i=0;i<mReserva.size() && !encontrado;i++  )
	{
		if(mReserva.get(i).getId()==id)
			encontrado=true;
			cat=mReserva.get(i);

		}	return cat;


	}





/*****************METODOS DE CATEGORIAS*******************************************************************************************
 * **************************************************************************************/


private void cargaCategorias() {

	List<CategoriaDTO> listacatdto = dal.obtenerCategorias();
	// Crear y a�adir todas las categorias a la colecci�n
	for (CategoriaDTO catDTO : listacatdto) {
	anyadirCategoria(new Categoria(catDTO.getNombre(), catDTO.getPrecioModIlimitada(), catDTO.getPrecioModKms(),
	catDTO.getPrecioKMModKms(), catDTO.getPrecioSeguroTRiesgo(), catDTO.getPrecioSeguroTerceros(),catDTO.getNombreCategoriaSuperior()));
	}
	// Actualizar los enlaces que representan la relaci�n �superior�
	for (CategoriaDTO catDTO : listacatdto)
		if (catDTO.getNombreCategoriaSuperior() != null)
		buscarCategoria(catDTO.getNombre()).setCatsup2(buscarCategoria(catDTO.getNombreCategoriaSuperior()));
		}



public Categoria buscarCategoria(String nombreCategoriaSuperior) {
	Categoria cat = null;
	boolean encontrado=false;
	for (int i=0;i<mCategoria.size() && !encontrado;i++  )
	{
		if(mCategoria.get(i).getNombre().equals(nombreCategoriaSuperior)){
			encontrado=true;
			cat=mCategoria.get(i);

		}
	}
	return cat;

}


public void anyadirCategoria(Categoria cat) {
	mCategoria.add(cat);

}



public boolean eliminar_Categoria(String id){
	return mCategoria.remove(buscarCategoria(id));
			}





  /*****************METODOS DE SUCURSALES*******************************************************************************************
   * **************************************************************************************/

private void cargaSucursales() {
	// TODO Auto-generated method stub
	List<SucursalDTO> listasucdto = dal.obtenerSucursales();
	// Crear y a�adir todas las categorias a la colecci�n
	for (SucursalDTO sucDTO : listasucdto) {
			anyadirSucursal(new Sucursal(sucDTO.getId(),sucDTO.getDireccion()));

	}}




public void crearSucursal(Sucursal suc) {

	SucursalDTO sucdto= new SucursalDTO(suc.getIdentificador(),suc.getDireccion());
	anyadirSucursal(suc);
	dal.CrearSucursal(sucdto);


}


public void anyadirSucursal(Sucursal suc){
	mSucursal.add(suc);
}


public Sucursal consultar_Sucursal1(int id){
	for(Sucursal sucursal: mSucursal)
		if(sucursal.getIdentificador()==id)
			return sucursal;
	return null;
}


public boolean eliminar_Sucursal(int id){
	return mSucursal.remove(consultar_Sucursal1(id));
}

public Sucursal buscarSucursal(int identificador) {


	Sucursal suc = null;
	boolean encontrado=false;
	for (int i=0;i<mSucursal.size() && !encontrado;i++  )
	{
		if(mSucursal.get(i).getIdentificador()==identificador)
		{
				encontrado=true;
			suc=mSucursal.get(i);

		}
	}
	return suc;

}



public List<Sucursal> listarSucursales()  throws LogicaExcepcion
{

	return new ArrayList<>(mSucursal); }


/*****************METODOS DE CLIENTES*******************************************************************************************
 * **************************************************************************************/


public void crearCliente(Cliente cliente) {

	ClienteDTO clienteDTO = new ClienteDTO(cliente.getIdendificador(), cliente.getNombreyApellidos(),
			cliente.getDireccion(), cliente.getPoblacion(), cliente.getCodPostal(),
			cliente.getFechaCarnet(), cliente.getDigitos(), cliente.getMes(),
			cliente.getAnyo(), cliente.getCvc(), cliente.getTipo());

	AnyadirCliente(cliente);
	dal.crearCliente(clienteDTO);
}

public void AnyadirCliente(Cliente cliente) {
   mCliente.add(cliente);


}

public boolean anyadir_Cliente(Cliente cliente){
	return mCliente.add(cliente);
}



public Cliente consultar_Cliente(String id){
	for(Cliente cliente: mCliente	)
		if(cliente.getIdendificador().equals(id))
			return cliente;
	return null;
}

public List<Cliente> listarClientes()  throws LogicaExcepcion
{

	return new ArrayList<>(mCliente);
	}


/************************************************************************************************************
 * **************************************************************************************/

    public List<Cliente> getmCliente() {
        return mCliente;
    }


    public List<Reserva> getmReserva() {
		return mReserva;
	}

	public void setmReserva(List<Reserva> mReserva) {
		this.mReserva = mReserva;
	}

	public void setmCliente(List<Cliente> mCliente) {
		this.mCliente = mCliente;
	}

	public void setmCategoria(List<Categoria> mCategoria) {
		this.mCategoria = mCategoria;
	}

	public void setmReserva(ArrayList<Reserva> mReserva) {
        this.mReserva = mReserva;
    }

    public List<Categoria> getmCategoria() {
        return mCategoria;
    }

    public void setmCategoria(ArrayList<Categoria> mCategoria) {
        this.mCategoria = mCategoria;
    }

    public List<Sucursal> getmSucursal() {
        return mSucursal;
    }

    public void setmSucursal(ArrayList<Sucursal> mSucursal) {
        this.mSucursal = mSucursal;
    }




}





