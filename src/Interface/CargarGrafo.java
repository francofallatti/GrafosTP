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
import javax.swing.SpinnerModel;

import Main.Espia;
import Main.Juego;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.SpinnerNumberModel;

public class CargarGrafo {

	private JFrame frame;
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
	public CargarGrafo(boolean b, Juego j) {
		juego = j;
		juego.cargarEncuentros();
		initialize(b);
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

		JLabel lblEspiasAEncontrarse = new JLabel("Espias a encontrarse:");
		lblEspiasAEncontrarse.setForeground(Color.WHITE);
		lblEspiasAEncontrarse.setBackground(Color.WHITE);
		lblEspiasAEncontrarse.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblEspiasAEncontrarse.setBounds(21, 39, 181, 14);
		frame.getContentPane().add(lblEspiasAEncontrarse);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(247, 36, 131, 20);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel<String> espias = new DefaultComboBoxModel<String>();
		espias.addAll(juego.getEspiasKey());
		comboBox.setModel(espias);
		
		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(247, 67, 131, 20);
		frame.getContentPane().add(comboBox2);
		DefaultComboBoxModel<String> espias2 = new DefaultComboBoxModel<String>();
		espias2.addAll(juego.getEspiasKey());
		comboBox2.setModel(espias2);
	

		JButton btnGuardar = new JButton("Guardar Encuentro");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setBounds(247, 166, 131, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(150, 200, 131, 23);
		frame.getContentPane().add(btnFinalizar);

		
		JLabel lblProbabilidadDeIntercepcion = new JLabel("probabilidad de intercepcion:");
		lblProbabilidadDeIntercepcion.setForeground(Color.WHITE);
		lblProbabilidadDeIntercepcion.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblProbabilidadDeIntercepcion.setBackground(Color.WHITE);
		lblProbabilidadDeIntercepcion.setBounds(20, 102, 217, 14);
		frame.getContentPane().add(lblProbabilidadDeIntercepcion);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
		spinner.setBounds(247, 99, 131, 20);
		frame.getContentPane().add(spinner);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnGuardar) {
					System.out.println("Espias: " + juego.getEspias());
					juego.agregarEncuentro(0.1, comboBox.getSelectedItem().toString(), comboBox2.getSelectedItem().toString());
					System.out.println("Espias a encontrarse: " + comboBox.getSelectedItem().toString() + "y"+ comboBox2.getSelectedItem().toString());
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ImprimirGrafo imprimirGrafo = new ImprimirGrafo(true);
				frame.setVisible(false);
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}
}
