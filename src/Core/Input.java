package Core;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Input {

	public static int getInt(String message) {
		InputFrame inf = new InputFrame(message);
		String text = inf.text;
		int number;
		try {
			number = Integer.parseInt(text);
		} catch (NumberFormatException nfe) {
			number = -1;
		}
		return (number);
	}

	public static long getLong(String message) {
		InputFrame inf = new InputFrame(message);
		String text = inf.text;
		long number;
		try {
			number = Long.parseLong(text);
		} catch (NumberFormatException nfe) {
			number = 0;
		}
		return (number);
	}

	public static double getDouble(String message) {
		InputFrame inf = new InputFrame(message);
		String text = inf.text;
		double number;
		try {
			number = Double.parseDouble(text);
		} catch (NumberFormatException nfe) {
			number = 0;
		}
		return (number);
	}

	public static char getChar(String message) {
		InputFrame inf = new InputFrame(message);
		if (inf.text.length() > 0) {
			return (inf.text.charAt(0));
		} else {
			return (' ');
		}
	}

	public static String getString(String message) {
		InputFrame inf = new InputFrame(message);
		return (inf.text);
	}
}

class InputFrame extends JFrame {
	private static final long serialVersionUID = -4443589884569220404L;
	String text;

	public InputFrame(String message) {
		super();
		text = JOptionPane.showInputDialog(this, message);
		dispose();
	}
}
