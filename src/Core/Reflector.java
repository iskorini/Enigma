package Core;

public class Reflector {
	
	private char[] from = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	private char[] to = new char[26];

	public Reflector(char[] set) {
		setTo(set);
	}

	private void setTo(char[] set) {
		for (int i = 0; i < 26; i++) {
			to[i] = set[i];
		}
	}

	public char code(char a) {
		return to[Util.convertLetter(from[Util.convertLetter(a)])];
	}


}
