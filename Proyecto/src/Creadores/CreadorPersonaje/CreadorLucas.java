package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Lucas;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Normal;

public class CreadorLucas extends CreadorEntidad{

	public Personaje crear(){
		Personaje pje = new Lucas(0,0,15,2); //(x,y,danio,alcance)	
		pje.setState(new Normal(pje));
		return pje;
	}
}
