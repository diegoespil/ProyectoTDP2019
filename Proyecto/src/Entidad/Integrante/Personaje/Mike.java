package Entidad.Integrante.Personaje;

public class Mike extends Personaje {

	protected final static int precio = 70;
	
	public Mike(int x, int y,int danio, int alcance, int vida) {
		super(x,y,danio,alcance,vida);
	}
	
	public static int getPrecio() {
		return precio;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
	public int getVida() {
		return vida;
	}
	
}
