import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  //  private JFrame f;

    ArrayList<Konto> kontenValues = new ArrayList<Konto>();

    public void createNewFrame(){
        JFrame f = new JFrame("frame");

        f.setLayout(new GridLayout(7,3));
        // create a label
        JLabel labelOwner = new JLabel("Kontoart: ");
        JLabel labelOwnerText = new JLabel("Kontoinhaber: ");

        f.add(labelOwnerText);
        f.add(labelOwner);

        // setsize of dialog
        f.setSize(400, 400);

        // set visibility of dialog
        f.setVisible(true);
    }


    public Kontoverwaltung_GUI() {

        //JList
        DefaultListModel<String> model = new DefaultListModel<>();
        //add modell
        konten.setModel(model);

        //Wenn auf safe gedrückt:
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
                    model.addElement(girokonto.getKontoinhaber() + " ("+girokonto.getKontoart()+ ")");

                } else if(kontoart.equals("Sparkonto")){
                    Sparkonto sparkonto = new Sparkonto();
                    sparkonto.anlegen(kontoInhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuerungsgebuehren, kontostand, kontoart);
                    kontenValues.add(sparkonto);
                    model.addElement(sparkonto.getKontoinhaber() + " ("+sparkonto.getKontoart()+ ")");

                } else if(kontoart.equals("Kreditkonto")){
                    Kreditkonto kreditkonto = new Kreditkonto();
                    kreditkonto.anlegen(kontoInhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuerungsgebuehren, kontostand, kontoart);
                    kontenValues.add(kreditkonto);
                    model.addElement(kreditkonto.getKontoinhaber() + " ("+kreditkonto.getKontoart()+ ")");

                } else {
                    //Hier irgendwas mit NullpointerExc. womit er nicht kann
                }

            }
        });
        
        //Wenn auf listeintrag gecklickt
        konten.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                //Hier neues fenster mit allen funktionen betreffen (Im schlimmsten Fall mach Konto einsehen button zu combobox)
                //konten.getSelectedValue();

                //Sicherung, dadurch das mir valueChanged immer 2 mal den Frame aufmacht (Warum? IDK!)
                if (!e.getValueIsAdjusting()) {
                    // Create and show the dialog
                    createNewFrame();
                }

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
