import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			Util.clearScreen();
			
			System.out.print("Inserire rotore veloce\n");
			String r1 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r1)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore veloce\n");
				r1 = console.readLine();
				Util.clearScreen();
			}

			System.out.print("Inserire rotore medio\n");
			String r2 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r2)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore medio\n");
				r2 = console.readLine();
				Util.clearScreen();
			}

			System.out.print("Inserire rotore lento\n");
			String r3 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r3)) {
				System.out
						.print("Il rotore inserito non esiste, reinserire rotore lento\n");
				r3 = console.readLine();
				Util.clearScreen();
			}

			System.out.print("Inserire posizione partenza rotore veloce\n");
			int p1 = Integer.parseInt(console.readLine());
			Util.clearScreen();
			while (p1 < 0 || p1 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				p1 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			System.out.print("Inserire posizione partenza rotore medio\n");
			int p2 = Integer.parseInt(console.readLine());
			Util.clearScreen();
			while (p2 < 0 || p2 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				p2 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			System.out.print("Inserire posizione partenza rotore lento\n");
			int p3 = Integer.parseInt(console.readLine());
			Util.clearScreen();
			while (p3 < 0 || p3 > 25) {
				System.out
						.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
				p3 = Integer.parseInt(console.readLine());
				Util.clearScreen();
			}

			Enigma e = new Enigma(r1, p1, r2, p2, r3, p3);

			System.out
					.print("Inserire il carattere da (de)cifrare (terminare con !)\n");
			char text = console.readLine().charAt(0);
			Util.clearScreen();
			while (text != '!') {
				while (Util.checkChar(text)) {
					System.out.print("Inserito carattere illegale\n");
					text = console.readLine().charAt(0);
					Util.clearScreen();
				}
				Util.clearScreen();
				e.code(text);
				text = console.readLine().charAt(0);
				Util.clearScreen();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
