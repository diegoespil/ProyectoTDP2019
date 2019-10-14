package Entidad.Objeto.ConVida;

import Entidad.Entidad;
import Entidad.Objeto.Objeto;
import Visitador.Visitor;

public abstract class ObjetoConVida extends Objeto {

	public ObjetoConVida(int x, int y, int vida) {
		super(x, y,vida);
	}
	
	public void accept(Visitor v) {
		v.visitObjetosVida(this);
	}
	
	public void afectar(Entidad e) { }

}
