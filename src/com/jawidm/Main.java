package com.jawidm;

import javax.swing.*;

public class Main {
    //validering av input value, sjekker om input value fra bruker er double eller ikke
    private static boolean isNumber(String n){
        try{
            Double.valueOf(n);
            return false;
        }
        catch (NumberFormatException nfe){
            return true;
        }
    }

    public static void main(String[] args) {
        //mottar inntekten ifjor fra bruker
        String incomeLastYear = JOptionPane.showInputDialog(null, "Skriv inn inntekten ifjor: ");
        //bruker metoden isNumber til å sjekke
        while (isNumber(incomeLastYear)){
            incomeLastYear = JOptionPane.showInputDialog(null, " Ugyldig tegn! Kun tall er tillatt \n " +
                    "Skriv inn inntekten ifjor: ");
        }
        //mottar inntekten fra two år siden
        String incomeTwoYearsAgo = JOptionPane.showInputDialog(null, "Skriv inn inntekten i 2018: ");
        while (isNumber(incomeTwoYearsAgo)){
            incomeTwoYearsAgo = JOptionPane.showInputDialog(null, " Ugyldig tegn! Kun tall er tillatt \n " +
                    "Skriv inn inntekten i 2018: ");
        }
        //mottar inntekten fra tre år siden
        String incomeThreeYearsAgo = JOptionPane.showInputDialog(null, "Skriv inn inntekten i 2017: ");
        while (isNumber(incomeThreeYearsAgo)){
            incomeThreeYearsAgo = JOptionPane.showInputDialog(null, " Ugyldig tegn! Kun tall er tillatt \n " +
                    "Skriv inn inntekten i 2017: ");
        }
        //lager ny object av klassen User og setter verdier vha constructoren
        //UserMin newUser = new UserMin(Double.parseDouble(incomeLastYear), incomeThreeYears,incomeThreeYears/3 );

        //kaller metoden testGranted i UserMin klassen
        //newUser.testGranted();

        //Scanner klassen kunne blitt brukt også for å lage objekter, men jeg foretrukket å bruke JOptionPane
        //Scanner scanner = new Scanner (System.in);

        //lager ny object av klassen User og setter verdier fått via input inn i. Casting utført String til double
        User newUser = new User(Double.parseDouble(incomeLastYear), Double.parseDouble(incomeTwoYearsAgo), Double.parseDouble(incomeThreeYearsAgo));
        newUser.checkDagsatsen(0);
    }
}
