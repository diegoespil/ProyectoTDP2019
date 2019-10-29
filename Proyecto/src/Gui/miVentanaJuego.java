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
import Entidad.Entidad;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Juego.Subscriber;

@SuppressWarnings("serial")
public class miVentanaJuego extends JFrame implements Subscriber{

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
					Entidad obstaculo = aux[i][j];
					JLabel obsLabel = obstaculo.getLabel();
					panel.add(obsLabel);
				}
			}
		}
	}

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
	
	public void quitarLabel(JLabel label) {
		panel.remove(label);
		panel.validate();
		panel.repaint();
	}
	
	public void insertarEnemigo(){
		Enemigo enemigo = new Poseido(4,12,10,50,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
		ImageIcon img = new ImageIcon("Imagenes/malo1_izq.png");
		JLabel enemigoLabel = new JLabel();
		enemigoLabel.setBounds(enemigo.getPos().y*60, enemigo.getPos().x*60, 60, 60);
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
	public void update(Entidad e){
		JLabel entidadLabel = e.getLabel();
		if(e.getVida()<=0){
			quitarLabel(e.getLabel());
		}
		else{
			int newX = entidadLabel.getX()-60;
			int newY = entidadLabel.getY();
			entidadLabel.setBounds(newX, newY, entidadLabel.getWidth(), entidadLabel.getHeight());
		}
	}
}