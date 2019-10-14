package Entidad.Objeto.Temporal;

import Entidad.Entidad;

public class GasVenenoso extends ObjetoTemporal{

	protected final static int precio = 50;
	
	public GasVenenoso(int x, int y, int tiempo) {
		super(x, y,tiempo);
	}
	
	public static int getPrecio() {
		return precio;
	}
	
	public void afectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
