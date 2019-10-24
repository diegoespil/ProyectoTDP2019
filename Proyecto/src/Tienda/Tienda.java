package Tienda;

import java.time.temporal.Temporal;

import javax.swing.JOptionPane;
import Creadores.CreadorConVidaComprable.CreadorObjetoConVida;
import Creadores.CreadorPersonaje.*;
import Creadores.CreadorTemporal.CreadorTemporal;
import Entidad.Entidad;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.ConVida.ObjetoConVida;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Juego.Juego;


public class Tienda {
	
	protected Juego juego;
	protected Entidad proxACerear;
	
	public Tienda(Juego j) {
		juego = j;
	}
	
	public void crearPersonaje(CreadorPersonaje creador, int precio){
		if (alcanza(precio) ){
			Personaje nuevo = creador.crearPersonaje();
			//Juego.insertar(nuevo);
		}
	}
	
	public void crearObjetoConVida(CreadorObjetoConVida creador, int precio){
		if (alcanza(precio) ){
			ObjetoConVida nuevo = creador.crearObjetoConVida();
			//Juego.insertar(nuevo);
		}
	}
	
	public void crearObjetoTemporal(CreadorTemporal creador, int precio){
		if (alcanza(precio) ){
			ObjetoTemporal nuevo = creador.crearTemporal();
			//Juego.insertar(nuevo);
		}
	}
	
	private boolean alcanza(int precio){
		//debe comparar el precio de la Entidad a comprar con el dinero que tiene el jugador
		if(juego.getMoneda() >= precio)
			return true; //cambiar cuando se implemente el dinero
		else
			return false;
	}

}

