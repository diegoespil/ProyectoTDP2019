package Entidad.Objeto.Temporal;

public class GasVenenoso extends ObjetoTemporal{

	protected final static int precio = 50;
	
	public GasVenenoso(int x, int y) {
		super(x, y);
	}
	
	public static int getPrecio() {
		return precio;
	}

}
