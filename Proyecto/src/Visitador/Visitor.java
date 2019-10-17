package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;

public abstract class Visitor {
	protected Entidad miEntidad;
	
	public Visitor(Entidad e) {
		miEntidad = e;
	}
	public abstract void visitPersonaje(Personaje a);
	public abstract void visitEnemigo(Enemigo e);
	public abstract void visitObjetosVida(Objeto o);
	public abstract void visitObjetosTemporal(Objeto o);
	public abstract void visitDisparoEnemigo(Disparo d);
	public abstract void visitDisparoPersonaje(Disparo d);
}
