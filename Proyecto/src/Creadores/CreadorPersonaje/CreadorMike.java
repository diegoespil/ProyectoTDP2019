package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorMike extends CreadorPersonaje {

	public Personaje crearPersonaje(){
		Personaje pje = new Mike(0,0,0,0,0); //temporalmente par�metros en 0
		return pje;
	}
}
