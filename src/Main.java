/*
 * Per codificare un messaggio: 
 * - dichiarare il plaintext
 * - inizializzare Enigma con le posizioni dei tre rotori(fast,medium,slow)
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plaintext = "ebpktwwntvls";
		Enigma e = new Enigma(0, 0, 0);
		e.code(plaintext);
	}
}
