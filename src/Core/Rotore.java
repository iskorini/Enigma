package Core;/*
 * Questa classe implementa i rotori di Core.Enigma
 */

public class Rotore {

	protected char[] out = new char[26];

	public Rotore(char[] set) {
		for (int i = 0; i < 26; i++) {
			out[i] = set[i];
		}
	}

	public void rotate() {
		char temp = out[25];			//salvo l'ultima lettera
		for (int i = 24; i >= 0; i--) { //sposto di una posizione tutte le altre
			out[i + 1] = out[i]; 		// l'ultima la metto in testa
		}
		out[0] = temp;
	}

	public char going(char a) {
		return out[Util.convertLetter(a)];
	}

	public char comeBack(char a) {
		for (int i = 0; i < 26; i++) {
			if (out[i] == a) {
				return (char) (i + 97);
			}
		}
		return ' ';
	}

}
