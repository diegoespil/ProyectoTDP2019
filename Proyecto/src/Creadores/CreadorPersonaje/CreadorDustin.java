package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Dustin;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorDustin {

	public Personaje crearPersonaje(){
		Personaje pje = new Dustin(0,0,0,0,0); //temporalmente parámetros en 0
		return pje;
	}
}
