package Visitador;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.Objeto;
import Entidad.Objeto.Temporal.PowerupEnMapa.*;

public class VisitorPowerupEnMapa extends Visitor {

	public VisitorPowerupEnMapa(Entidad e) {
		super(e);
	}
	
	@Override
	public void visitPersonaje(Personaje a) {
		PowerupEnMapa pUp = (PowerupEnMapa) miEntidad;
		pUp.afectar(a);
		pUp.setAsignado(true);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitObjetosVida(Objeto o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitObjetosTemporal(Objeto o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitDisparoEnemigo(Disparo d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitDisparoPersonaje(Disparo d) {
		// TODO Auto-generated method stub

	}

}
