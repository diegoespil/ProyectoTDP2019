package Entidad.Integrante.Personaje;

public class Mike extends Personaje {

	public Mike(int x, int y,int danio, int alcance, int precio) {
		super(x,y,danio,alcance,precio);
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
}
