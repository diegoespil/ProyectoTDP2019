package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;

public class CreadorPoseido extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Poseido(0,0,2,15,4,50,15); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}
