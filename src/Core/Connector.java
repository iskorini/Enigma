package Core;/*
 * Con questa classe vengono rappresentati sia la plugboard che il reflector
 */

public abstract class Connector {

	private char[] from = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	private char[] to = new char[26];

	public Connector(char[] t) {
		for (int i = 0; i < 26; i++) {
			to[i] = t[i];
		}
	}

	public char code(char a) {
		return to[Util.convertLetter(from[Util.convertLetter(a)])];
	}

}
