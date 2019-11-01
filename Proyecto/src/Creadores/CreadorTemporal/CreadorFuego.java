package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.Fuego;

public class CreadorFuego extends CreadorEntidad {

	public Entidad crear() {
		Fuego nuevo = new Fuego(0,0,30);
		return nuevo;
	}

}
