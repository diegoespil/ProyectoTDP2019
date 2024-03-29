package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Juego.Juego;
import Entidad.Entidad;

@SuppressWarnings("serial")
public class miVentanaJuego extends JFrame{


	public static final int ANCHO = 800;
	public static final int ALTO = 480;
	private JPanel menu;
	private imagenfondo panel;
	private JLabel lblMonedas;
	private JLabel lblPuntaje;
	private Juego juego;

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
		
		//Inserta los contadores de Monedas y Puntaje.
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setBounds(616, 0, 168, 29);
		menu.add(lblMonedas);
		
		lblPuntaje = new JLabel("Puntaje: 0");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(616, 40, 168, 29);
		menu.add(lblPuntaje);
		
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
				juego.detenerJuego();
				tienda.setVisible(true);
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
		
		panel.addMouseListener(new MouseListener() {
			
		public void mouseClicked(MouseEvent e) {
			int x,y;
			if(e.getClickCount()== 1){
				if(e.getButton()==MouseEvent.BUTTON1){
					x = e.getX();
					y = e.getY();
					if (juego.comprando()){ //se clicke� para ubicar la compra
						int grillaX = y/60;
						int grillaY = x/60;
						ubicarCompra(grillaX,grillaY);
					}
					else{ //se clicke� para levantar un powerup
						clickearPowerup(x,y);
					}	
				}
				
				if(e.getButton()==MouseEvent.BUTTON2){	
					x = e.getX();
					y = e.getY();
					if (juego.comprando()){ //se clicke� para ubicar la compra
						int grillaX = y/60;
						int grillaY = x/60;
						ubicarCompra(grillaX,grillaY);
					}
					else{ //se clicke� para levantar un powerup
						clickearPowerup(x,y);
					}
				}
				
				if(e.getButton()==MouseEvent.BUTTON3){ //se est� asignando un powerup a personaje			
					x = (e.getX()/60);
					y = (e.getY()/60);
					if(juego.hayEntidad(y, x)) {
						juego.asignarPowerup(x, y);
					}
				}
			}
				
				
			}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}

		});
	}

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

	public void quitarLabel(JLabel label) {
		panel.remove(label);
		panel.validate();
		panel.repaint();
	}

	public void updateLabel(JLabel label, int dir){
		label.setBounds(label.getX()+dir,label.getY(),label.getWidth(), label.getHeight());
		panel.repaint();
	}
	public void updateContadores(int pts, int mnd){
		lblPuntaje.setText("Puntaje: "+pts);
		lblMonedas.setText("Monedas: "+mnd);
	}
	public void insertar(JLabel label, int x, int y){
		label.setBounds(y, x, label.getWidth(), label.getHeight());
		panel.add(label);
		panel.repaint();
	}
	public void ubicarCompra(int grillaX, int grillaY){
		System.out.println("posicion de insercion (x,y):"+grillaX+";"+grillaY);
		if(!juego.hayEntidad(grillaX, grillaY)) {
			if(juego.esPersonaje())
				juego.comprarPersonaje(grillaX, grillaY);
			else
				juego.comprarObjeto(grillaX,grillaY);
			juego.reanudarJuego();
		}
		else
			System.out.println("En esa posicion hay");  
	}
	public void clickearPowerup(int x, int y){
		if(((panel.getComponentAt(x, y) != null) && (juego.hayEntidad(y/60, x/60) == false)) ) {
			juego.levantarPowerup();
			panel.remove(panel.getComponentAt(x, y));
			panel.repaint();
		}
	}
	
	public void ganoNivel() {
		JOptionPane.showMessageDialog(null, "A ganado el nivel");
		panel.removeAll();
		panel.repaint();
	}
	
	public void finalizoPartida(String mensaje) {
		int resp = JOptionPane.showConfirmDialog(null, "Usted a "+mensaje+"\n ¿Desea jugar de nuevo?", "Finalizo la partida", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		if(resp == 0)
			jugarDevuelta();
		else
			System.exit(0);
	}
	
	public void jugarDevuelta() {
		this.dispose();
		miVentanaJuego.main(null);
		
	}

}
