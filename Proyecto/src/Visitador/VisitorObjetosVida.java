package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public class VisitorObjetosVida extends Visitor{

	public VisitorObjetosVida(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public void visitPersonaje(Personaje a) { }

	public void visitEnemigo(Enemigo e) { }

	public void visitObjetosVida(Objeto o) { }

	public void visitObjetosTemporal(Objeto o) { }

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }

}
