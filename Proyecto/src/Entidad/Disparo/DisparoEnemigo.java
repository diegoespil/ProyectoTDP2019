package Entidad.Disparo;

import Visitador.Visitor;
import Visitador.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int x, int y, int danio,int velocidad) {
		super(x, y,danio,velocidad);
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void accept(Visitor v) {
		v.visitDisparoEnemigo(this);
	}
	
}
