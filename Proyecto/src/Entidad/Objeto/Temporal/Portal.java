package Entidad.Objeto.Temporal;

import Entidad.Entidad;

public class Portal extends ObjetoTemporal{

	protected final static int precio = 100;
	
	public Portal(int x, int y,int tiempo) {
		super(x, y,tiempo);
	}
	
	public static int getPrecio() {
		return precio;
	}

	@Override
	public void afectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
