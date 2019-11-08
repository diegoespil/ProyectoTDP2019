package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Perro;
import Entidad.Integrante.State.Normal;

public class CreadorPerro extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Perro(0,0,5,10,1,40,10); //(x,y,vel,danio,alc,ptje,monedas)
		ene.changeState(new Normal(ene));
		return ene;
	}

}
