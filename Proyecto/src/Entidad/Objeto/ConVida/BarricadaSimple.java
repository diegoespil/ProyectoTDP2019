package Entidad.Objeto.ConVida;

public class BarricadaSimple extends ObjetoConVida{

	protected final static int precio = 30;
	
	public BarricadaSimple(int x, int y,int vida) {
		super(x, y,vida);
	}

	public static int getPrecio() {
		return precio;
	}
	
	public int getVida() {
		return vida;
	}
}
