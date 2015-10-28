package logica;

public class TestCapaLogica {


	public  static void main () {
		AlquilerVehiculos alquiler = new AlquilerVehiculos();
		

			Reserva reserva1 =new Reserva(1,"12/05/06","12/07/2016","1",cli1,cat1,suc1,suc1);
			

			Reserva reserva2 =new Reserva (2,"13/05/06","25/07/2016",21,cli2,cat2,suc1,suc2);
			Cliente cli1= new Cliente(111, "Luis", "", "5678", 46018, "14/5/1989", 0, 0, 0, 0, "vISA");

			alquiler.AñadirCliente(cli1);
			alquiler.AñadirCliente(cli2);
			reserva1.setEntrega(null);
			reserva2.setEntrega(null);








	}

}
