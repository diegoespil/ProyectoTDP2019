package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.TrampaInmovilizadora;

public class CreadorTrampa extends CreadorEntidad {
	
	public Entidad crear() {
		TrampaInmovilizadora nuevo = new TrampaInmovilizadora(0,0,5);
		return nuevo;
	}

}
