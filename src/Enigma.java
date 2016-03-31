/*
 * Questa classe implementa la macchina Enigma:
 * ha bisogno di tre parametri interi che rappresentano di quanti
 * "scatti" spostare in avanti i rotori in partenza.
 */

public class Enigma {

	private Plugboard plugboard;
	private Rotore rotFast;
	private Rotore rotMed;
	private Rotore rotSlow;
	private Reflector reflector;
	private int j = 0;
	private int k = 0;

	public Enigma(int fast, int med, int slow) {
		// Inizializzazione di Enigma dai file prescelti
		plugboard = new Plugboard(Util.readLineN("Plugboard/Plugboard01"));
		reflector = new Reflector(Util.readLineN("Reflector/Reflector01"));
		rotFast = new Rotore(Util.readLineN("Rotori/Rotore01"));
		for (int i = 0; i < fast; i++) {
			rotFast.rotate();
		}
		rotMed = new Rotore(Util.readLineN("Rotori/Rotore02"));
		for (int i = 0; i < med; i++) {
			rotMed.rotate();
		}
		rotSlow = new Rotore(Util.readLineN("Rotori/Rotore03"));
		for (int i = 0; i < slow; i++) {
			rotSlow.rotate();
		}
	}

	public void code(String s) {
		for (int i = 0; i < s.length(); i++) {
			rotate(); // rotazione dei rotori
			char res = plugboard.code(s.charAt(i)); // entra nella plugboard
			res = rotFast.going(res); 	// entra nel rotore veloce
			res = rotMed.going(res); 	// nel medio
			res = rotSlow.going(res); 	// nel lento
			res = reflector.code(res);	// nel reflector
			res = rotSlow.comeBack(res);// torna nel rotore lento
			res = rotMed.comeBack(res);	// nel medio
			res = rotFast.comeBack(res);// nel veloce
			res = plugboard.code(res);	//nella plugboard
			System.out.print(res);		// stampa a video il risultato
			try {
				Thread.sleep(300);	// "velocita' di decodifica"
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("\b");  
		}
	}

	private void rotate() {
		rotFast.rotate();
		j++;
		if (j % 26 == 0) {
			rotMed.rotate();
			k++;
			if (k % 26 == 0) {
				rotSlow.rotate();
			}
		}
	}
}
