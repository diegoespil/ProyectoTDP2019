package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Lucas;
import Entidad.Integrante.Personaje.Personaje;

public class CrearorLucas {

	public Personaje crearPersonaje(){
		Personaje pje = new Lucas(0,0,0,0,0); //temporalmente parámetros en 0
		return pje;
	}
}
