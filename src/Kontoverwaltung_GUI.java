import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Kontoverwaltung_GUI {
    private JPanel mainPanel;
    private JComboBox selectKonto;
    private JList konten;
    private JTextField kontoinhaberTextField;
    private JTextField bankleitzahlTextField;
    private JTextField kontonummerTextField;
    private JTextField ueberziehungsrahmenTextField;
    private JTextField kontofuerungsgebuehrenTextField;
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

    ArrayList<Konto> kontenValues = new ArrayList<Konto>();

    public Kontoverwaltung_GUI() {
        safeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Alles zuerst vorher ausfüllen, da sonst nur Fehler sind
                String kontoart = selectKonto.getSelectedItem().toString();
                String kontoInhaber = kontoinhaberTextField.getText();
                int bankleitzahl = Integer.parseInt(bankleitzahlTextField.getText());
                String kontonummer = kontonummerTextField.getText();
                float ueberziehungsrahmen = Float.parseFloat(ueberziehungsrahmenTextField.getText());
                float kontofuerungsgebuehren = Float.parseFloat(kontofuerungsgebuehrenTextField.getText());
                float kontostand = Float.parseFloat(kontostandTextField.getText());

                if(kontoart.equals("Girokonto")){
                    System.out.println(kontoart);
                    Girokonto girokonto = new Girokonto();
                    girokonto.anlegen(kontoInhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuerungsgebuehren, kontostand, kontoart);
                    kontenValues.add(girokonto);

                } else if(kontoart.equals("Sparkonto")){
                    Sparkonto sparkonto = new Sparkonto();
                    sparkonto.anlegen(kontoInhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuerungsgebuehren, kontostand, kontoart);
                    kontenValues.add(sparkonto);

                } else if(kontoart.equals("Kreditkonto")){
                    Kreditkonto kreditkonto = new Kreditkonto();
                    kreditkonto.anlegen(kontoInhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuerungsgebuehren, kontostand, kontoart);
                    kontenValues.add(kreditkonto);

                } else {
                    //Hier irgendwas mit NullpointerExc. womit er nicht kann
                }

            }
        });
        konten.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kontoverwaltung_GUI");
        frame.setContentPane(new Kontoverwaltung_GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
