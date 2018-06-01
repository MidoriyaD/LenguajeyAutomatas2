/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import compilador.simbolos.Simbolo;
import compilador.simbolos.TablaSimboloBase;
/**
 *
 * @author Mi pc
 */
public class VentanaSimbolos extends JDialog{
   private static final long serialVersionUID = 1L;

	private JScrollPane jcJScrollPane;

	private JTable symbolDataTable;
	private DefaultTableModel model;

	public VentanaSimbolos(JFrame parent, boolean modal) {
		super(parent, modal);
		super.setTitle("Tabla de Símbolos");
		initComponents();
		loadSymbolDataTable();
	}

	public void initComponents() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(400, 500);
		setLocation(100, 200);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		symbolDataTable = new JTable();
		symbolDataTable.setEnabled(false);
		jcJScrollPane = new JScrollPane(symbolDataTable);
		jcJScrollPane.setViewportView(symbolDataTable);
		jcJScrollPane.setBounds(10, 25, 375, 430);
		adicionarObjetos(jcJScrollPane);
	}

	public void adicionarObjetos(Component component) {
		getContentPane().add(component);
	}

	public void loadSymbolDataTable() {
		String titles[] = { "Token", "Lexema", "Palabra Reservada" };
		String data[][] = new String[0][3];
		model = new DefaultTableModel(data, titles);
		symbolDataTable.setModel(model);
		ArrayList<Simbolo> listaInicial = TablaSimboloBase.getInstance().getSimbolosInicial();

		if (!listaInicial.isEmpty()) {
			for (Simbolo simbolo : listaInicial) {
				String row[] = { simbolo.getToken(), simbolo.getLexema(), (simbolo.isPalabraReservada() ? "Yes" : "No" ) };
				model.addRow(row);
			}
		}
	} 
}
