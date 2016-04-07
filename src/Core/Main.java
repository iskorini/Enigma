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
			System.out.print("Enter fast rotor\n");
			String r1 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r1)) {
				System.out
						.print("Entered rotor doesn't exists, enter fast rotor\n");
				r1 = console.readLine();
				Util.clearScreen();
			}

			// Med rotor
			System.out.print("Enter medium rotor\n");
			String r2 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r2)) {
				System.out
						.print("Entered rotor doesn't exists, enter medium rotor\n");
				r2 = console.readLine();
				Util.clearScreen();
			}

			// Slow rotor
			System.out.print("Enter slow rotor\n");
			String r3 = console.readLine();
			Util.clearScreen();
			while (Util.checkRotor(r3)) {
				System.out
						.print("Entered rotor doesn't exists, enter slow rotor\n");
				r3 = console.readLine();
				Util.clearScreen();
			}

			// Fast ring
			System.out.print("Enter first alphabetical ring start position\n");
			String n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter first alphabetical ring start position\n");
				n = console.readLine();
			}
			int p1 = Integer.parseInt(n);
			Util.clearScreen();
			while (p1 < 0 || p1 > 25) {
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter first alphabetical ring start position\n");
				n = console.readLine();
				while (Util.checkInt(n)) {
					Util.clearScreen();
					System.out
							.print("The starting position should be a number between 0 and 25\n");
					System.out
							.print("Enter first alphabetical ring start position\n");
					n = console.readLine();
				}
				p1 = Integer.parseInt(n);
				Util.clearScreen();
			}

			// Med ring
			System.out.print("Enter second alphabetical ring start position\n");
			n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter second alphabetical ring start position\n");
				n = console.readLine();
			}
			int p2 = Integer.parseInt(n);
			Util.clearScreen();
			while (p2 < 0 || p2 > 25) {
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter second alphabetical ring start position\n");
				n = console.readLine();
				while (Util.checkInt(n)) {
					Util.clearScreen();
					System.out
							.print("The starting position should be a number between 0 and 25\n");
					System.out
							.print("Enter second alphabetical ring start position\n");
					n = console.readLine();
				}
				p2 = Integer.parseInt(n);
				Util.clearScreen();
			}

			// Slow ring
			System.out.print("Enter third alphabetical ring start position\n");
			n = console.readLine();
			while (Util.checkInt(n)) {
				Util.clearScreen();
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter third alphabetical ring start position\n");
				n = console.readLine();
			}
			int p3 = Integer.parseInt(n);
			Util.clearScreen();
			while (p3 < 0 || p3 > 25) {
				System.out
						.print("The starting position should be a number between 0 and 25\n");
				System.out
						.print("Enter third alphabetical ring start position\n");
				n = console.readLine();
				while (Util.checkInt(n)) {
					Util.clearScreen();
					System.out
							.print("The starting position should be a number between 0 and 25\n");
					System.out
							.print("Enter third alphabetical ring start position\n");
					n = console.readLine();
				}
				p3 = Integer.parseInt(n);
				Util.clearScreen();
			}

			// Enigma starting
			Enigma e = new Enigma(r1, p1, r2, p2, r3, p3);

			// Initial position of the fast rotor
			System.out.print("Enter rotor start position(fast,medium,slow)\n");
			String grundstellung = console.readLine();
			Util.clearScreen();
			while (grundstellung.length() != 3) {
				System.out
						.print("The starting position must be composed of 3 letters\n");
				System.out
						.print("Enter rotor start position(fast,medium,slow)\n");
				grundstellung = console.readLine();
				Util.clearScreen();
			}
			while (Util.checkChar(grundstellung.charAt(0))
					|| Util.checkChar(grundstellung.charAt(1))
					|| Util.checkChar(grundstellung.charAt(2))) {
				System.out.print("Entered letters are incorrect\n");
				System.out
						.print("Enter rotor start position(fast,medium,slow)\n");
				grundstellung = console.readLine();
				Util.clearScreen();
				while (grundstellung.length() != 3) {
					System.out
							.print("The starting position must be composed of 3 letters\n");
					System.out
							.print("Enter rotor start position(fast,medium,slow)\n");
					grundstellung = console.readLine();
					Util.clearScreen();
				}
			}
			e.setGrundstellung(grundstellung.charAt(0),
					grundstellung.charAt(1), grundstellung.charAt(2));

			System.out.print("Enter the letter to be encrypted (end with !)\n");
			char text = console.readLine().charAt(0);
			Util.clearScreen();
			while (text != '!') {
				while (Util.checkChar(text)) {
					System.out.print("Entered letter is incorrect\n");
					System.out
							.print("Enter the letter to be encrypted (end with !)\n");
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
