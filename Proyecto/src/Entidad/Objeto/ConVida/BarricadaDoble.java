package Entidad.Objeto.ConVida;

public class BarricadaDoble extends ObjetoConVida {

	protected final static int precio = 60;
	
	public BarricadaDoble(int x, int y,int vida, int precio) {
		super(x, y,vida);
	}

	public static int getPrecio() {
		return precio;
	}
	
	public int getVida() {
		return vida;
	}
}
