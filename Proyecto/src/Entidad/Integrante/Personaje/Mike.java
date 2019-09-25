package Entidad.Integrante.Personaje;

public class Mike extends Personaje {

	public Mike(int x, int y,int danio, int alcance, int precio) {
		super(x,y,danio,alcance,precio);
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
	
}
