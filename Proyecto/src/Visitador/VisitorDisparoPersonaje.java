package Visitador;

import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public class VisitorDisparoPersonaje extends Visitor {

	public void visitPersonaje(Personaje a) { }

	public void visitEnemigo(Enemigo e) {
		this.miEntidad.afectar(e);
	}

	public void visitObjetosVida(Objeto o) { }

	public void visitObjetosTemporal(Objeto o) { }

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }


}
