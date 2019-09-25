package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Hopper;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorHopper extends CreadorPersonaje {

	public Personaje crearPersonaje(){
		Personaje pje = new Hopper(0,0,0,0,0); //temporalmente par�metros en 0
		return pje;
	}
}
