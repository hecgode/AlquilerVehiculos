package logica;

import java.util.*;
import excepciones.*;
import persistencia.DAL;
import persistencia.dto.*;


public class AlquilerVehiculos {

    private List<Cliente> mCliente = new ArrayList<Cliente>();
    private List<Reserva> mReserva= new ArrayList<Reserva>();
    private List<Categoria> mCategoria = new ArrayList <Categoria>();
    private List<Sucursal> mSucursal = new ArrayList <Sucursal>();
	private DAL dal;






    public AlquilerVehiculos() /* throws DAOExcepcion */{
    	 CargarSistema();

    	/*this.dal = DAL.dameDAL();
    	CargarSistema1();*/
	}

/*

private void CargarSistema1() {
	cargaCategorias1();

}9*/
/*
private void cargaCategorias1() {

	List<CategoriaDTO> listacatdto = dal.obtenerCategorias();
	// Crear y a�adir todas las categorias a la colecci�n
	for (CategoriaDTO catDTO : listacatdto) {
	anyadirCategoria(new Categoria(catDTO.getNombre(), catDTO.getPrecioModIlimitada(), catDTO.getPrecioModKms(),
	catDTO.getPrecioKMModKms(), catDTO.getPrecioSeguroTRiesgo(), catDTO.getPrecioSeguroTerceros()));
	}
	// Actualizar los enlaces que representan la relaci�n �superior�

	for (CategoriaDTO catDTO : listacatdto)
		if (catDTO.getNombreCategoriaSuperior() != null)
		buscarCategoria(catDTO.getNombre()). setSuperior(buscarCategoria(catDTO.getNombreCategoriaSuperior()));
		}

*/
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


    public void AnyadirCliente(Cliente cliente) {
       mCliente.add(cliente);
    }

    public void anyadirCategoria(Categoria cat) {
    	mCategoria.add(cat);

    }


    public void creaReserva (int identificador, String fechar, String fechad , int idSucursalr, int idSucursald,String nombreCategoria, String mAlquiler )
    {
    	boolean sucursal1 = false;
    	boolean sucursal2 = false;

    	Cliente cliente = mCliente.get(0);
    	Categoria categoria = mCategoria.get(0);
    	Sucursal sucursalr = mSucursal.get(0);
    	Sucursal sucursald = mSucursal.get(0);
    for (int i=0 ; i<mCliente.size();i++)
    {
    	if (mCliente.get(i).getIdendificador()==identificador)
    		{cliente=mCliente.get(i);break;}
    }
    for (int i=0 ; i<mCategoria.size();i++)
    {
    	if (mCategoria.get(i).getNombre()==nombreCategoria)
    		{categoria=mCategoria.get(i);break;}
    }
    for (int i=0 ; i<mSucursal.size();i++)
    {
    	if (mSucursal.get(i).getIdentificador()==idSucursalr)
    		{sucursalr=mSucursal.get(i);sucursal1=true;}
    	if (mSucursal.get(i).getIdentificador()==idSucursald)
    		{sucursald=mSucursal.get(i);sucursal2=true;}
    	if(sucursal1 ==true && sucursal2 == true){break;}
    }



	Reserva reserva = new Reserva(identificador, fechar,fechad, nombreCategoria,cliente,categoria,sucursalr,sucursald);
    }





    public List<Cliente> getmCliente() {
        return mCliente;
    }

    public void setmCliente(ArrayList<Cliente> mCliente) {
        this.mCliente = mCliente;
    }

    public List<Reserva> getmReserva() {
        return mReserva;
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

    private void CargarSistema()  {
    	Sucursal suc1 = new Sucursal(1, "Camino");
    	Sucursal suc2 = new Sucursal (2, "Archiduque");
    	mSucursal.add(suc1);
    	mSucursal.add(suc2);
    	Categoria cat1 = new Categoria ("sedan",45,23,0.75,55.25,43.23);
    	Categoria cat2 = new Categoria ("economty",48,27,0.85,75.25,55.23);
    	mCategoria.add(cat1);
    	mCategoria.add(cat2);
    	cat2.setCatsup(cat1);
    	cat1.setCatsup(null);
    	cat1.setCoches(null);
    	cat2.setCoches(null);
    	mCategoria.add(cat1);
    	mCategoria.add(cat2);


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
	


}









