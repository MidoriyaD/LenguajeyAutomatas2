/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import gui.Manejador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import analizador.lexico.Lexico;
/**
 *
 * @author Mi pc
 */
public class Compilador {
    private Manejador manejador;
	private String pathSalida = "";
	private ArrayList<String> lineas = new ArrayList<String>();

	public Compilador(File archivoEntrada, Manejador manejador) {
		this.manejador = manejador;
		this.pathSalida = archivoEntrada.getParent() + "/salida.txt";
		this.cargarArchivo(archivoEntrada);
	}

	private void cargarArchivo(File archivoEntrada) {
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(archivoEntrada);
			bufferedReader = new BufferedReader(reader);
			while (bufferedReader.ready()) {
				this.lineas.add(bufferedReader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (null != reader)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		String textEntrada = "";
		int index = 0;
		for (String linea : this.lineas) {
			textEntrada += index + " " + linea + "\n";
			index++;
		}
		manejador.setTextEntrada(textEntrada);
	}

	public void analizar() {
		lexico();
	}

	private void lexico() {
		Lexico lexico = new Lexico();
		String logSalida = "";
		int index = 0;
		for (String linea : this.lineas) {
			lexico.analizarLinea(linea);
			logSalida += index + " " + linea + "\n";
			logSalida += lexico.getLogSalida();
			index++;
		}
		manejador.setTextSalida(logSalida);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(this.pathSalida);
			fileWriter.write(logSalida);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fileWriter) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
