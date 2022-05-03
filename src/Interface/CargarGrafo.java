package Interface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CargarGrafo {

	private JFrame frame;
	private JTextField nombreEspia;

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
	 * @wbp.parser.entryPoint
	 */
	public CargarGrafo(boolean b) {
		initialize(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombreDeLos = new JLabel("Nombre de los espias:");
		lblNombreDeLos.setBounds(20, 47, 147, 14);
		frame.getContentPane().add(lblNombreDeLos);
		
		JButton btnCargar = new JButton("Cargar");
		
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCargar.setBounds(316, 43, 72, 23);
		frame.getContentPane().add(btnCargar);
		
		nombreEspia = new JTextField(); //captura los nombres de los espias
		nombreEspia.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent k) {
				System.out.println(k.getKeyChar());
				btnCargar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(k.getKeyChar()+k.getKeyChar());
					}
				});
				
			}//poblema para alamcenar el nombreEspia a solucionar para imprimorlo en consola

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		nombreEspia.setBounds(177, 44, 131, 20);
		frame.getContentPane().add(nombreEspia);
		nombreEspia.setColumns(10);
		
		
		
		JLabel lblEspiasAEncontrarse = new JLabel("Espias a encontrarse:");
		lblEspiasAEncontrarse.setBounds(20, 106, 147, 14);
		frame.getContentPane().add(lblEspiasAEncontrarse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 103, 131, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Espia 1", "Fran"}));
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(177, 141, 131, 20);
		frame.getContentPane().add(comboBox2);
		comboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"Espia 2", "Cande"}));
		
		JButton btnNewButton = new JButton("Guardar Encuentro");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(177, 187, 131, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
