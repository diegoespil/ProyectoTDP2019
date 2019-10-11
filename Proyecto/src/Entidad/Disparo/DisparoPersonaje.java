package Entidad.Disparo;

import Entidad.Entidad;
import Visitador.Visitor;

public class DisparoPersonaje extends Disparo {

	public DisparoPersonaje(int x, int y, int danio,int velocidad) {
		super(x, y,danio,velocidad);	
	}

	public void accept(Visitor v) {
		v.visitDisparoPersonaje(this);
	}

	public void atacar(Entidad e) { }

	public void afectar(Entidad e) {
		e.setVida(e.getVida()-danio);	
	}

}
