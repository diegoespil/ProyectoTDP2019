package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Once;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorOnce extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Once(0,0,0,0,0); //temporalmente par�metros en 0
		return pje;
	}
}
