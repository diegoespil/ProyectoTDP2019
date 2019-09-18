package Juego;

import java.util.Random;

import Entidad.Integrantes.Enemigo.Enemigo;
import Entidad.Integrantes.Enemigo.Poseido;
import Entidad.Integrantes.Personaje.Micke;
import Entidad.Integrantes.Personaje.Personaje;
import Gui.miVentanaJuego;

public class Juego {
	private Enemigo enemigo;
	private Personaje personaje;
	
	public Juego(miVentanaJuego gui) {
		enemigo = new Poseido(13,6,10);
		gui.add(enemigo.getGrafico());
		
		
		personaje = new Micke(1,6);
	}
}
