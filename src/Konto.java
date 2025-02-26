import java.util.ArrayList;
import java.util.Scanner;

public class Konto {
    private String kontoinhaber;
    private int bankleitzahl;
    private String kontonummer;
    private float ueberziehungsrahmen;
    private float kontofuerunsgebuehren;
    private float kontostand;
    private String kontoart;

    //contructor
    public Konto() {

    }

    public Konto(String kontoinhaber,
                 int bankleitzahl,
                 String kontonummer,
                 float ueberziehungsrahmen,
                 float kontofuerunsgebuehren,
                 float kontostand,
                 String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuerunsgebuehren = kontofuerunsgebuehren;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    //Methoden
    public void anlegen(String kontoinhaber,
                        int bankleitzahl,
                        String kontonummer,
                        float ueberziehungsrahmen,
                        float kontofuerunsgebuehren,
                        float kontostand,
                        String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuerunsgebuehren = kontofuerunsgebuehren;
        if (kontoart.equals("Kreditkonto")) {
            this.kontostand = -kontostand;
        } else {
            this.kontostand = kontostand;
        }
        this.kontoart = kontoart;

        //Nur zum Überprüfen
        auszug();
        System.out.println(kontoart + " wurde erfolgreich erstellt");
    }

    //idk tbh (gc takes care of object?)
    // public void aufloesen(Konto konto) {}

    public void einzahlen(String input, float geld, ArrayList<Konto> konten) {
        //Kreditkonto-exception
        if (kontoart.equals("Kreditkonto") && (kontostand + geld) >= 0) {
            System.out.println("Sie haben: " + (kontostand + geld) + " ueber. Vielen Dank fuer Ihre Spende.");
            System.out.println("Ihr Konto wurde geschlossen");

            for (int i = 0; i < konten.size(); i++) {
                if (input.equals(konten.get(i).getKontonummer())) {
                    konten.remove(i);
                }
            }
        }
        setKontostand(getKontostand() + geld);
    }

    public float abheben(float betrag) {

        //Sparkonto-exception
        if (kontoart.equals("Sparkonto") && betrag >= kontostand) {
            System.out.println("Ihr Betrag ist hoeher als sie auf dem Sparkonto zur Verfuegung haben. Abheben nicht moeglich!");
            return 0.0f;
        }

        if (kontostand < betrag) {
            System.out.println("Ihre Auzahlung ueberschreitet ihren jetzigen Kontostand. Moechten Sie einen Überzeihungsrahmen anlegen? y/n");
            Scanner scanner = new Scanner(System.in);
            boolean run = true;

            while (run) {
                char input2 = scanner.next().charAt(0);
                //check if customer wants überziehungsrahmen
                if (input2 == 'n') {
                    System.out.println("Es wurde kein Überzeihungsrahmen erstellt");
                    run = false;
                    //Erstelle überziehungsrahmen
                } else if (input2 == 'y') {
                    System.out.println("Bitte geben Sie den Betrag Ihres Überzeihungsrahmen ein");
                    float ueberziehungsrahmenBetrag = scanner.next().charAt(0);
                    setUeberziehungsrahmen(ueberziehungsrahmenBetrag);
                    System.out.println("Ihr Überziehungsrahmen wurde erstellt");
                    run = false;
                } else {
                    System.out.println("Bitte geben Sie entweder 'y' oder 'n' ein!");
                }
            }

        } else {
            setKontostand(getKontostand() - betrag);
            return betrag;
        }
        return 0.0f;
    }

    public void ueberweisen(Konto k2) {
        System.out.println("Wie viel möchte Sie ueberweisen?");
        Scanner scanner = new Scanner(System.in);
        float betrag = scanner.nextFloat();

        if (k2.kontostand >= betrag && kontostand >= betrag) {
            k2.kontostand += betrag;
        } else {
            System.out.println("Ihr Betrag ueberschreitet Ihren Kontostand. Ueberweisung nicht moeglich!");
        }
    }

    public void auszug() {
        System.out.println("Ihr Kontoauszug: \n Kontoinhaber: " + kontoinhaber + " \n Bankleitzahl: " + bankleitzahl + " \n Kontonummer: " + kontonummer + " \n Ueberziehungsrahmen: " + ueberziehungsrahmen + " \n Kontofuerunsgebuehren: " + kontofuerunsgebuehren + " \n Kontostand: " + kontostand + " \n Kontoart: " + kontoart + " \n");
    }


    //überweisen() als Zusatz

    //getter + setter
    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public void setBankleitzahl(int bankleitzahl) {
        this.bankleitzahl = bankleitzahl;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public void setUeberziehungsrahmen(float ueberziehungsrahmen) {
        this.ueberziehungsrahmen = ueberziehungsrahmen;
    }

    public void setKontofuerunsgebuehren(float kontofuerunsgebuehren) {
        this.kontofuerunsgebuehren = kontofuerunsgebuehren;
    }

    public void setKontostand(float kontostand) {
        this.kontostand = kontostand;
    }

    public void setKontoart(String kontoart) {
        this.kontoart = kontoart;
    }


    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public int getBankleitzahl() {
        return bankleitzahl;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public float getUeberziehungsrahmen() {
        return ueberziehungsrahmen;
    }

    public float getKontofuerunsgebuehren() {
        return kontofuerunsgebuehren;
    }

    public float getKontostand() {
        return kontostand;
    }

    public String getKontoart() {
        return kontoart;
    }


}

