package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Juego.Juego;
import Juego.ThreadDisparo;
import Juego.ThreadEnemigos;
import Mapa.iniMapa;
import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;

@SuppressWarnings("serial")
public class miVentanaJuego extends JFrame {

	public static final int ANCHO = 800;
	public static final int ALTO = 480;
	// private JPanel contentPane;
	//private JLabel[][] grilla;
	private JPanel menu;
	private imagenfondo panel;
	private Juego juego;
	private ThreadEnemigos threadEnemigos;
	private ThreadDisparo threadDisparo;
	private int puntaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentanaJuego frame = new miVentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public miVentanaJuego() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new JPanel();
		menu.setOpaque(false);
		menu.setLayout(null);
		setBounds(300, 50, 800, 692);
		setResizable(false);
		setContentPane(menu);
		ImageIcon cielo = new ImageIcon("Imagenes//cielo.jpg");
		panel = new imagenfondo();
		panel.setBounds(0, 128, 800, 480);
		panel.setBackground("Imagenes//Fondo.png");
		menu.add(panel);
		panel.setLayout(null);
		juego = new Juego(this);
		iniciarObstaculos();
		insertarEnemigo();
		insertarDisparo();
	//	grilla = new JLabel[8][13];
		
	//	inicializarGrilla();
	//	crearGrilla();

		//Establece el fondo de la ciudad dde fondo.
		JLabel fondoCiudad = new JLabel("");
		
		fondoCiudad.setIcon(new ImageIcon(cielo.getImage().getScaledInstance(800, 127, Image.SCALE_SMOOTH)));
		fondoCiudad.setBounds(0, 0, 800, 127);
		menu.add(fondoCiudad);

