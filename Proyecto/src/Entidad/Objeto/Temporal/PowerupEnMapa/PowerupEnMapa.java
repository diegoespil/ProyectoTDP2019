package Entidad.Objeto.Temporal.PowerupEnMapa;

import Entidad.Entidad;
import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Visitador.VisitorPowerupEnMapa;

public abstract class PowerupEnMapa extends ObjetoTemporal {

	protected boolean asignado;
	
	public PowerupEnMapa(int x, int y, int tiempo){
		super(x,y,tiempo);
		asignado = false;
		miVisitor = new VisitorPowerupEnMapa(this);
	}

	public void afectar(Entidad e) {
		activar( (Integrante) e);
	}
	
	public boolean getAsignado() {
		return asignado;
	}
	
	public void setAsignado(boolean a) {
		asignado = a;
	}

	public abstract void activar(Integrante i);

}
