package Entidad.Objeto.Temporal;

public class Portal extends ObjetoTemporal{

	protected final static int precio = 100;
	
	public Portal(int x, int y) {
		super(x, y);
	}
	
	public static int getPrecio() {
		return precio;
	}

}
