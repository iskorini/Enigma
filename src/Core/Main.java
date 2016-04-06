package Core;

/**
 * Created by marcoburacchi on 30/03/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			Util.clearScreen();

			// Fast rotor
			System.out.print("Inserire rotore veloce\n");
			String r1 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r1)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore veloce\n");
				r1 = console.readLine();
				Util.clearScreen();
			}

			// Med rotor
			System.out.print("Inserire rotore medio\n");
			String r2 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r2)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore medio\n");
				r2 = console.readLine();
				Util.clearScreen();
			}

			// Slow rotor
			System.out.print("Inserire rotore lento\n");
			String r3 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r3)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore lento\n");
				r3 = console.readLine();
				Util.clearScreen();
			}

			// Fast ring
			System.out
					.print("Inserire posizione partenza primo anello alfabetico\n");
			String n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out.print("Inserito carattere diverso da un numero\n");
				System.out
						.print("Inserire posizione partenza primo anello alfabetico\n");
				n = console.readLine();
			}
			int p1 = Integer.parseInt(n);
			Util.clearScreen();
			while (p1 < 0 || p1 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				System.out
				.print("Inserire posizione partenza primo anello alfabetico\n");
				p1 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			// Med ring
			System.out
					.print("Inserire posizione partenza secondo anello alfabetico\n");
			n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out.print("Inserito carattere diverso da un numero\n");
				System.out
						.print("Inserire posizione partenza secondo anello alfabetico\n");
				n = console.readLine();
			}
			int p2 = Integer.parseInt(n);
			Util.clearScreen();
			while (p2 < 0 || p2 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				System.out
				.print("Inserire posizione partenza secondo anello alfabetico\n");
				p2 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			// Slow ring
			System.out
					.print("Inserire posizione partenza terzo anello alfabetico\n");
			n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out.print("Inserito carattere diverso da un numero\n");
				System.out
						.print("Inserire posizione partenza terzo anello alfabetico\n");
				n = console.readLine();
			}
			int p3 = Integer.parseInt(n);
			Util.clearScreen();
			while (p3 < 0 || p3 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				System.out
				.print("Inserire posizione partenza terzo anello alfabetico\n");
				p3 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			// Enigma starting
			Enigma e = new Enigma(r1, p1, r2, p2, r3, p3);

			// Initial position of the fast rotor
			System.out
					.print("Inserire posizione partenza rotori(veloce,medio,lento)\n");
			String grundstellung = console.readLine();
			Util.clearScreen();
			while (grundstellung.length() != 3) {
				System.out
						.print("La posizione deve essere composta da 3 caratteri\n");
				System.out
				.print("Inserire posizione partenza rotori(veloce,medio,lento)\n");
				grundstellung = console.readLine();
				Util.clearScreen();
			}
			while (Util.checkChar(grundstellung.charAt(0))
					|| Util.checkChar(grundstellung.charAt(1))
					|| Util.checkChar(grundstellung.charAt(2))) {
				System.out.print("Sono stati inseriti dei caratteri errati\n");
				System.out
				.print("Inserire posizione partenza rotori(veloce,medio,lento)\n");
				grundstellung = console.readLine();
				Util.clearScreen();
				while (grundstellung.length() != 3) {
					System.out
							.print("La posizione deve essere composta da 3 caratteri\n");
					System.out
					.print("Inserire posizione partenza rotori(veloce,medio,lento)\n");
					grundstellung = console.readLine();
					Util.clearScreen();
				}
			}
			e.setGrundstellung(grundstellung.charAt(0),
					grundstellung.charAt(1), grundstellung.charAt(2));

			System.out
					.print("Inserire il carattere da (de)cifrare (terminare con !)\n");
			char text = console.readLine().charAt(0);
			Util.clearScreen();
			while (text != '!') {
				while (Util.checkChar(text)) {
					System.out.print("Inserito carattere illegale\n");
					System.out
					.print("Inserire il carattere da (de)cifrare (terminare con !)\n");
					text = console.readLine().charAt(0);
					Util.clearScreen();
				}
				Util.clearScreen();
				System.out.print(text + " ------> " + e.code(text) + "\n");
				text = console.readLine().charAt(0);
				Util.clearScreen();
			}
			console.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
