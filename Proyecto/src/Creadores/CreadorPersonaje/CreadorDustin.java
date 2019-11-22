package Creadores.CreadorPersonaje;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Personaje.Dustin;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Normal;

public class CreadorDustin extends CreadorEntidad{

	public Personaje crear(){
		Personaje pje = new Dustin(0,0,10,1); //(x,y,danio,alcance)
		pje.setState(new Normal(pje));
		return pje;
	}
}
