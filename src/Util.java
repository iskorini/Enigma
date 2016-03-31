/*
 * Classe di utilita'
 */


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
}
