package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plugboard {

	private char[] from = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	private char[] to = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	public Plugboard() {
		setTo();
	}

	private void setTo() {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		for (int i = 0; i < 10; i++) {
			System.out.print("Inserire la " + (i+1) + "° " + "coppia di connettori da collegare\n");
			char a;
			char b;
			try {
				String coppia = console.readLine();
				while (coppia.length() != 2){
					Util.clearScreen();
					System.out.print("Inserito un numero di caratteri errato\n");
					System.out.print("Inserire la " + (i+1) + "° " + "coppia di connettori da collegare\n");
					coppia = console.readLine();
				}
				a = coppia.charAt(0);
				b = coppia.charAt(1);
				while (Util.checkChar(a) || Util.checkChar(b)) {
					Util.clearScreen();
					System.out.print("Inserito carattere illegale\n");
					System.out.print("Inserire la " + (i+1) + "° " + "coppia di connettori da collegare\n");
					coppia = console.readLine();
					while (coppia.length() != 2){
						System.out.print("Inserito un numero di caratteri errato\n");
						System.out.print("Inserire la " + (i+1) + "° " + "coppia di connettori da collegare\n");
						coppia = console.readLine();
					}
					a = coppia.charAt(0);
					b = coppia.charAt(1);
				}
				to[Util.searchLetter(from, a)] = b;
				to[Util.searchLetter(from, b)] = a;
				Util.clearScreen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public char code(char a) {
		return to[Util.convertLetter(from[Util.convertLetter(a)])];
	}
	
}