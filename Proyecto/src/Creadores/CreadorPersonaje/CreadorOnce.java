package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Once;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorOnce extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Once(0,0,40,2); //(x,y,danio,alcance)
		return pje;
	}
}
