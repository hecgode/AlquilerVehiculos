package logica;

import java.util.*;
/*****************************/



public class AlquilerVehiculos {

    private List<Cliente> mCliente = new ArrayList<Cliente>();
    private List<Reserva> mReserva= new ArrayList<Reserva>();
    private List<Categoria> mCategoria = new ArrayList <Categoria>();
    private List<Sucursal> mSucursal = new ArrayList <Sucursal>();
    private String hola = "Hola mundo";

    public AlquilerVehiculos(){

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
/*

    public void creaReserva (int identificador, String fechar, String fechad  )
    {
    	Cliente cliente;
    	/buscar al cliente
    for (int i=0 ; i<mCliente.size();i++)
    	if (mCliente.get(i).getIdendificador()==identificador)
    		cliente=mCliente.get(i);
    mSucursal/


    }
*/




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







}

