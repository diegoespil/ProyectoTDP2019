package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Objeto.Temporal.GasVenenoso;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class CreadorGas extends CreadorEntidad {
	
	public ObjetoTemporal crear() {
		GasVenenoso  nuevo = new GasVenenoso(0,0,10);
		return nuevo;
	}

}
