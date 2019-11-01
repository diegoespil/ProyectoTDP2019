package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorMike extends CreadorEntidad {

	public Personaje crear(){
		Personaje pje = new Mike(0,0,20,1); //(x,y,danio,alcance)
		return pje;
	}
}
