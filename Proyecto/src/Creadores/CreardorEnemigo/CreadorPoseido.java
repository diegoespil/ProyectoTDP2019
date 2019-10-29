package Creadores.CreardorEnemigo;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;

public class CreadorPoseido extends CreadorEnemigo{
	
	public Enemigo crearEnemigo(){
		Enemigo ene = new Poseido(0,0,2,5,1,20,5); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}
