package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Grafos.AGMinimo;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ResultadosInterface {

	private JFrame frame;
	private AGMinimo resultado;

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
	public ResultadosInterface(boolean b, AGMinimo res) {
		resultado = res;
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
		
		JLabel lblNewLabel = new JLabel("RESULTADOS:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNewLabel.setBounds(163, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);
		
		System.out.println(resultado.toString());
		JLabel lblNewLabel_1 = new JLabel(resultado.toString());
		lblNewLabel_1.setBounds(180, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}

}
