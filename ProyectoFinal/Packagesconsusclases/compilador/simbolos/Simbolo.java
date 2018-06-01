/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.simbolos;

/**
 *
 * @author Mi pc
 */
public class Simbolo {
    private String token;
	private String lexema;
	private boolean palabraReservada;
	
	public Simbolo(String token, String lexema, boolean palabraReservada) {
		this.token = token;
		this.lexema = lexema;
		this.palabraReservada = palabraReservada;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public boolean isPalabraReservada() {
		return palabraReservada;
	}

	public void setPalabraReservada(boolean palabraReservada) {
		this.palabraReservada = palabraReservada;
	}
}
