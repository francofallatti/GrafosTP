package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.Juego;

import javax.swing.JButton;

public class MainInterface {

	private JFrame frame;
	private JLabel lblTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Temible operario del");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont(new Font("Joystix", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 64, 400, 38);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblTitulo2 = new JLabel("recontraespionaje");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setBackground(Color.WHITE);
		lblTitulo2.setFont(new Font("Joystix", Font.PLAIN, 18));
		lblTitulo2.setBounds(10, 113, 400, 14);
		frame.getContentPane().add(lblTitulo2);
		
		JButton btnJugar = new JButton("Jugar!");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = Juego.iniciarJuego();
				//CargarGrafo cg = new CargarGrafo(false, juego);
				NombreEspias nombreEspias = new NombreEspias(true,juego);
				frame.setVisible(false);
			}
		});
		btnJugar.setBounds(167, 184, 89, 23);
		frame.getContentPane().add(btnJugar);
	}
}
