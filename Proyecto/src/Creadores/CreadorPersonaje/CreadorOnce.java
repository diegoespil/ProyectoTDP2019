package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Once;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Normal;

public class CreadorOnce extends CreadorEntidad{

	public Personaje crear(){
		Personaje pje = new Once(0,0,40,2); //(x,y,danio,alcance)
		pje.setState(new Normal(pje));
		return pje;
	}
}
