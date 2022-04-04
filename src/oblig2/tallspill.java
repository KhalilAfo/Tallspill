package oblig2;
import javax.swing.JOptionPane;
public class tallspill {
    // Nødvendige datafelt.
    private String[] valgAlternativer = {"Ja", "Nei"};

    public int nyttTall() {
        // Trekker og returnerer et slumptall mellom 0 og 200.
         return (int) (Math.random() * 201);
    }

    public void visMelding(String melding) {
        JOptionPane.showMessageDialog(null, melding);

    }

    public void forLite(int tall) {
    /* Viser melding om at parameterens verdi er for
       lite tall og ber spilleren prøve igjen. */
        visMelding("Tallet: " + tall + " er for lavt. Gjett igjen");
    }

    public void forStort(int tall) {
    /* Viser melding om at parameterens verdi er for
      stort tall og ber spilleren prøve igjen. */
        visMelding("Tallet: " + tall + " er for høyt. Gjett igjen");
    }

    public void avsluttRunde(int antall, int gjetning) {
    /* Viser melding om at det ble gjettet riktig
      og antall gjetninger som ble brukt.
      Parametrene gir opplysninger om dette. */
        int n = JOptionPane.showOptionDialog(null,
                "Du klarte det!\n" +
                        "Riktig tall var " + gjetning + ". Du brukte " + antall + " forsøk. \n" +
                        "Spill igjen?", "Spill på nytt?",
                0, JOptionPane.INFORMATION_MESSAGE, null, valgAlternativer, null);
        switch (n) {
            case 0:
                break;
            default:
                System.exit(0);
        }
    }

    public void kjørSpill() {
    /* Kjører en spillrunde ved å trekke et tall,
      nullstille tellevariabel, innhente gjentatte
      gjetninger fra bruker inntil det gjettes riktig.
      Når det skjer, avsluttes runden med passe
      meldinger til spilleren. */

        int teller;
        int tall;

        int lavestTall;
        int høyestTall;

        while (true) {
            tall = nyttTall();
            teller = 0;
            System.out.println(tall);
            lavestTall = 0;
            høyestTall = 200;
            boolean spillKjører = true;

            while (spillKjører) {

                try {
                    String input = "";

                    while (input != null && input.equals("")) {
                        input = JOptionPane.showInputDialog(null,
                                "Gjett et tall mellom " + lavestTall + " og " + høyestTall,
                                "Gjettespill", JOptionPane.QUESTION_MESSAGE);
                    }
                    if (input == null) {
                        int n = JOptionPane.showOptionDialog(null,
                                "Vil du avslutte spillet?", "Avslutt spill?",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                null, valgAlternativer, null);
                        switch (n) {
                            case 1:
                                break;
                            default:
                                System.exit(0);
                        }
                    }
                    int inputVerdi = Integer.parseInt(input);
                    teller++;
                    if (inputVerdi < tall) {
                        lavestTall = inputVerdi;
                        forLite(inputVerdi);
                    } else if (inputVerdi > tall) {
                        høyestTall = inputVerdi;
                        forStort(inputVerdi);
                    } else {
                        avsluttRunde(teller, inputVerdi);
                        spillKjører = false;
                    }
                } catch (NumberFormatException e) {
                    visMelding("Skriv inn et tall mellom " + lavestTall + " og " + høyestTall);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}

