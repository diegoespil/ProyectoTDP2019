package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Dustin;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorDustin extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Dustin(0,0,10,1); //(x,y,danio,alcance)
		return pje;
	}
}
