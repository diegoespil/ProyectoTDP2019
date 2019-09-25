package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Lucas;
import Entidad.Integrante.Personaje.Personaje;

public class CrearorLucas extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Lucas(0,0,0,0,0); //temporalmente par�metros en 0
		return pje;
	}
}
