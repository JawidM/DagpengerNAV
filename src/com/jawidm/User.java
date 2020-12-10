package com.jawidm;

import javax.swing.*;
import java.util.Date;

public class User {
    //brukte public på incomeLastYear og avgIncome til å få tilgang fra UserTest klassen
    public final double incomeLastYear;
    private final double incomeTwoYearsAgo;
    private final double incomeThreeYearsAgo;
    private final double incomeThreeYears;
    public final double avgIncome;
    //Grunnbeløpet g/(G) per 1. mai 2020 er kr 101 351.
    private final double g = 101351;
    //for å vise datoen til slutt bare :)
    Date timeNow = new Date();

    public User(double incomeLastYear, double incomeTwoYearsAgo, double incomeThreeYearsAgo) {
        this.incomeLastYear = incomeLastYear;
        this.incomeTwoYearsAgo = incomeTwoYearsAgo;
        this.incomeThreeYearsAgo = incomeThreeYearsAgo;
        this.incomeThreeYears = incomeLastYear + incomeTwoYearsAgo + incomeThreeYearsAgo;
        this.avgIncome = incomeThreeYears/3;
    }

    //metoden for å teste brukeren er innvilget eller ikke
    public Boolean testGranted() {
        // sjekker at summen av inntekten i de tre siste årene er høyere enn 3G eller siste året er høyere enn 1.5G
        return incomeThreeYears > 3 * g || incomeLastYear > 1.5 * g;
    }

    public double checkDagsatsen(double dagsatsen) {
        //Om brukeren er innvilget beregnes dagsatsen
        if (testGranted()) {
            //sjekker inntekten i de siste tre årene er mindre enn 6G og er større enn inntekten ifjor
            if (avgIncome < 6 * g && avgIncome > incomeLastYear) {
                dagsatsen = avgIncome / 260;
                JOptionPane.showMessageDialog(null, "Du kan søke om Dagpenger \n" +
                        "Du kan få " + String.format("%.0f", Math.ceil(dagsatsen)) + " kr per dag \n \n" +
                        timeNow);
            }
            //sjekker inntekten i fjor er mindre enn 6G og er større enn inntekten i de siste tre årene
            else if (incomeLastYear < 6 * g && incomeLastYear > avgIncome) {
                dagsatsen = incomeLastYear / 260;
                JOptionPane.showMessageDialog(null, "Du kan søke om Dagpenger \n" +
                        "Du kan få " + String.format("%.0f", Math.ceil(dagsatsen)) + " kr per dag \n \n" +
                        timeNow);
            } else {
                dagsatsen = (6 * g) / 260;
                //System.out.println("Dagpengergrunnlaget kan IKKE være høyere enn 6G");
                JOptionPane.showMessageDialog(null, "Dagpengergrunnlaget kan IKKE være høyere enn 6G \n" +

                        "Du kan få " + String.format("%.0f", Math.ceil(dagsatsen)) + " per dag \n \n" +
                        timeNow);
            }
        }
        //Om brukeren IKKE er innvilget får de melding om det
        else {
            JOptionPane.showMessageDialog(null, "Du kan IKKE søke om Dagpenger dessverre");
        }
        return dagsatsen;
    }
}
