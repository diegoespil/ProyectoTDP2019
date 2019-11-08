package Entidad.Integrante.Enemigo;

import Entidad.Entidad;
import Entidad.Disparo.DisparoEnemigo;

public class Mindflayer extends Enemigo {

	public Mindflayer(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
	}

	public void atacar(Entidad e) {
		miDisparo = new DisparoEnemigo(pos.x,pos.y,danio,1);
	}
}
