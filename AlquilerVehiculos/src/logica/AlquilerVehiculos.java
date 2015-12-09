package logica;

import java.time.LocalDateTime;
import java.util.*;
import excepciones.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import persistencia.DAL;
import persistencia.dto.*;


public class AlquilerVehiculos {

	    private List<Cliente> mCliente = new ArrayList<Cliente>();
	    private List<Reserva> mReserva= new ArrayList<Reserva>();
	    private List<Categoria> mCategoria = new ArrayList <Categoria>();
	    private List<Reserva> mReserva2 = new ArrayList<Reserva>();
	    private ArrayList<Coche> mCoche = new ArrayList<Coche>();
	    private ArrayList<Sucursal> mSucursal = new ArrayList <Sucursal>();
		private DAL dal;
		private static AlquilerVehiculos Alquiler;
		private int id = 0;


		private int sucursal = 0;

		private String categoria = "";

		private LocalDateTime fechaE = null;
		private LocalDateTime fechaD = null;
		private String matricula = "";

		private int numSucursal = 0;

		 public int getCocheNumScurusal(){return numSucursal;}
		 public void SetCocheNumSucursal(int suc){numSucursal = suc;}

		 public int getCocheId(){return id;}
		 public void SetCocheId(int ident){id = ident;}

		 public void crearEntrega(Entrega res) {
			   EntregasDTO entregaDTO = new EntregasDTO(res.getId(),res.getFecha(),res.getSeguro(),res.getKm(),res.getCombustible(),res.getCocheAsignado(),res.getEmpleadoRealiza());
			   dal.creaEntrega(entregaDTO);
		}


		 public LocalDateTime getCocheFechaE() {
		     return fechaE;
		 }

		  public void setCocheFechaE(LocalDateTime fecha) {
		    fechaE = fecha;
		  }

		  public LocalDateTime getCocheFechaD() {
		      return fechaD;
		   }

		  public void setCocheFechaD(LocalDateTime fecha) {
		    fechaD = fecha;
		  }

		  public String getCocheMatricula()
		  {
		   return matricula;
		  }

		  public void setCocheMatricula(String matr) {
		   matricula = matr;
		  }

		public int getCocheSucursal() {
		   return sucursal;
		}

		public void setCocheSucursal(int sucur) {
			sucursal = sucur;
		}

		public String getCocheCategoria() {
		   return categoria;
		}

		public void setCocheCategoria(String cat) {
		   categoria = cat;
		}

		public AlquilerVehiculos()  throws DAOExcepcion {

	    this.dal = DAL.dameDAL();
	    CargarSistema();
		}

	  void CargarSistema() throws DAOExcepcion
	  {
		cargaCategorias();
		cargaSucursales();
		cargarReservasporSucursal();
	  }
	  /*****************METODOS DE RESERVAS*******************************************************************************************
	   * **************************************************************************************/

	  public void cargarReservasporSucursal() throws DAOExcepcion {
		  List<ReservaDTO> listaresdto = dal.dameDAL().obtenerReservas();
		  for (ReservaDTO sucDTO : listaresdto) {
			  anyadirReserva(new Reserva(sucDTO.getId(),sucDTO.getFechaRecogida(),sucDTO.getFechaDevolucion(),sucDTO.getModalidadAlquiler(),sucDTO.getDniCliente(),sucDTO.getNombreCategoria(),sucDTO.getIdSucursalRecogida(),sucDTO.getIdSucursalDevolucion()));
		  }
	  }

	  public List<Reserva> obtenerCochesSinReserva() throws DAOExcepcion {
		  mReserva2.clear();
	      List<ReservaDTO> lista = dal.dameDAL().obtenerReservasSinEntrega();
	      for(ReservaDTO sucDTO : lista) {
	    	anyadirCocheSinReserva(new Reserva(sucDTO.getId(),sucDTO.getFechaRecogida(),sucDTO.getFechaDevolucion(),sucDTO.getModalidadAlquiler(),sucDTO.getDniCliente(),sucDTO.getNombreCategoria(),sucDTO.getIdSucursalRecogida(),sucDTO.getIdSucursalDevolucion()));
	      }
	      return mReserva2;
	  }

	  private void anyadirCocheSinReserva(Reserva reserva) {
		  mReserva2.add(reserva);
	  }

	  public void crearReserva(Reserva res) {
			ReservaDTO resvaDTO = new ReservaDTO(res.getId(),res.getFechaRecogida(),res.getFechaDevolucion(),res.getModalidadAlquiler(),
					res.getDniCliente(), res.getNombreCategoria(),res.getIdSucursalDevolucion(),res.getIdSucursalRecogida());

			anyadirReserva(res);
			dal.CrearReserva(resvaDTO);

	  }

	  public List<Coche> obtenerCochesDisp(int sucursal,String categoria) throws DAOExcepcion {
		  mCoche.clear();
	      List<CochesDispDTO> lista = dal.dameDAL().obtenerCochesDisp(sucursal, categoria);
	      for(CochesDispDTO coDTO : lista) {
	    	  int km = (int) coDTO.getKm();
	    	anyadirCocheSinReserva(new Coche(coDTO.getMatricula(),km,coDTO.getCategoria()));
	      }
	      return mCoche;
	  }

