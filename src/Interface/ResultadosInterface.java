package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Grafos.AGMinimo;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadosInterface {

	private JFrame frame;
	private AGMinimo resultado;
	private JTable table_1;

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
		
		table_1 = new JTable();
		table_1.setBounds(62, 42, 299, 164);
		frame.getContentPane().add(table_1);
		DefaultTableModel model = new DefaultTableModel();
		for(Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			model.addColumn(i);
		}
		
		for(Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			for(Integer j = 0; j < resultado.getMatrizConPesos().length; j++) {
				if(resultado.existeArista(i, j)) {
					model.addRow(new Object[] {i, j, resultado.getMatrizConPesos()[i][j]});
				} else {
					model.addRow(new Object[] {i, j, 0});
				}
			}
		}
		table_1.setModel(model);
		System.out.println(resultado.toString());
		
		
	}
}
