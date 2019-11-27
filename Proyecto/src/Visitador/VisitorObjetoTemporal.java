package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;
import Entidad.Objeto.Temporal.*;

public class VisitorObjetoTemporal extends Visitor {

	public VisitorObjetoTemporal(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public void visitPersonaje(Personaje a) { 
		((ObjetoTemporal)miEntidad).setAsignado(true);
	}

	public void visitEnemigo(Enemigo e) {
		this.miEntidad.afectar(e);
	}

	public void visitObjetosVida(Objeto o) { }

	public void visitObjetosTemporal(Objeto o) { }

	public void visitDisparoEnemigo(Disparo d) { }

	public void visitDisparoPersonaje(Disparo d) { }

}
