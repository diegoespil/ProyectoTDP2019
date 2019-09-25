package Tienda;

import javax.swing.JOptionPane;
import Creadores.CreadorConVidaComprable.CreadorConVidaComprable;
import Creadores.CreadorPersonaje.*;
import Entidad.Entidad;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.ConVida.ConVidaComprable;
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
			ConVidaComprable nuevo = creador.crearConVidaComprable();
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