		//Boton tienda abre la ventana de la tienda.
		JButton button = new JButton("Tienda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentanaTienda tienda = new miVentanaTienda(juego);
				tienda.setVisible(true);
				//setVisible(false);
			}
		});
		button.setFocusable(false);
		button.setBounds(668, 609, 132, 54);
		menu.add(button);
		
		//Boton para volver al menu principal.
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentanaMenu menu = new miVentanaMenu();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(0, 609, 132, 54);
		menu.add(btnVolver);
		
		//Boton para eliminar enemigo Sprint 3.
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.out.println("eliminar enemigo");				
				Enemigo enemigo = juego.getEnemigo();
				Point pos = enemigo.getPos();
				juego.eliminarEnemigo(juego.getEnemigo());
				//grilla[pos.y][pos.x].setIcon(null);				
			}
			
		});
		btnNewButton.setBounds(282, 609, 212, 54);
		menu.add(btnNewButton);

		
		threadEnemigos = new ThreadEnemigos(juego);
		threadEnemigos.start();
		threadDisparo = new ThreadDisparo(juego);
		threadDisparo.iniciar();
		
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	public void iniciarObstaculos() {
		Entidad [][] aux = juego.getGrilla();
		System.out.println("el panel tiene "+panel.getComponents().length+" elementos");
		for(int i=0;i<aux.length;i++) {
			for(int j=0;j<aux[i].length;j++) {
				if(aux[i][j]!=null) {
					System.out.println("tiene entidad");
					JLabel obstaculo = new JLabel();
					obstaculo.setBounds(j*60, i*60, 60, 60);
					ImageIcon nuevo = aux[i][j].getImage();
					obstaculo.setIcon(new ImageIcon(nuevo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					obstaculo.setVisible(true);
					panel.add(obstaculo);
					
				}
			}
		}
	}
	
	
	/*
 
	//aMetodo para crear la grilla de JLabel
	protected void crearGrilla() {
		iniMapa matriz = new iniMapa();
		String palabra;
		try {
			obstaculo = matriz.getObstaculos();
			for (int i = 0; i < obstaculo.length; i++)
				for (int j = 0; j < obstaculo[i].length; j++) {
					palabra = obstaculo[i][j];
					if (palabra.equals("auto")) {
						ImageIcon auto = new ImageIcon("Imagenes//auto-fuego1.png");
						grilla[i][j]
								.setIcon(new ImageIcon(auto.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					} else {
						if (palabra.equals("auto2")) {
							ImageIcon auto2 = new ImageIcon("Imagenes//auto-fuego2.png");
							grilla[i][j].setIcon(
									new ImageIcon(auto2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
						} else {
							if (palabra.equals("vacio")) {
								grilla[i][j].setVisible(false);
							} else {
								if (palabra.equals("auto3")) {
									ImageIcon auto3 = new ImageIcon("Imagenes//auto-fuego3.png");
									grilla[i][j].setIcon(new ImageIcon(
											auto3.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
								} 
							}
						}

					}
				}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Metodo para inci
	public void quitarIntegrante(Integrante enemigo) {
		Point pos = enemigo.getPos();
		grilla[pos.y][pos.x].setIcon(null);
		
	}alizar la grilla
	protected void inicializarGrilla() {

		for (int i = 0; i < grilla.length; i++)
			for (int j = 0; j < grilla[i].length; j++) {
				grilla[i][j] = new JLabel();
				grilla[i][j].setBounds(j * 60, i * 60, 60, 60);
				panel.add(grilla[i][j]);
			}
	}
	
	public void setGrilla(Point pos, ImageIcon image){
		grilla[pos.y][pos.x].setIcon(new ImageIcon(image.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		grilla[pos.y][pos.x].setVisible(true);
		panel.repaint();
	}
	
	public JLabel[][] getGrilla(){
		return grilla;
	}
	
	public void actualizarPuntaje(int puntaje) {
		this.puntaje +=puntaje;
		
	}
	
	
	public void quitarIntegrante(Integrante enemigo) {
		Point pos = enemigo.getPos();
		grilla[pos.y][pos.x].setIcon(null);
		
	}
	*/
	public JLabel inciarMovieiento(Point pos,ImageIcon image) {
		JLabel nuevo = new JLabel();
		System.out.println("posicion x: "+pos.x+" y en y: "+pos.y);
		nuevo.setBounds(pos.y, pos.x, 60, 60);
		nuevo.setIcon(new ImageIcon(image.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		panel.add(nuevo);
		return nuevo;
	}
	
	public void setGrilla(Point pos,JLabel image) {
		image.setBounds(pos.y,pos.x-60, 60, 60);
	}
	
	public void celdaVacia(JLabel label) {
	    //label.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED));
		panel.remove(label);
		panel.validate();
		panel.repaint();
		//grilla[pos.y][pos.x].setIcon(null);
	}
	
	public void insertarEnemigo(){
		Enemigo enemigo = new Poseido(4,12,10,5,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
		ImageIcon img = new ImageIcon("Imagenes/malo1_izq.png");
		JLabel enemigoLabel = new JLabel();
		enemigoLabel.setBounds(12*60, 4*60, 60, 60);
		enemigoLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		enemigoLabel.setVisible(true);
		
		enemigo.setLabel(enemigoLabel);
		panel.add(enemigoLabel);
		juego.insertarEnemigo(enemigo);
	}
	public void insertarDisparo(){
		DisparoEnemigo disparo = new DisparoEnemigo(3,12,5,1); //(x,y,danio,velocidad)
		JLabel disparoLabel = new JLabel();
		disparoLabel.setBounds(12*60, 3*60, 10, 5);
		disparoLabel.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED));
		disparoLabel.setVisible(true);
		
		disparo.setLabel(disparoLabel);
		panel.add(disparoLabel);
		juego.insertarDisparo(disparo);
	}
	public void mover(Entidad e){
		JLabel entidadLabel = e.getLabel();
		int newX = entidadLabel.getX()-60;
		int newY = entidadLabel.getY();
		entidadLabel.setBounds(newX, newY, entidadLabel.getWidth(), entidadLabel.getHeight());
	}
}