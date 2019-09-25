package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Juego.Juego;
import Juego.ThreadEnemigos;
import Mapa.iniMapa;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;

@SuppressWarnings("serial")
public class miVentanaJuego extends JFrame {

	// private JPanel contentPane;
	private JLabel[][] grilla;
	private String[][] obstaculo;
	JPanel menu;
	private Juego juego;
	private ThreadEnemigos threadEnemigos;
	private ImageIcon barricada_1 = new ImageIcon("Imagenes//barricada1.png");
	private ImageIcon barricada_2 = new ImageIcon("Imagenes//barricada2.png");
	private ImageIcon gas = new ImageIcon("Imagenes//gas.png");
	private ImageIcon portal_trampa = new ImageIcon("Imagenes//portal.png");
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
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);
		setBounds(300, 50, 800, 692);
		setResizable(false);
		setContentPane(menu);
		ImageIcon once = new ImageIcon("Imagenes//once.png");
		ImageIcon dustin = new ImageIcon("Imagenes//dustin.png");
		ImageIcon micke = new ImageIcon("Imagenes//micke.png");
		ImageIcon lucas = new ImageIcon("Imagenes//lucas.png");
		ImageIcon hoppe = new ImageIcon("Imagenes//hoppe.png");
		ImageIcon malo1 = new ImageIcon("Imagenes//malo1.png");
		ImageIcon malo2 = new ImageIcon("Imagenes//malo2.png");
		ImageIcon iconFondo = new ImageIcon("Imagenes//Fondo.jpg");
		ImageIcon cielo = new ImageIcon("Imagenes//cielo.jpg");
		
		grilla = new JLabel[8][13];
		inicializarGrilla();
		crearGrilla();
		JLabel fondo = new JLabel();
		/*fondo.setEnabled(false);
		fondo.setBounds(0, 127, 800, 540);
		fondo.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int x,y;
				x = e.getX()/60;
				y = (e.getY()/60);
				System.out.println("Estoy en "+x+" de X y "+y+" de Y");
				if(grilla[y][x].getIcon() == null) { 
					System.out.println("esta vacio");
					grilla[y][x].setIcon(new ImageIcon(micke.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					grilla[y][x].setVisible(true);
					menu.repaint();
				}
				else
					System.out.println("tenia etiqueta");
				
			}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}

		});
		*/
		imagenfondo panel = new imagenfondo();
		panel.setBounds(0, 128, 800, 480);
		panel.setBackground("Imagenes//Fondo.jpg");
		panel.setEnabled(false);
		menu.add(panel);
		//fondo.setIcon(new ImageIcon(iconFondo.getImage().getScaledInstance(800, 420, Image.SCALE_SMOOTH)));
		//menu.add(fondo);

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Enemigo enemigo = juego.getEnemigo();
				Point pos = enemigo.getPos();
				juego.eliminarEnemigo(juego.getEnemigo());
				grilla[pos.y][pos.x].setIcon(null);				
			}
			
		});
		btnNewButton.setBounds(282, 609, 212, 54);
		menu.add(btnNewButton);

		juego = new Juego(this);
		threadEnemigos = new ThreadEnemigos(juego);
		threadEnemigos.start();
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

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
								} else {
									if (palabra.equals("fuego")) {
										ImageIcon fuego = new ImageIcon("Imagenes//fuego.png");
										grilla[i][j].setIcon(new ImageIcon(
												fuego.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
									} else {
										if (palabra.equals("once")) {
											ImageIcon once = new ImageIcon("Imagenes//once.png");
											grilla[i][j].setIcon(new ImageIcon(
													once.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
										}
									}
								}
							}
						}

					}
				}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Metodo para incializar la grilla
	protected void inicializarGrilla() {

		for (int i = 0; i < grilla.length; i++)
			for (int j = 0; j < grilla[i].length; j++) {
				grilla[i][j] = new JLabel();
				grilla[i][j].setBounds(j * 60, (i+2) * 60, 60, 60);
				menu.add(grilla[i][j]);
			}
	}
	
	
	public void setGrilla(Point pos, ImageIcon image){
		grilla[pos.y][pos.x].setIcon(new ImageIcon(image.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		grilla[pos.y][pos.x].setVisible(true);
		menu.repaint();
	}
	
	public void celdaVacia(Point pos) {
		grilla[pos.y][pos.x].setIcon(null);
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
}
