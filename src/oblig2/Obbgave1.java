package oblig2;

import javax.swing.JOptionPane;

public class Obbgave1 {



    public static void main(String[] args) {
        int nedreGrense = 0;
        int øvreGrense = 0;
        JOptionPane.showMessageDialog(null,"Skriv inn to verdier: en nedre og en øvre, større enn nedre." );
        while (nedreGrense >= øvreGrense) {
            try{
                String nedreInnStreng = JOptionPane.showInputDialog("Skriv inn nedre grense");
                nedreGrense = Integer.parseInt(nedreInnStreng);

                String øvreInnStreng = JOptionPane.showInputDialog("Skriv inn øvre grense\nStørre enn " + nedreGrense);
                øvreGrense = Integer.parseInt(øvreInnStreng);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,
                        "Du må skrive inn to gyldige verdier, der øvre grense er større enn nedre grense");
            }
        }

        int sum = 0;
        for (int i = 1; nedreGrense < øvreGrense; i++) {
            sum += nedreGrense;
            System.out.print(nedreGrense++ + "+");
            if (i % 10 == 0) {
                System.out.print("\n");
            }
        }
        sum += øvreGrense;
        System.out.print(øvreGrense + " = " + sum);

    }

}

