package Creadores.CreadorPersonaje;

import Entidad.Integrante.Personaje.Dustin;
import Entidad.Integrante.Personaje.Personaje;

public class CreadorDustin extends CreadorPersonaje{

	public Personaje crearPersonaje(){
		Personaje pje = new Dustin(0,0,0,0); //temporalmente par�metros en 0
		return pje;
	}
}
