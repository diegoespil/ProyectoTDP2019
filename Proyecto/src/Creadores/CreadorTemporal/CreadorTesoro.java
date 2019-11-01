package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.Tesoro;

public class CreadorTesoro extends CreadorEntidad {
	
	public Entidad crear() {
		Tesoro nuevo = new Tesoro(0,0,5);
		return nuevo;
	}

}
