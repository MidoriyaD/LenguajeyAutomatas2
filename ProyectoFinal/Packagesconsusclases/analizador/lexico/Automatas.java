/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

/**
 *
 * @author Mi pc
 */
public class Automatas {
    public static boolean isIdentificador(String lexema) {
		String letra = "[A-Za-z]";
		String digitoLetra = "[0-9A-Za-z]";
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(letra))
					estado = 2;
				else
					estado = 3;
				break;
			case 2:
				if (caracter.matches(digitoLetra))
					estado = 2;
				else
					estado = 3;
				break;
			}
		}
		if (estado != 3)
			return true;
		return false;
	}

	public static boolean isNumero(String lexema) {
		String digito = "[0-9]";
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(digito))
					estado = 1;
				else
					estado = 2;
				break;
			}
		}
		if (estado != 2)
			return true;
		return false;
	}

	public static boolean isReal(String lexema) {
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (Automatas.isNumero(caracter))
					estado = 1;
				else {
					estado = 2;
					i--;
				}
				break;
			case 2:
				if (caracter.equalsIgnoreCase("."))
					if (i + 1 != lexema.length())
						estado = 3;
					else
						estado = 4;
				else
					estado = 4;
				break;
			case 3:
				if (Automatas.isNumero(caracter)) {
					estado = 3;
				} else
					estado = 4;
				break;
			}
		}
		if (estado != 4)
			return true;
		return false;
	}
}
