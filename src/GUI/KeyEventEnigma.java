package GUI;

import Core.Enigma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by federicoschipani on 03/04/16.
 */
public class KeyEventEnigma implements KeyEventDispatcher {
    private Enigma enigma;
    private JLabel label;
    private int id;

    public KeyEventEnigma (Enigma enigma, JLabel label, int id) {
        this.enigma = enigma;
        this.label = label;
        this.id = id;
    }
    public KeyEventEnigma (int id ) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof KeyEventEnigma) {
            return this.id == ((KeyEventEnigma)obj).id;
        }
        return false;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        System.err.println(e.getKeyCode());
        System.err.println(KeyEvent.VK_A);
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                label.setText(label.getText() + String.valueOf(enigma.code('a')));
            } else if (e.getKeyCode() == KeyEvent.VK_B) {
                label.setText(label.getText() + String.valueOf(enigma.code('b')));
            } else if (e.getKeyCode() == KeyEvent.VK_C) {
                label.setText(label.getText() + String.valueOf(enigma.code('c')));
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                label.setText(label.getText() + String.valueOf(enigma.code('d')));
            }else if (e.getKeyCode() == KeyEvent.VK_E) {
                label.setText(label.getText() + String.valueOf(enigma.code('e')));
            }else if (e.getKeyCode() == KeyEvent.VK_F) {
                label.setText(label.getText() + String.valueOf(enigma.code('f')));
            }else if (e.getKeyCode() == KeyEvent.VK_G) {
                label.setText(label.getText() + String.valueOf(enigma.code('g')));
            }else if (e.getKeyCode() == KeyEvent.VK_H) {
                label.setText(label.getText() + String.valueOf(enigma.code('h')));
            }else if (e.getKeyCode() == KeyEvent.VK_I) {
                label.setText(label.getText() + String.valueOf(enigma.code('i')));
            }else if (e.getKeyCode() == KeyEvent.VK_J) {
                label.setText(label.getText() + String.valueOf(enigma.code('j')));
            }else if (e.getKeyCode() == KeyEvent.VK_K) {
                label.setText(label.getText() + String.valueOf(enigma.code('k')));
            }
            else if (e.getKeyCode() == KeyEvent.VK_L) {
                label.setText(label.getText() + String.valueOf(enigma.code('l')));
            }else if (e.getKeyCode() == KeyEvent.VK_M) {
                label.setText(label.getText() + String.valueOf(enigma.code('m')));
            }
            else if (e.getKeyCode() == KeyEvent.VK_N) {
                label.setText(label.getText() + String.valueOf(enigma.code('n')));
            }else if (e.getKeyCode() == KeyEvent.VK_O) {
                label.setText(label.getText() + String.valueOf(enigma.code('o')));
            }else if (e.getKeyCode() == KeyEvent.VK_P) {
                label.setText(label.getText() + String.valueOf(enigma.code('p')));
            }else if (e.getKeyCode() == KeyEvent.VK_Q) {
                label.setText(label.getText() + String.valueOf(enigma.code('q')));
            }else if (e.getKeyCode() == KeyEvent.VK_R) {
                label.setText(label.getText() + String.valueOf(enigma.code('r')));
            }else if (e.getKeyCode() == KeyEvent.VK_S) {
                label.setText(label.getText() + String.valueOf(enigma.code('s')));
            }else if (e.getKeyCode() == KeyEvent.VK_T) {
                label.setText(label.getText() + String.valueOf(enigma.code('t')));
            }else if (e.getKeyCode() == KeyEvent.VK_U) {
                label.setText(label.getText() + String.valueOf(enigma.code('u')));
            }else if (e.getKeyCode() == KeyEvent.VK_V) {
                label.setText(label.getText() + String.valueOf(enigma.code('v')));
            }else if (e.getKeyCode() == KeyEvent.VK_W) {
                label.setText(label.getText() + String.valueOf(enigma.code('w')));
            }else if (e.getKeyCode() == KeyEvent.VK_X) {
                label.setText(label.getText() + String.valueOf(enigma.code('x')));
            }else if (e.getKeyCode() == KeyEvent.VK_Y) {
                label.setText(label.getText() + String.valueOf(enigma.code('y')));
            }
            else if (e.getKeyCode() == KeyEvent.VK_Z) {
                label.setText(label.getText() + String.valueOf(enigma.code('z')));
            }
        }
        return false;
    }

}
