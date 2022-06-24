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

	public MainInterface() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblTitulo = new JLabel("Temible operario del recontraespionaje");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setBounds(10, 74, 414, 38);
		frame.getContentPane().add(lblTitulo);

		JButton btnJugar = new JButton("Comenzar!");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = Juego.iniciarJuego();
				CargarEspias nombreEspias = new CargarEspias(true, juego);
				frame.setVisible(false);
			}
		});
		btnJugar.setBounds(159, 123, 109, 23);
		frame.getContentPane().add(btnJugar);
	}
}
