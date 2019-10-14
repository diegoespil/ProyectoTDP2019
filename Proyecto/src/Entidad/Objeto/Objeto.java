package Entidad.Objeto;

import Entidad.Entidad;

public abstract class Objeto extends Entidad {

	public Objeto(int x, int y, int vida) {
		super(x, y,vida);
	}

	public void atacar(Entidad e) { }

}
