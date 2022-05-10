package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Main.Espia;
import Main.Juego;

public class NombreEspias {

	private JFrame frame;
	private JTextField nombreEspia;
	private Juego juego;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public NombreEspias(boolean b, Juego j) {
		juego = j;
		initialize(b);
		//cargarGrafo = cg;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNDeLosEspias = new JLabel("Nombre de los espias:");
		lblNDeLosEspias.setForeground(Color.WHITE);
		lblNDeLosEspias.setBackground(Color.WHITE);
		lblNDeLosEspias.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNDeLosEspias.setBounds(20, 47, 181, 14);
		frame.getContentPane().add(lblNDeLosEspias);

		JButton btnCargar = new JButton("Cargar");

		nombreEspia = new JTextField(); // captura los nombres de los espias

		nombreEspia.setBounds(211, 45, 131, 20);
		frame.getContentPane().add(nombreEspia);
		nombreEspia.setColumns(10);

		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCargar.setBounds(352, 44, 72, 23);
		frame.getContentPane().add(btnCargar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(211, 220, 131, 23);
		frame.getContentPane().add(btnFinalizar);

		// functions
		btnCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCargar && !nombreEspia.getText().isEmpty()) {
					juego.agregarEspia(nombreEspia.getText());
					System.out.println(nombreEspia.getText());
				}
				borrar();

			}

			public void borrar() {
				nombreEspia.setText(null);
			}

		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ImprimirGrafo imprimirGrafo = new ImprimirGrafo(true);
				//cargarGrafo.getFrame().setVisible(true);
				//frame.setVisible(false);
				CargarGrafo cg = new CargarGrafo(true, juego);
				frame.setVisible(false);
			}
		});

	}
}
