package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public class VisitorDisparoPersonaje extends Visitor {

	public VisitorDisparoPersonaje(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public void visitPersonaje(Personaje a) { }

	public void visitEnemigo(Enemigo e) {
		this.miEntidad.afectar(e);
	}

	public void visitObjetosVida(Objeto o) { System.out.println("obj encontrado"); }

	public void visitObjetosTemporal(Objeto o) { }

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }


}
