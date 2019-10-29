package Juego.Nivel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import Entidad.Integrante.Enemigo.*;
import Entidad.Objeto.Objeto;
import Entidad.Objeto.ConVida.Auto;
import Gui.miVentanaJuego;
import Juego.Juego;

public class Nivel1 extends Nivel {

	public Nivel1(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
	

	public Nivel subirNivel() {
		
		return null;
	}

	@Override
	public void cargarNivel() {
		initEnemigos();
		initObjetos();

	}

	private void initObjetos() {
		String cadena;
		FileReader f;
		try {
			f = new FileReader("Archivo//Mapa1.txt");
			BufferedReader b = new BufferedReader(f);
			int fila = 0;
			while ((cadena = b.readLine()) != null) {
				String arr[] = cadena.split(",");
				for (int i = 0; i < arr.length; i++) {
					switch(arr[i]) {
					/*case "fuego" : { grilla[fila][i] = new Fuego(fila,i,10);
									break;
					}*/
					case "auto" : { this.objetos.add(new Auto(fila,i,100));
	//								grilla[fila][i].setImage("Imagenes//auto-fuego1.png");
									break;
						
					}	
					case "auto2" : { this.objetos.add(new Auto(fila,i,100));
	//								grilla[fila][i].setImage("Imagenes//auto-fuego2.png");
									break;
	
		            }
					case "auto3" : { this.objetos.add(new Auto(fila,i,100));
	//								grilla[fila][i].setImage("Imagenes/auto-fuego3.png");
									break;
					}
					
					}
				}
				fila++;
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

	private void initEnemigos() {
		try{
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
						case "rata": {this.enemigos.add(new Rata(x,y, 2, 1, 4, 50, 20));
										System.out.println("rata");
										break;
									}
						case "ruso": {this.enemigos.add(new Ruso(x,y, 2, 1, 4, 50, 20));
										System.out.println("ruso");
										break;
									}
						case "perro": {this.enemigos.add(new Perro(x,y, 2, 1, 4, 50, 20));
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
	
	public Objeto getObjeto(){
		if (cantObjetos != 0){
			cantObjetos--;
			return this.objetos.get(cantObjetos);
		}
		return null;
	}
	
}
