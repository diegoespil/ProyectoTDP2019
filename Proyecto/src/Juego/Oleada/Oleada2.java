package Juego.Oleada;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;

public class Oleada2 extends Oleada {

	public Oleada2(Vector<Enemigo> enemigos,int cant) {
		
		super(enemigos,cant);
		System.out.println("Oleada 2");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Oleada getSiguiente(Vector<Enemigo> enemigos,int cant) {
		// TODO Auto-generated method stub
		return new Oleada3(enemigos,cant);
	}
	
	public Vector<Enemigo> getEnemigos(){
		System.out.println("Enemigos: "+this.cantidad_enemigos);
		if (this.cantidad_enemigos >= this.enemigos.size()) {
			System.out.println("Cantidad mayor");
			setCantidad(this.enemigos.size());
		}
		Vector<Enemigo> toReturn = new Vector<Enemigo>();
		Iterator<Enemigo> it = this.enemigos.iterator();
		int i=0;
		while ((it.hasNext()) && (i<this.cantidad_enemigos)) {
			Enemigo e = it.next();
			toReturn.add(e);
			i++;
		}
		for (Enemigo e: toReturn)
			this.enemigos.remove(e);
		System.out.println(toReturn.size());
		return toReturn;
	}

}
