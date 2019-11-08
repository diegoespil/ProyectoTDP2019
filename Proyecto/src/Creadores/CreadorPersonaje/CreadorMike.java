package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Normal;

public class CreadorMike extends CreadorEntidad {

	public Personaje crear(){
		Personaje pje = new Mike(0,0,20,1); //(x,y,danio,alcance)
		pje.changeState(new Normal(pje));
		return pje;
	}
}
