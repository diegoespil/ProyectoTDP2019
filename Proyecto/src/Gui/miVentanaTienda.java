package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.SwingConstants;
import Creadores.CreadorConVidaComprable.CreadorBarricadaDoble;
import Creadores.CreadorConVidaComprable.CreadorBarricadaSimple;
import Creadores.CreadorPersonaje.CreadorDustin;
import Creadores.CreadorPersonaje.CreadorHopper;
import Creadores.CreadorPersonaje.CreadorLucas;
import Creadores.CreadorPersonaje.CreadorMike;
import Creadores.CreadorPersonaje.CreadorOnce;
import Creadores.CreadorTemporal.CreadorGas;
import Creadores.CreadorTemporal.CreadorPortal;
import Entidad.Integrante.Personaje.Dustin;
import Entidad.Integrante.Personaje.Hopper;
import Entidad.Integrante.Personaje.Lucas;
import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Once;
import Entidad.Objeto.ConVida.BarricadaDoble;
import Entidad.Objeto.ConVida.BarricadaSimple;
import Entidad.Objeto.Temporal.GasVenenoso;
import Entidad.Objeto.Temporal.Portal;
import Juego.Juego;
import Tienda.Tienda;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class miVentanaTienda extends JFrame {

	private imagenfondo contentPane;
	private ImageIcon once = new ImageIcon("Imagenes//once_tienda.png");
	private ImageIcon dustin = new ImageIcon("Imagenes//dustin_tienda.png");
	private ImageIcon micke = new ImageIcon("Imagenes//micke_tienda.png");
	private ImageIcon lucas = new ImageIcon("Imagenes//lucas_tienda.png");
	private ImageIcon hopper = new ImageIcon("Imagenes//hopper_tienda.png");
	private ImageIcon barricada_1 = new ImageIcon("Imagenes//barricada1.png");
	private ImageIcon barricada_2 = new ImageIcon("Imagenes//barricada2.png");
	private ImageIcon gas = new ImageIcon("Imagenes//gas.png");
	private ImageIcon portal_trampa = new ImageIcon("Imagenes//portal.png");
	private Tienda shop;
	private static Juego juego;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentanaTienda frame = new miVentanaTienda(juego);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/

	/**
	 * Create the frame.
	 */
	public miVentanaTienda(Juego j) {
		juego = j;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 460, 450);
		contentPane = new imagenfondo();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		contentPane.setBackground("Imagenes//fondoTienda.png");
		shop  = juego.getTienda();
		
		setContentPane(contentPane);
		
		/*
		 * Declaración de los JButton para la compra de objetos y personajes.
		 */
		
		JButton  jbDustin = new JButton ("$50");
		
		jbDustin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorDustin(),Dustin.getPrecio());
				shop.setEsPersonaje(true);
				setVisible(false);
			}
		});
		jbDustin.setBounds(117, 205, 70, 25); 
		contentPane.add(jbDustin);
		
		JButton  jbLucas = new JButton ("$70");
		
		jbLucas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorLucas(),Lucas.getPrecio());
				shop.setEsPersonaje(true);
				setVisible(false);
			}
		});
		jbLucas.setBounds(40, 205, 70, 25);
		contentPane.add(jbLucas);
		
		JButton  jbMike = new JButton ("$70");
		
		jbMike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorMike(),Mike.getPrecio());
				shop.setEsPersonaje(true);
				setVisible(false);
			}
		});
		jbMike.setBounds(192, 205, 70, 25);
		contentPane.add(jbMike);
		
		JButton  jbHopper = new JButton ("$100");
		
		jbHopper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorHopper(),Hopper.getPrecio());
				shop.setEsPersonaje(true);
				setVisible(false);
			}
		});
		jbHopper.setBounds(344, 205, 70, 25);
		contentPane.add(jbHopper);
		
		JButton  jbOnce = new JButton ("$150");
		jbOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorOnce(),Once.getPrecio());
				shop.setEsPersonaje(true);
				setVisible(false);
			}
		});
		jbOnce.setBounds(270, 205, 70, 25);
		contentPane.add(jbOnce);
		
		JButton  JbBarricada1 = new JButton ("$30");
		
		JbBarricada1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorBarricadaSimple(),BarricadaSimple.getPrecio());
				shop.setEsPersonaje(false);
				setVisible(false);
			}
		});
		JbBarricada1.setBounds(40, 360, 70, 25);
		contentPane.add(JbBarricada1);
		
		JButton jbGasVenenoso = new JButton ("$50");
		
		jbGasVenenoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorGas(),GasVenenoso.getPrecio());
				shop.setEsPersonaje(false);
				setVisible(false);
			}
		});
		jbGasVenenoso.setBounds(235, 360, 70, 25);
		contentPane.add(jbGasVenenoso);
		
		JButton  jbBarricada2 = new JButton ("$60");
		
		jbBarricada2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorBarricadaDoble(),BarricadaDoble.getPrecio());
				shop.setEsPersonaje(false);
				setVisible(false);
			}
		});
		jbBarricada2.setBounds(135, 360, 70, 25);
		contentPane.add(jbBarricada2);
		
		JButton jbPortal = new JButton("$100");
		
		jbPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop.crear(new CreadorPortal(),Portal.getPrecio());
				shop.setEsPersonaje(false);
				setVisible(false);
			}
		});
		jbPortal.setBounds(330, 360, 70, 25);
		contentPane.add(jbPortal);
		
		/*
		 * Se declaran las imagenes de los personajes y objetos a comparar.
		 */
		
		JLabel jlLucas = new JLabel("");
		jlLucas.setHorizontalAlignment(SwingConstants.CENTER);
		jlLucas.setBackground(Color.LIGHT_GRAY);
		jlLucas.setIcon(new ImageIcon(lucas.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		jlLucas.setBounds(44, 120, 60, 60);
		contentPane.add(jlLucas);
		
		JLabel jlDustin = new JLabel("");
		jlDustin.setIcon(new ImageIcon(dustin.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		jlDustin.setBounds(119, 120, 60, 60);
		contentPane.add(jlDustin);
		
		JLabel jlMike = new JLabel("");
		jlMike.setIcon(new ImageIcon(micke.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		jlMike.setBounds(194, 120, 60, 60);
		contentPane.add(jlMike);
		
		JLabel Once = new JLabel("");
		Once.setIcon(new ImageIcon(once.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Once.setBounds(269, 120, 60, 60);
		contentPane.add(Once);
		
		JLabel jlHopper = new JLabel("");
		jlHopper.setIcon(new ImageIcon(hopper.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		jlHopper.setEnabled(true);
		jlHopper.setBounds(344, 120, 60, 60);
		contentPane.add(jlHopper);
		
		JLabel barricada1 = new JLabel("");
		barricada1.setHorizontalAlignment(SwingConstants.CENTER);
		barricada1.setBackground(Color.LIGHT_GRAY);
		barricada1.setIcon(new ImageIcon(barricada_1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		barricada1.setBounds(44, 277, 60, 60);
		contentPane.add(barricada1);
		
		JLabel barricada2 = new JLabel("");
		barricada2.setHorizontalAlignment(SwingConstants.CENTER);
		barricada2.setBackground(Color.LIGHT_GRAY);
		barricada2.setIcon(new ImageIcon(barricada_2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		barricada2.setBounds(137, 277, 60, 60);
		contentPane.add(barricada2);
		
		JLabel gas_venenoso = new JLabel("");
		gas_venenoso.setHorizontalAlignment(SwingConstants.CENTER);
		gas_venenoso.setBackground(Color.LIGHT_GRAY);
		gas_venenoso.setIcon(new ImageIcon(gas.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		gas_venenoso.setBounds(242, 277, 60, 60);
		contentPane.add(gas_venenoso);
		
		JLabel portal = new JLabel("");
		portal.setHorizontalAlignment(SwingConstants.CENTER);
		portal.setBackground(Color.LIGHT_GRAY);
		portal.setIcon(new ImageIcon(portal_trampa.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		portal.setBounds(330, 277, 60, 60);
		contentPane.add(portal);
		
		/*
		 * Se declaran las etiquetas de los nombres de personajes y objetos a comparar.
		 */
		
		JLabel lblPersonajes = new JLabel("Personajes");
		lblPersonajes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPersonajes.setForeground(Color.WHITE);
		lblPersonajes.setBounds(190, 75, 82, 24);
		contentPane.add(lblPersonajes);
		
		JLabel lblObjetos = new JLabel("Objetos");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setBounds(190, 252, 58, 14);
		contentPane.add(lblObjetos);
		
		JLabel lblLucas = new JLabel("Lucas");
		lblLucas.setForeground(Color.WHITE);
		lblLucas.setBounds(60, 185, 45, 14);
		contentPane.add(lblLucas);
		
		JLabel lblDustin = new JLabel("Dustin");
		lblDustin.setForeground(Color.WHITE);
		lblDustin.setBounds(130, 185, 45, 14);
		contentPane.add(lblDustin);
		
		JLabel lblMike = new JLabel("Mike");
		lblMike.setForeground(Color.WHITE);
		lblMike.setBounds(205, 185, 45, 14);
		contentPane.add(lblMike);
		
		JLabel lblOnce = new JLabel("Once");
		lblOnce.setForeground(Color.WHITE);
		lblOnce.setBounds(282, 185, 45, 14);
		contentPane.add(lblOnce);
		
		JLabel lblHopper = new JLabel("Hopper");
		lblHopper.setForeground(Color.WHITE);
		lblHopper.setBounds(354, 185, 65, 14);
		contentPane.add(lblHopper);
			
		JLabel lbBarricadax1 = new JLabel("BarricadaX1");
		lbBarricadax1.setForeground(Color.WHITE);
		lbBarricadax1.setBounds(35, 340, 100, 14);
		contentPane.add(lbBarricadax1);
		
		JLabel lbBarricadax2 = new JLabel("BarricadaX2");
		lbBarricadax2.setForeground(Color.WHITE);
		lbBarricadax2.setBounds(130, 340, 100, 14);
		contentPane.add(lbBarricadax2);
		
		JLabel lblGasVenenoso = new JLabel("Gas venenoso");
		lblGasVenenoso.setForeground(Color.WHITE);
		lblGasVenenoso.setBounds(225, 340, 100, 14);
		contentPane.add(lblGasVenenoso);
		
		JLabel lblPortal = new JLabel("Portal");
		lblPortal .setForeground(Color.WHITE);
		lblPortal .setBounds(340, 340, 100, 14);
		contentPane.add(lblPortal);	
	}
	
}
