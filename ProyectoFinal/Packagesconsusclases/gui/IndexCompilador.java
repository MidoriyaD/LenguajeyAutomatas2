/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;/**
 *
 * @author Mi pc
 */
public class IndexCompilador extends JFrame{

    /**
     * @param args the command line arguments
     */
   private static final long serialVersionUID = 3345263108329418543L;
	
	private JLabel labelTextoEntrada;
	private JLabel labelTextoAnalizar;
	private JTextArea textArchivoEntrada;
	private JScrollPane scrollEntrada;
	private JTextArea textArchivoSalida;
	private JScrollPane scrollSalida;
	private JButton botonCargarArchivo;
	private JButton botonAnalizarArchivo;
	//Botón ventana tabla símbolos
	private JButton botonTablaSimbolos;
	

	public IndexCompilador(){
		iniciarComponentes();
		asignarDimensiones();
		adicionarObjetos(labelTextoEntrada);
		adicionarObjetos(scrollEntrada);
		adicionarObjetos(botonCargarArchivo);
		adicionarObjetos(labelTextoAnalizar);
		adicionarObjetos(scrollSalida);
		adicionarObjetos(botonAnalizarArchivo);
		adicionarObjetos(botonTablaSimbolos);
		Manejador manejador = new Manejador(this);
		botonCargarArchivo.addActionListener(manejador);
		botonAnalizarArchivo.addActionListener(manejador);
	}
	
	public void  iniciarComponentes(){
		labelTextoEntrada = new JLabel("Texto de Entrada");
		labelTextoAnalizar = new JLabel("Texto de Salida");
		textArchivoEntrada = new JTextArea();
		textArchivoSalida = new JTextArea();
		botonCargarArchivo = new JButton("Cargar Archivo");
		botonAnalizarArchivo = new JButton("Analizar");
		//Asignar botón Tabla de Símbolos
		botonTablaSimbolos = new JButton("Tabla de Símbolos");
		botonTablaSimbolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSymbolDataTableActionPerformed(e);
			}
		});
		scrollEntrada = new JScrollPane(textArchivoEntrada);
		scrollSalida = new JScrollPane(textArchivoSalida);
	}
	
	public void asignarDimensiones(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Léxico");
        setResizable(false);
        setSize(650,500);
        setLocation(100,200);
        setDefaultLookAndFeelDecorated(true);
        getContentPane().setLayout( null );
        labelTextoEntrada.setBounds(10,10,100,10);
        scrollEntrada.setBounds(10,25,300,400);
        textArchivoEntrada.setEditable(false);
        botonCargarArchivo.setBounds(100,430,120,30);
        labelTextoAnalizar.setBounds(340,10,100,10);
        scrollSalida.setBounds(340,25,300,400);
        textArchivoSalida.setEditable(false);
        botonAnalizarArchivo.setBounds(420,430,120,30);
        botonTablaSimbolos.setBounds(250,430,140,30);
	}
	
	public void showSymbolDataTableActionPerformed(ActionEvent ev) {
		new VentanaSimbolos(this, true).setVisible(true);
	}
	
	public void adicionarObjetos(Component component){
		getContentPane().add(component);
	}
	
	public JTextArea getTextArchivoEntrada() {
		return textArchivoEntrada;
	}

	public JTextArea getTextArchivoSalida() {
		return textArchivoSalida;
	}

	public static void main(String args[]){
		new IndexCompilador().setVisible(true);
	}
}
