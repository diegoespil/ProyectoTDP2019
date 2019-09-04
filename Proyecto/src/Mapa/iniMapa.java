package Mapa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class iniMapa {
	
	private String[][] obstaculos;
	
	public iniMapa(){
		obstaculos= new String[7][10];
	}
		
	public String [][] getObstaculos(String archivo) throws FileNotFoundException, IOException {
	      String cadena;
	      File file = new File(archivo);
	      FileReader f = new FileReader(file.getAbsolutePath());
	      BufferedReader b = new BufferedReader(f);
	      int fila=0;
	      int i=0;
	      while((cadena = b.readLine())!=null) {
	    	  procesarLinea(cadena,fila);
	    	 
	          fila++;
	      }
	      b.close();
	      return obstaculos;
	}
	
	void procesarLinea(String cadena,int fila){
		String arr[] = cadena.split(",");
		char c;
		int col=0;
		for (int i=0;i<	arr.length;i++){
			obstaculos[fila][i] = arr[i];
		}
	}			
			
			
//			c=cadena.charAt(i);
//			if (c==']'){
//				col++;
//			}
//			else{
//				if (c=='l'){
//					i=i+7;
//					obstaculos[fila][col]="ladrillo";
//				}
//				else
//					if (c=='a'){
//							i++;
//							c=cadena.charAt(i);
//							if (c!='g')
//								if (c=='c'){
//									i=i+3;
//									obstaculos[fila][col]="acero";
//								}
//								else{
//									i=i+3;
//									obstaculos[fila][col]="arbol";
//								}
//							else
//							{
//								i++; i++;
//								c=cadena.charAt(i);
//								if (c=='a')
//								{
//									obstaculos[fila][col]="agua";
//								}
//								else{
//									i=i+2;
//									obstaculos[fila][col]="aguila";
//								}
//							}
//					}
//					else
//						if (c=='v')
//						{
//							i=i+4;
//							obstaculos[fila][col]="vacio";
//						}
//			}
//					
//		}
	}


