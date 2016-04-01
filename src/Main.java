/*
 * Per (de)codificare un messaggio: 
 * - inserire il testo
 * - inizializzare Enigma con le posizioni dei tre rotori(fast,medium,slow)
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "ebpktwwntvls";
		Enigma e = new Enigma("Rotore01", 0, "Rotore02", 0, "Rotore03", 0);
		e.code(text);
	}
}
