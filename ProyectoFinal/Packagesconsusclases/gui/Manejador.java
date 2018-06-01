/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import compilador.Compilador;
/**
 *
 * @author Mi pc
 */
public class Manejador implements ActionListener{
    private IndexCompilador indexCompilador;
	private JTextArea textArchivoEntrada;
	private JTextArea textArchivoSalida;
	private Compilador compilador;
	private boolean readyFile = false;
	
	public Manejador(IndexCompilador indexCompilador) {
		this.indexCompilador = indexCompilador;
		textArchivoEntrada = indexCompilador.getTextArchivoEntrada();
		textArchivoSalida = indexCompilador.getTextArchivoSalida();
	}

	public void actionPerformed(ActionEvent event) {
		if(((JButton)event.getSource()).getText().equalsIgnoreCase("Cargar Archivo"))
			cargarArchivo();
		if(((JButton)event.getSource()).getText().equalsIgnoreCase("Analizar"))
			analizar();
	}
	
	private void cargarArchivo(){
		File file = new File("");
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(indexCompilador);
		file = chooser.getSelectedFile();
		if(file != null){
			compilador = new Compilador(file, this);
			this.readyFile = true;
		}
	}
	
	private void analizar(){
		if(readyFile)
			compilador.analizar();
	}
	
	public void setTextEntrada(String string){
		this.textArchivoEntrada.setText(string);
		this.textArchivoSalida.setText("");
	}
	
	public void setTextSalida(String string){
		this.textArchivoSalida.setText(string);
	}
}
