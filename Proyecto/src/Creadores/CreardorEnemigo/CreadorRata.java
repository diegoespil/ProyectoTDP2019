package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Rata;
import Entidad.Integrante.State.Normal;

public class CreadorRata extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Rata(0,0,4,5,1,20,5); //(x,y,vel,danio,alc,ptje,monedas)
		ene.setState(new Normal(ene));
		return ene;
	}

}
