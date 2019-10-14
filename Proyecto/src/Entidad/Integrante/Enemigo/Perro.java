package Entidad.Integrante.Enemigo;

public class Perro extends Enemigo{

	public Perro(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
	}

	public int getPuntaje() {
		return this.puntaje;
	}

	public int getMonedas() {
		return this.monedas;
	}


}
