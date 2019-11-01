package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Hopper;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorHopper extends CreadorEntidad {

	public Personaje crear(){
		Personaje pje = new Hopper(0,0,25,12); //(x,y,danio,alcance)
		return pje;
	}
}
