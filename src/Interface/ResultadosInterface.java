package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Grafos.AGMinimo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.border.Border;
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
	 * 
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
		// frame.add(new JScrollPane(table_1), BorderLayout.CENTER);
		frame.getContentPane().add(table_1, BorderLayout.CENTER);
		DefaultTableModel model = new DefaultTableModel();
		for (Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			model.addColumn(i);
			System.out.println(i + "i");
		}

		for (Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			for (Integer j = 1; j < resultado.getMatrizConPesos().length; j++) {
				if (i != j) {
					if (resultado.existeArista(i, j)) {
						model.addRow(new Object[] { i, j, resultado.getMatrizConPesos()[i][j] });
					} else {
						model.addRow(new Object[] { i, j, 0 });
					}
				}
			}
		}
		table_1.setModel(model);
		System.out.println(resultado.toString());

	}
	/*
	 * private String [] nombresColumnas= {"Espia", "Encontrarse con",
	 * "Tiene Mensaje", "Mensaje interceptado"}; private Object [][] datosFila={
	 * {"Mercurio", 2440.0, 0, false}, {"Venus", 6052.0, 0, false}, {"Saturno",
	 * 60268.0, 18, true}, {"Urano", 25559.0,17, true}, {"Neptuno", 24766.0,8,
	 * true}, {"Plutón", 1137.0,1, false} };
	 * 
	 * private String[] culimnaStrings() { String[] colum = new
	 * String[resultado.getMatrizConPesos().length]; for(Integer i = 0; i <
	 * resultado.getMatrizConPesos().length; i++) { //model.addColumn(i);
	 * colum[i]=i; System.out.println(i + "i"); }
	 * 
	 * } private Object [][] datos; private Set<Object[]> filas(){ Set<Object[]>
	 * franObjects= new HashSet<Object[]>(); for(Integer i = 0; i <
	 * resultado.getMatrizConPesos().length; i++) { for(Integer j = 0; j <
	 * resultado.getMatrizConPesos().length; j++) { if(resultado.existeArista(i, j))
	 * { //franObjects.add({i, j, resultado.getMatrizConPesos()[i][j]});
	 * franObjects.add(new Object[] {i, j, resultado.getMatrizConPesos()[i][j]}); }
	 * else { //model.addRow(new Object[] {i, j, 0}); franObjects.add(new Object[]
	 * {i, j, 0}); } } } return franObjects;
	 * 
	 * } private Set<ArrayList<Object>> filas(){ Set<ArrayList<Object>> franObjects=
	 * new HashSet<ArrayList<Object>>(); List<Object> listitaaaList= new
	 * ArrayList<Object>(); for(Integer i = 0; i <
	 * resultado.getMatrizConPesos().length; i++) { for(Integer j = 0; j <
	 * resultado.getMatrizConPesos().length; j++) { if(resultado.existeArista(i, j))
	 * { listitaaaList.add(i); listitaaaList.add(j);
	 * listitaaaList.add(resultado.getMatrizConPesos()[i][j]); //franObjects.add({i,
	 * j, resultado.getMatrizConPesos()[i][j]}); franObjects.add((ArrayList<Object>)
	 * listitaaaList); } else { listitaaaList.add(i); listitaaaList.add(j);
	 * listitaaaList.add(0); //model.addRow(new Object[] {i, j, 0});
	 * franObjects.add((ArrayList<Object>) listitaaaList); } listitaaaList.clear();
	 * } } return franObjects;
	 * 
	 * }
	 */
}
