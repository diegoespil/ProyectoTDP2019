package Mapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class iniMapa {

	private String[][] obstaculos;

	public iniMapa() {
		obstaculos = new String[8][13];

	}

	public String[][] getObstaculos() throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader("Archivo//Mapa1.txt");
		BufferedReader b = new BufferedReader(f);
		int fila = 0;
		while ((cadena = b.readLine()) != null) {
			procesarLinea(cadena, fila);
			fila++;
		}
		b.close();
		return obstaculos;
	}

	private void procesarLinea(String cadena, int fila) {
		String arr[] = cadena.split(",");
		for (int i = 0; i < arr.length; i++) {
			obstaculos[fila][i] = arr[i];
		}
	}
	
	
}
