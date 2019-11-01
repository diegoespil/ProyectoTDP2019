package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.Bomba;

public class CreadorBomba extends CreadorEntidad {

	@Override
	public Entidad crear() {
		Bomba nuevo = new Bomba(0,0,5);
		return nuevo;
	}

	
}
