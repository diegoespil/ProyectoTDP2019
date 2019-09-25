package Tienda;

import java.time.temporal.Temporal;

import javax.swing.JOptionPane;
import Creadores.CreadorConVidaComprable.CreadorConVidaComprable;
import Creadores.CreadorPersonaje.*;
import Creadores.CreadorTemporal.CreadorTemporal;
import Entidad.Entidad;
import Entidad.Integrante.Personaje.Personaje;
import Juego.Juego;


public class Tienda {
	
	protected Juego juego;
	
	public Tienda(Juego j) {
		juego = j;
	}
	
	public void crearPersonaje(CreadorPersonaje creador, int precio){
		if (alcanza(precio) ){
			Personaje nuevo = creador.crearPersonaje();
			//Juego.insertar(nuevo);
		}
	}
	
	public void crearConVida(CreadorConVidaComprable creador, int precio){
		if (alcanza(precio) ){
			ObjetoConVidaComprable nuevo = creador.crearObjetoConVida();
			//Juego.insertar(nuevo);
		}
	}
	
	public void crearTemporal(CreadorTemporal creador, int precio){
		if (alcanza(precio) ){
			ObjetoTemporal nuevo = creador.crearTemporal();
			//Juego.insertar(nuevo);
		}
	}
	
	private boolean alcanza(int precio){
		//debe comparar el precio de la Entidad a comprar con el dinero que tiene el jugador
		if(juego.getMonedas() >= precio)
			return true; //cambiar cuando se implemente el dinero
		else
			return false;
	}

}

