package Juego.Nivel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import Entidad.Integrante.Enemigo.*;
import Gui.miVentanaJuego;
import Juego.Juego;

public class Nivel1 extends Nivel {

	public Nivel1(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
	
	public void agregarObjetos() {
		
	}

	public Nivel subirNivel() {
		
		return null;
	}

	@Override
	public void cargarNivel() {
		try {
			int ancho = miVentanaJuego.ANCHO;
			int alto = miVentanaJuego.ALTO;
			String cadena;
			File file = new File("src\\Juego\\Nivel\\Nivel1");
			FileReader f = new FileReader(file.getAbsolutePath());
			BufferedReader b = new BufferedReader(f);
			this.cantEnemigos = 0;
			while ((cadena = b.readLine()) != null) {
				String arr[] = cadena.split(",");
				cantEnemigos += arr.length;
				for (int i = 0; i < arr.length; i++) {
					int x = (int) (Math.random() * 100) + 800;
					int y = (int) (Math.random() * 420);
					System.out.println("x: "+x+" y: "+y);
					switch (arr[i]) {
						case "rata": {this.enemigos.add(new Rata(ancho,alto, 2, 1, 4, 50, 20));
										System.out.println("rata");
										break;
									}
						case "ruso": {this.enemigos.add(new Ruso(ancho,alto, 2, 1, 4, 50, 20));
										System.out.println("ruso");
										break;
									}
						case "perro": {this.enemigos.add(new Perro(ancho,alto, 2, 1, 4, 50, 20));
										System.out.println("perro");
										break;
									}
					}
				}			
			}
			b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Enemigo getEnemigo() {
		if (cantEnemigos != 0) {
			cantEnemigos--;
//			switch (cantEnemigos) {
//				case 11: juego.addPowerUp(this.getPowerUp());break;
//				case 9: juego.addPowerUp(this.getPowerUp());break;
//				case 5: juego.addPowerUp(this.getPowerUp());break;
//				case 3: juego.addPowerUp(this.getPowerUp());break;
//			}
			return enemigos.get(cantEnemigos);
		}
		return null;
	}
}
