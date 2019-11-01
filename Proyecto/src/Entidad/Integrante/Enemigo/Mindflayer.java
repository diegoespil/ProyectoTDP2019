package Entidad.Integrante.Enemigo;

import Entidad.Disparo.DisparoEnemigo;

public class Mindflayer extends Enemigo {

	public Mindflayer(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}

	public int getMonedas() {
		return this.monedas;
	}

	public void ataque() {
		miDisparo = new DisparoEnemigo(pos.x,pos.y-1,danio,1);
	}
}
