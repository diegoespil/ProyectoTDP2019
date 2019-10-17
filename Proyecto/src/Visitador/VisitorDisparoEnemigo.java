package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public class VisitorDisparoEnemigo extends Visitor {

	public VisitorDisparoEnemigo(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public void visitPersonaje(Personaje a) {
		this.miEntidad.afectar(a);
	}

	public void visitEnemigo(Enemigo e) { }

	public void visitObjetosVida(Objeto o) {
		this.miEntidad.afectar(o);
		
	}

	public void visitObjetosTemporal(Objeto o) { }

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }

}
