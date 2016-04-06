package Core;

/**
 * Created by marcoburacchi on 30/03/16.
 */
/*
 * Questa classe implementa la macchina Core.Enigma: ha bisogno di tre parametri
 * interi che rappresentano di quanti "scatti" spostare in avanti i rotori in
 * partenza.
 */

public class Enigma {

	// Inizializzazione di Core.Enigma dai file prescelti
	String std_path = System.getProperty("user.dir") + "/src/Core/Files";

	private Plugboard plugboard;
	private Rotore rotFast;
	private Rotore rotMed;
	private Rotore rotSlow;
	private Reflector reflector;
	private int j = 0;
	private int k = 0;

	public Enigma(String f, int ringFast, String m, int ringMed, String s,
			int ringSlow) {
		// Walzenlage - Wheel order
		setWalzenlage(f, m, s);

		// Ringstellung - Position of the alphabet ring relative rotor wiring
		setRingstellung(ringFast, ringMed, ringSlow);

		// Steckerverbindungen - Connections of the plugs in the plugboard
		plugboard = new Plugboard();

		// Reflector
		reflector = new Reflector(Util.readLineN(std_path
				+ "/Reflector/Reflector01"));
	}

	private void setWalzenlage(String f, String m, String s) {
		rotFast = new Rotore(Util.readLineN(std_path + "/Rotori/" + f));
		rotMed = new Rotore(Util.readLineN(std_path + "/Rotori/" + m));
		rotSlow = new Rotore(Util.readLineN(std_path + "/Rotori/" + s));
	}

	private void setRingstellung(int ringFast, int ringMed, int ringSlow) {
		rotFast.rotateRing(ringFast);
		rotMed.rotateRing(ringMed);
		rotSlow.rotateRing(ringSlow);
	}

	public void setGrundstellung(char fast, char med, char slow) {
		for (int i = 0; i < Util.convertLetter(fast); i++) {
			rotFast.rotateRotor();
		}
		for (int i = 0; i < Util.convertLetter(med); i++) {
			rotMed.rotateRotor();
		}
		for (int i = 0; i < Util.convertLetter(slow); i++) {
			rotSlow.rotateRotor();
		}
	}

	public String code(char text) {
		rotate(); // rotazione dei rotori
		char res = plugboard.code(text); // entra nella plugboard
		res = rotFast.going(res); // entra nel rotore veloce
		res = rotMed.going(res); // nel medio
		res = rotSlow.going(res); // nel lento
		res = reflector.code(res); // nel reflector
		res = rotSlow.comeBack(res);// torna nel rotore lento
		res = rotMed.comeBack(res); // nel medio
		res = rotFast.comeBack(res);// nel veloce
		res = plugboard.code(res); // nella plugboard
		return String.valueOf(res);
	}

	/*
	 * CODIFICA UN INTERA STRINGA
	 */
	public String code(String s) {
		String final_result = "";
		for (int i = 0; i < s.length(); i++) {
			String res = code(s.charAt(i));
			final_result += res;
		}
		return final_result;
	}

	private void rotate() {
		rotFast.rotateRotor();
		j++;
		if (j % 26 == 0) {
			rotMed.rotateRotor();
			k++;
			if (k % 26 == 0) {
				rotSlow.rotateRotor();
			}
		}
	}

}
