package Entidad.Integrante.Personaje;

public class Once extends Personaje {

	protected final static int precio = 150;
	
	public Once(int x, int y, int dmg, int alc, int vida) {
		super(x, y, dmg, alc, vida);
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
