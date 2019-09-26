package Entidad.Integrante.Personaje;


public class Hopper extends Personaje {

	protected final static int precio = 100;
	
	public Hopper(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
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
