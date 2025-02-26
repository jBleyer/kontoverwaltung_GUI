import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kontoverwaltung_GUI {
    private JPanel mainPanel;
    private JComboBox selectKonto;
    private JTextArea textArea;
    private JTextField kontoinhaberTextField;
    private JTextField bankleitzahlTextField;
    private JTextField kontonummerTextField;
    private JTextField ueberziehungsrahmenTextFiled;
    private JTextField kontofuerungsgebuehrenTextFiled;
    private JTextField kontostandTextField;
    private JLabel kontoart;
    private JLabel kontoinhaber;
    private JLabel bankleitzahl;
    private JLabel kontonummer;
    private JLabel ueberziehungsrahmen;
    private JLabel kontofuerungsgebuehren;
    private JLabel kontostand;
    private JLabel Konten;
    private JButton closeButton;
    private JButton safeButton;

    public Kontoverwaltung_GUI() {
        safeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kontoartValue = selectKonto.getSelectedItem().toString();

                System.out.println(kontoartValue);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Kontoverwaltung_GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
