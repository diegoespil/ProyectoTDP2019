package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.CampoDeFuerza;

public class CreadorCampoFuerza extends CreadorEntidad {

	@Override
	public Entidad crear() {
		CampoDeFuerza nuevo = new CampoDeFuerza(0,0,5);
		return nuevo;
	}

}
