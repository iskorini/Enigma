package Core;/*
 * Questa classe implementa la macchina Core.Enigma:
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

	public Enigma(String f, int fast, String m, int med, String s, int slow) {
		// Inizializzazione di Core.Enigma dai file prescelti
		String std_path = System.getProperty("user.dir")+"/src/Core/Files";
		plugboard = new Plugboard(Util.readLineN(std_path+"/Plugboard/Plugboard01"));
		reflector = new Reflector(Util.readLineN(std_path+"/Reflector/Reflector01"));
		rotFast = new Rotore(Util.readLineN(std_path+"/Rotori/" + f));
		rotMed = new Rotore(Util.readLineN(std_path+"/Rotori/" + m));
		rotSlow = new Rotore(Util.readLineN(std_path+"/Rotori/" + s));
		setEnigma(fast, med, slow);
	}

	private void setEnigma(int fast, int med, int slow) {
		for (int i = 0; i < fast; i++) {
			rotFast.rotate();
		}
		for (int i = 0; i < med; i++) {
			rotMed.rotate();
		}
		for (int i = 0; i < slow; i++) {
			rotSlow.rotate();
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
	CODIFICA UN INTERA STRINGA
	 */
	public String code(String s) {
		String final_result = "";
		for (int i = 0; i < s.length(); i++) {
			String res = this.code(s.charAt(i));
			final_result+=res;
		}
		return final_result;
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