	  public List<Coche> obtenerCochesDisp(int sucursal) throws DAOExcepcion {
		  mCoche.clear();
	      List<CochesDispDTO> lista = dal.dameDAL().obtenerCochesDisp(sucursal);
	      for(CochesDispDTO coDTO : lista) {
	    	  int km = (int) coDTO.getKm();
	    	anyadirCocheSinReserva(new Coche(coDTO.getMatricula(),km,coDTO.getCategoria()));
	      }
	      return mCoche;
	  }

	  private void anyadirCocheSinReserva(Coche coche) {
		  mCoche.add(coche);
	  }


	  public List<Reserva> listarReservas2() {
		  return mReserva;
	  }

	  public List<Reserva> listarReservas(int identificador) {

		  int recogida = 0;
	      List<Reserva> lista = new ArrayList<Reserva>();
	      for (int i=0 ; i<mReserva.size();i++){
	    	   recogida = mReserva.get(i).getIdSucursalRecogida();


			if ( mReserva.get(i).getIdSucursalRecogida()==identificador)
	              lista.add(mReserva.get(i));
	      }


	      return lista;
	  }


	  private void anyadirReserva(Reserva reserva) {
		  mReserva.add(reserva);
	  }

	/*****************METODOS DE CATEGORIAS*******************************************************************************************
	 * **************************************************************************************/


	  private void cargaCategorias() {

		  List<CategoriaDTO> listacatdto = dal.obtenerCategorias();
		  for (CategoriaDTO catDTO : listacatdto) {
			  anyadirCategoria(new Categoria(catDTO.getNombre(), catDTO.getPrecioModIlimitada(), catDTO.getPrecioModKms(),
					  catDTO.getPrecioSeguroTRiesgo(), catDTO.getPrecioSeguroTerceros(),catDTO.getNombreCategoriaSuperior(), catDTO.getPrecioKMModKms()));
		  }
		  for (CategoriaDTO catDTO : listacatdto)
			  if (catDTO.getNombreCategoriaSuperior() != null);

	  }

	  public List<Categoria> listarCategoria()  throws LogicaExcepcion
	  {
		  return new ArrayList<>(mCategoria);
	  }

	  public List<Coche> listarCoches()  throws LogicaExcepcion
	  {
		  return new ArrayList<>(mCoche);
	  }


	  public String buscarCategoria(String nombreCategoriaSuperior) {
		  Categoria cat = null;
		  boolean encontrado=false;
		  for (int i=0;i<mCategoria.size() && !encontrado;i++  )
		  {
			  if(mCategoria.get(i).getNombre().equals(nombreCategoriaSuperior)){
				  encontrado=true;
				  cat=mCategoria.get(i);

			  }
		  }
		  return cat.toString();
	  }


		  public String buscarCat(String nombreCategoriaSuperior) {
			   CategoriaDTO aux= dal.buscarCategoria(nombreCategoriaSuperior);

				List<String> lista = new ArrayList<String>();
				lista.add(String.valueOf("\tIlimitada: "+aux.getPrecioModIlimitada()+"€\n"));
				lista.add(String.valueOf("\tModKms: "+aux.getPrecioModKms())+"€\n");
				lista.add(String.valueOf("\tSeguro: "+aux.getPrecioSeguroTRiesgo())+"€\n");
				lista.add(String.valueOf("\tSeguro terceros: "+aux.getPrecioSeguroTerceros())+"€\n");
				lista.add(String.valueOf("\tKMModKms: "+aux.getPrecioKMModKms())+"€\n");

				return lista.toString();

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

		  List<SucursalDTO> listasucdto = dal.obtenerSucursales();
		  for (SucursalDTO sucDTO : listasucdto) {
			  anyadirSucursal(new Sucursal(sucDTO.getId(),sucDTO.getDireccion()));

		  }
	  }

	  public void crearSucursal(Sucursal suc) {

		SucursalDTO sucdto= new SucursalDTO(suc.getIdentificador(),suc.getDireccion());

		anyadirSucursal(suc);
		dal.CrearSucursal(sucdto);


	  }

	  public void anyadirSucursal(Sucursal suc){
		  mSucursal.add(suc);
	  }

	  public boolean buscarSucursal(int id) {

		  boolean encontrado=false;
		  for (int i=0;i<mSucursal.size() && !encontrado;i++  ) {
			  if(mSucursal.get(i).getIdentificador()==id)
				  encontrado=true;
		  }
		  return encontrado;
	  }

	  public List<Sucursal> listarSucursales()  throws LogicaExcepcion {
		return new ArrayList<>(mSucursal);
	  }


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


	  public boolean buscar_cliente (String dni) {
		  ClienteDTO c = dal.buscarCliente(dni);
		  if (c==null)
			  return false;
		  else return true;

	  }

	  public boolean buscaClientes(String dni) throws DAOExcepcion {

		 ClienteDTO CLI = dal.buscarCliente(dni);
		 if (CLI==null)
			 return false;
			 else return true;

	  }

	  public void AnyadirCliente(Cliente cliente) {
		  mCliente.add(cliente);
	  }


	  public List<Cliente> listarClientes()  throws LogicaExcepcion {
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

	  //Patron Singleton
	  public static AlquilerVehiculos dameAlquiler() throws DAOExcepcion{
	  		if(Alquiler==null)
	  			Alquiler=new AlquilerVehiculos();
	  		return Alquiler;
	  }

	  public static void createAlert(String title, AlertType alertType, String text) throws DAOExcepcion {
			Alert alert = new Alert(alertType);
			alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(text);
			alert.showAndWait();
	}

}





