package Tienda;

import Creadores.CreadorConVidaComprable.CreadorConVidaComprable;
import Creadores.CreadorPersonaje.*;
import Entidad.Entidad;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Objeto.ConVida.ConVidaComprable;


public class Tienda {
	
	protected Entidad proximoAInsertar;
	public Tienda() {}
	
	public void crearPersonaje(CreadorPersonaje creador){
		Personaje nuevo = creador.crearPersonaje();
		if (alcanza(nuevo.getPrecio()) ){
			proximoAInsertar = nuevo;
			//Juego.insertar(nuevo);
		}
	}
	public void crearConVida(CreadorConVidaComprable creador){
		ConVidaComprable nuevo = creador.crearConVidaComprable();
		if (alcanza(nuevo.getPrecio()) ){
			proximoAInsertar = nuevo;
			//Juego.insertar(nuevo);
		}
	}
	
	private boolean alcanza(int precio){
		//debe comparar el precio de la Entidad a comprar con el dinero que tiene el jugador
		return true; //cambiar cuando se implemente el dinero
	}

}

