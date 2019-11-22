package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Hopper;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Normal;

public class CreadorHopper extends CreadorEntidad {

	public Personaje crear(){
		Personaje pje = new Hopper(0,0,25,12); //(x,y,danio,alcance)
		pje.setState(new Normal(pje));
		return pje;
	}
}
