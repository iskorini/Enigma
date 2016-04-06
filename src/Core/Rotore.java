package Core;

/**
 * Created by marcoburacchi on 30/03/16.
 */

/*
 * Questa classe implementa i rotori di Core.Enigma
 */

public class Rotore {

	private char[] ring = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	protected char[] out = new char[26];

	public Rotore(char[] set) {
		for (int i = 0; i < 26; i++) {
			out[i] = set[i];
		}
	}

	public void rotateRotor() {
		char temp = out[25]; // salvo l'ultima lettera
		for (int i = 24; i >= 0; i--) { // sposto di una posizione tutte le
										// altre
			out[i + 1] = out[i]; // l'ultima la metto in testa
		}
		out[0] = temp;
	}

	public void rotateRing(int n) {
		for (int j = 0; j < n; j++) {
			char temp = ring[25]; // salvo l'ultima lettera
			for (int i = 24; i >= 0; i--) { // sposto di una posizione tutte le
											// altre
				ring[i + 1] = ring[i]; // l'ultima la metto in testa
			}
			ring[0] = temp;
		}
	}

	public char going(char a) {
		return out[Util.convertLetter(a)];
	}

	public char comeBack(char a) {
		int i = Util.searchLetter(out, a);
		return (char) (i + 97);
	}

}
