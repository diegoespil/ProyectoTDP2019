package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Once;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorOnce {

	public Personaje crearPersonaje(){
		Personaje pje = new Once(0,0,0,0,0); //temporalmente parámetros en 0
		return pje;
	}
}
