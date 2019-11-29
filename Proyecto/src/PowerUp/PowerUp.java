package PowerUp;

import java.util.TimerTask;
import Entidad.Integrante.Integrante;

public abstract class PowerUp extends TimerTask{

	protected Integrante integrante;
	protected int duracion;
	
	public PowerUp(Integrante i, int duracion) {
		integrante = i;
		this.duracion = duracion;
	}
	
	public abstract void run();

	public abstract void activar();
	
	public abstract void desactivar();
	
	public int getDuracion(){
		return duracion;
	}

}
