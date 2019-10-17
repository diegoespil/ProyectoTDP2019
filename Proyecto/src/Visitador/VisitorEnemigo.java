package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Entidad e) {
		super(e);

	}

	public void visitPersonaje(Personaje a) {
		this.miEntidad.atacar(a);	
	}

	public void visitEnemigo(Enemigo e) { }


	public void visitObjetosVida(Objeto o) {
		this.miEntidad.atacar(o);
	}

	public void visitObjetosTemporal(Objeto o) { 
		//Aca pensar que hacer con el objeto temporal( pisar o atravezar)
	}

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }


}
