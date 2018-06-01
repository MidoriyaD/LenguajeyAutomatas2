/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

import java.util.ArrayList;

import compilador.simbolos.Simbolo;
import compilador.simbolos.TablaSimboloBase;/**
 *
 * @author Mi pc
 */
public class Lexico {
    private ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
	
	private String logSalida = "";

	public void analizarLinea(String linea) {
		simbolos.clear();
		logSalida = "";
		char[] caracteres = linea.toCharArray();
		String lexema = "";
		boolean flagChar = false;
		for (int i = 0; i < caracteres.length; i++) {
			String caracter = caracteres[i] + "";
			if (flagChar) {
				if (caracter.equalsIgnoreCase("\"")) {
					flagChar = false;
					Simbolo simbolo = new Simbolo("string", lexema, false);
					this.logSalida += "\tToken: " + simbolo.getToken() + " Lexema: " + simbolo.getLexema() + "\n";
					this.simbolos.add(simbolo);
					analizarLexema(caracter);
					lexema = "";
					continue;
				}
				lexema += caracter;
				continue;
			}
			if (TablaSimboloBase.getInstance().isLexemaSimbolo(caracter)) {
				if (caracter.equalsIgnoreCase("\"")) {
					flagChar = true;
				}	
				if (!lexema.isEmpty()) {
					analizarLexema(lexema);
				}
				analizarLexema(caracter);
				lexema = "";
			} else if (caracter.equalsIgnoreCase(" ")) {
				if (!lexema.isEmpty()) {
					analizarLexema(lexema);
				}
				lexema = "";
			} else {
				lexema += caracter;
			}
		}
		if (!lexema.isEmpty()) {
			analizarLexema(lexema);
		}
	}

	private void analizarLexema(String lexema) {
		Simbolo simbolo = TablaSimboloBase.getInstance().getSimboloByLexema(lexema);
		if (null == simbolo) {
			if (Automatas.isIdentificador(lexema))
				simbolo = new Simbolo("id", lexema, false);
			else if (Automatas.isNumero(lexema))
				simbolo = new Simbolo("n_int", lexema, false);
			else if (Automatas.isReal(lexema))
				simbolo = new Simbolo("n_float", lexema, false);
			
			if (!TablaSimboloBase.getInstance().existLexemaId(lexema)) {
				TablaSimboloBase.getInstance().getSimbolosInicial().add(simbolo);
			}			
		}
		if (null != simbolo) {
			this.logSalida += "\tToken: " + simbolo.getToken() + " Lexema: " + simbolo.getLexema() + "\n";
			this.simbolos.add(simbolo);
		} else {
			this.logSalida += "\tERROR: " + lexema + "\n";
		}
	}
	
	public ArrayList<Simbolo> getSimbolos() {
		return simbolos;
	}

	public void setSimbolos(ArrayList<Simbolo> simbolos) {
		this.simbolos = simbolos;
	}

	public String getLogSalida() {
		return logSalida;
	}

	public void setLogSalida(String logSalida) {
		this.logSalida = logSalida;
	}
}
