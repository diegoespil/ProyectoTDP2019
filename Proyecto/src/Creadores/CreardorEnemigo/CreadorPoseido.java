package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Integrante.State.Normal;

public class CreadorPoseido extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Poseido(0,0,2,15,1,50,15); //(x,y,vel,danio,alc,ptje,monedas)
		ene.setState(new Normal(ene));
		return ene;
	}

}
