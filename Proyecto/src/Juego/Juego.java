package Juego;

import java.util.Random;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Personaje;
import Gui.miVentanaJuego;

public class Juego {
	private Enemigo enemigo;
	private Personaje personaje;
	
	public Juego(miVentanaJuego gui) {
		/* modifiqu� el constructor de Enemigo para que incluya el par�metro puntaje,
		 * por eso esta declaraci�n de new Poseido tiene un par�metro extra.
		 * Ese cero al final corresponde al puntaje.
		 * -Bernardo
		 */
		enemigo = new Poseido(13,6,10,0); 
		gui.add(enemigo.getGrafico());
		
		
		personaje = new Mike(1,6);
	}
}
