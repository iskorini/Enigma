package GUI;

import Core.Enigma;

import javax.swing.*;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;



/**
 * Created by federicoschipani on 03/04/16.
 */
public class EnigmaGUI {
    private JFrame principal_frame;
    private JPanel right_panel;
    protected String first_rotor = "I";

    public void setFirst_rotor(String first_rotor) {
        this.first_rotor = first_rotor;
    }

    public void setSecond_rotor(String second_rotor) {
        this.second_rotor = second_rotor;
    }

    public void setThird_rotor(String third_rotor) {
        this.third_rotor = third_rotor;
    }

    public void setStart_first_rotor(int start_first_rotor) {
        this.start_first_rotor = start_first_rotor;
    }

    public void setStart_second_rotor(int start_second_rotor) {
        this.start_second_rotor = start_second_rotor;
    }

    public void setStart_third_rotor(int start_third_rotor) {
        this.start_third_rotor = start_third_rotor;
    }

    protected String second_rotor = "I";
    protected String third_rotor = "I";
    protected int start_first_rotor = 0;
    protected int start_second_rotor = 0;
    protected int start_third_rotor = 0;
    public EnigmaGUI () {
        this.createGUI();
        this.addComponent();
        principal_frame.pack();
        principal_frame.setLocationRelativeTo(null);
        principal_frame.setVisible(true);
    }
    private void createGUI() {
        principal_frame = new JFrame();
        principal_frame.setLayout(new BorderLayout());
        principal_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void addComponent() {
        JPanel upper_panel, down_panel;
        upper_panel = new JPanel();
        down_panel = new JPanel();
        right_panel = generateRightPanelString();
        principal_frame.add(upper_panel, BorderLayout.PAGE_START);
        principal_frame.add(generateLeftPanel(), BorderLayout.LINE_START);
        principal_frame.add(right_panel, BorderLayout.CENTER);
        principal_frame.add(down_panel, BorderLayout.PAGE_END);
    }
    private JPanel generateLeftPanel() {
        JPanel left_panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Impostazioni");
        left_panel.setBorder(title);
        left_panel.setLayout(new GridLayout(4, 3));
        String[] rotor_list =  {"I", "II", "III", "IV", "V"};
        /*
        JComboBox for selection of Rotors
         */
        JComboBox first_rotor = new JComboBox(rotor_list);
        JComboBox second_rotor = new JComboBox(rotor_list);
        JComboBox third_rotor = new JComboBox(rotor_list);
        first_rotor.addActionListener(e1 -> this.setFirst_rotor(getRotor(((JComboBox)e1.getSource()).getSelectedIndex())));
        second_rotor.addActionListener(e1 -> this.setSecond_rotor(getRotor(((JComboBox)e1.getSource()).getSelectedIndex())));
        third_rotor.addActionListener(e1 -> this.setThird_rotor(getRotor(((JComboBox)e1.getSource()).getSelectedIndex())));
        /*
        JSPinner for selection of start position
         */
        JSpinner first_rotor_start = new JSpinner(new SpinnerNumberModel(0, 0, 25, 1));
        JSpinner second_rotor_start = new JSpinner(new SpinnerNumberModel(0, 0, 25, 1));
        JSpinner third_rotor_start = new JSpinner(new SpinnerNumberModel(0, 0, 25, 1));
        first_rotor_start.addChangeListener(e1 -> this.setStart_first_rotor((int)((JSpinner)e1.getSource()).getValue()));
        second_rotor_start.addChangeListener(e1 -> this.setStart_second_rotor((int)((JSpinner)e1.getSource()).getValue()));
        third_rotor_start.addChangeListener(e1 -> this.setStart_third_rotor((int)((JSpinner)e1.getSource()).getValue()));
        /*
        add component in left JPanel
         */
        left_panel.add(new JLabel("Rotore veloce:"));
        left_panel.add(first_rotor);
        left_panel.add(first_rotor_start);
        left_panel.add(new JLabel("Rotore medio:"));
        left_panel.add(second_rotor);
        left_panel.add(second_rotor_start);
        left_panel.add(new JLabel("Rotore lento:"));
        left_panel.add(third_rotor);
        left_panel.add(third_rotor_start);
        JCheckBox mode = new JCheckBox("Stringa");
        mode.setSelected(true);
        mode.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                principal_frame.getContentPane().remove(this.right_panel);
                principal_frame.revalidate();
                principal_frame.repaint();
                right_panel = this.generateRightPanelChar();
            }
            else {
                principal_frame.getContentPane().remove(this.right_panel);
                principal_frame.revalidate();
                principal_frame.repaint();
                right_panel = this.generateRightPanelString();
            }
            principal_frame.add(right_panel, BorderLayout.CENTER);
            principal_frame.revalidate();
            principal_frame.repaint();
            principal_frame.pack();
        });
        left_panel.add(mode);
        return left_panel;
    }
    private JPanel generateRightPanelString() {

        JPanel right_panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Codifica Stringa");
        right_panel.setBorder(title);
        right_panel.setLayout(new GridLayout(3, 1));
        JTextArea to_decode = new JTextArea("Inserire stringa da codificare");
        JTextArea decoded_string = new JTextArea("Stringa decodificata");
        JButton start_process = new JButton("Codifica");
        start_process.addActionListener(e -> decoded_string.setText(createEnigma().code(to_decode.getText())));
        right_panel.add(to_decode);
        right_panel.add(start_process);
        right_panel.add(decoded_string);
        return right_panel;

    }
    private JPanel generateRightPanelChar() {

        JPanel right_panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Codifica Carattere");
        right_panel.setBorder(title);
        right_panel.setLayout(new GridLayout(3, 1));
        JLabel label  = new JLabel("Premere Codifica per iniziare il processo");
        JButton start_process = new JButton("Codifica");
        JButton stop_process = new JButton("Ferma");
        JPanel buttons = new JPanel();
        buttons.add(start_process);
        buttons.add(stop_process);
        stop_process.setEnabled(false);
        JLabel decoded = new JLabel("");
        final KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        start_process.addActionListener(e ->{
            decoded.setText("");
            manager.addKeyEventDispatcher(new KeyEventEnigma(createEnigma(), decoded,1 ));
            stop_process.setEnabled(true);
            start_process.setEnabled(false);
        });
        stop_process.addActionListener( e -> {
        	manager.removeKeyEventDispatcher(new KeyEventEnigma(1));
        	start_process.setEnabled(true);
        	stop_process.setEnabled(false);
        });
        right_panel.add(label);
        right_panel.add(buttons);
        right_panel.add(decoded);
        return right_panel;

    }
    private Enigma createEnigma() {
        Enigma e;
        e = new Enigma(this.first_rotor, this.start_first_rotor, this.second_rotor, this.start_second_rotor,
                this.third_rotor, this.start_third_rotor);
        return e;
    }

    private String getRotor(int index) {
        if (index == 0) {
            return "I";
        }
        else if (index == 1) {
            return "II";
        }
        else if (index == 2) {
            return "III";
        }
        else if (index == 3) {
            return "IV";
        }
        return "V";
    }

}
