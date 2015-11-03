package logica;

//import excepciones.DAOExcepcion;

public class TestCapaLogica {


	public  static void main (String[] args) /*throws DAOExcepcion*/ {
		AlquilerVehiculos alquiler = new AlquilerVehiculos();
		Cliente cli1= new Cliente(111, "Luis", "", "5678", 46018, "14/5/1989", 0, 0, 0, 0, "vISA");
		Cliente cli2= new Cliente(1234, "Hrctpr", "", "5678", 46018, "14/5/1989", 0, 0, 0, 0, "vISA");


		Categoria cat1 = null;
		Categoria cat2 = null;
		Sucursal suc1 = null;
		Sucursal suc2 = null;
		Reserva reserva1 =new Reserva(1,"12/05/06","12/07/2016","1",cli1,cat1,suc1,suc1);


		Reserva reserva2 =new Reserva(2,"13/05/06","25/07/2016","21",cli2,cat2,suc1,suc2);

			alquiler.AnyadirCliente(cli1);
			alquiler.AnyadirCliente(cli2);
			reserva1.setEntrega(null);
			reserva2.setEntrega(null);








	}

}
