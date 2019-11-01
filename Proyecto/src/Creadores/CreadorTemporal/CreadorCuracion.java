package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.Curacion;

public class CreadorCuracion extends CreadorEntidad {

	
	public Entidad crear() {
		Curacion nuevo = new Curacion(0,0,5);
		return nuevo;
	}

}
