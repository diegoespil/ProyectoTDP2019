package Entidad.Objeto.ConVida;

import Entidad.Objeto.Objeto;

public abstract class ObjetoConVida extends Objeto {

	protected int vida;

	public ObjetoConVida(int x, int y, int vida) {
		super(x, y);
		this.vida = vida;
	}
	
	public abstract int getVida();

}
