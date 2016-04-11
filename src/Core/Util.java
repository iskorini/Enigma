
package Core;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Util {

	public static int convertLetter(char a) {
		return (int) a - 97;
	}

	public static void printArray(char[] y) {
		for (int i = 0; i < 26; i++) {
			System.out.print(y[i] + " | ");
		}
	}

	public static char[] readLineN(String fileName) {
		char[] res = new char[26];
		try {
			String line = "";
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			line = br.readLine();
			StringTokenizer lineTokens = new StringTokenizer(line, ",");
			for (int i = 0; i < 26; i++) {
				res[i] = lineTokens.nextToken().charAt(0);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean checkRotor(String s) {
		switch (s) {
		case "I":
			return false;
		case "II":
			return false;
		case "III":
			return false;
		case "IV":
			return false;
		case "V":
			return false;
		default:
			return true;
		}
	}
	
	public static boolean checkChar(char t){
		return (int)t < 97 || (int)t > 122;
	}
	
	public static boolean checkInt(String n){
		for(int i = 0; i < n.length(); i++){
			if (n.charAt(i) < 48 || n.charAt(i) > 57){
				return true;
			}
		}
		return false;
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }
	
	public static int searchLetter(char[] t, char a){
		int i = 0;
		while (t[i] != a) {
			i++;
		}
		return i;
	}
}
