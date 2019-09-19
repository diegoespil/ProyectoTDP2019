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
	private miVentanaJuego gui;
	
	public Juego(miVentanaJuego gui) {
		/* modifiqu� el constructor de Enemigo para que incluya el par�metro puntaje,
		 * por eso esta declaraci�n de new Poseido tiene un par�metro extra.
		 * Ese cero al final corresponde al puntaje.
		 * -Bernardo
		 */
		this.gui = gui;
		enemigo = new Poseido(6,12,10,5,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
		gui.setGrilla(6, 12, enemigo.getGrafico());
		
		
		personaje = new Mike(1,6, 5, 6, 10);
	}
	
	public void mover(){
		System.out.println("mover");
			Random r = new Random();			
			int dir = r.nextInt(4);			
			enemigo.mover(dir);
			gui.setGrilla((int)enemigo.getPos().getY(), (int)enemigo.getPos().getX(), enemigo.getGrafico());
	}
}
