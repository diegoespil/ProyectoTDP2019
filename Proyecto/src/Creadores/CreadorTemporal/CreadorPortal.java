package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Entidad.Objeto.Temporal.Portal;

public class CreadorPortal extends CreadorEntidad {
	
	public ObjetoTemporal crear() {
		Portal nuevo = new Portal(0,0,15);
		return nuevo;
	}

}
