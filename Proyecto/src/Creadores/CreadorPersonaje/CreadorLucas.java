package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Lucas;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorLucas extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Lucas(0,0,15,2); //(x,y,danio,alcance)		
		return pje;
	}
}
