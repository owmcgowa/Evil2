package com.guyhembroff.owmcgowa_adm.amaph;

/**
 * Created by owmcgowa-adm on 2/9/2016.
 */
public class BMI {private double bmiFinal;


    public double getBmiFinal(){
        return bmiFinal;
    }

    public void setBmiFinal(String sexF, double ageF, double bmiF) {

        //Male
        if (sexF.equalsIgnoreCase("Male")) {

            if (ageF == 8) {

                if (bmiF <= 13.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 13.81 && bmiF <= 18.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 18.01 && bmiF <= 20.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 20.01) {
                    bmiFinal = 2;
                }

            }

            if (ageF == 9) {

                if (bmiF <= 14.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.01 && bmiF <= 18.40) {
                    bmiFinal = 10;
                }

                if (bmiF >= 18.41 && bmiF <= 21.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 21.01) {
                    bmiFinal = 2;
                }

            }

            if (ageF == 10) {

                if (bmiF <= 14.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.21 && bmiF <= 19.40) {
                    bmiFinal = 10;
                }

                if (bmiF >= 19.41 && bmiF <= 22.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 22.01) {
                    bmiFinal = 2;
                }

            }

            if (ageF == 11) {

                if (bmiF <= 14.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.61 && bmiF <= 20.20) {
                    bmiFinal = 10;
                }

                if (bmiF >= 20.21 && bmiF <= 23.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 23.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 12) {

                if (bmiF <= 15.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 15.01 && bmiF <= 21.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 20.01 && bmiF <= 24.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 24.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 13) {

                if (bmiF <= 15.40) {
                    bmiFinal = 4;
                }

                if (bmiF >= 15.41 && bmiF <= 21.80) {
                    bmiFinal = 10;
                }

                if (bmiF >= 20.81 && bmiF <= 25.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 25.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 14) {

                if (bmiF <= 16.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 16.01 && bmiF <= 22.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 22.61 && bmiF <= 26.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 26.01) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 15) {

                if (bmiF <= 16.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 16.61 && bmiF <= 23.40) {
                    bmiFinal = 10;
                }

                if (bmiF >= 23.41 && bmiF <= 26.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 26.81) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 16) {

                if (bmiF <= 17.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.21 && bmiF <= 24.20) {
                    bmiFinal = 10;
                }

                if (bmiF >= 24.21 && bmiF <= 27.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 27.61) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 17) {

                if (bmiF <= 17.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.61 && bmiF <= 25.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.01 && bmiF <= 28.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 28.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 18) {

                if (bmiF <= 18.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 18.21 && bmiF <= 25.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.61 && bmiF <= 29.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 29.01) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 19) {

                if (bmiF <= 18.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 18.81 && bmiF <= 26.40) {
                    bmiFinal = 10;
                }

                if (bmiF >= 26.41 && bmiF <= 29.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 29.61) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 20) {

                if (bmiF <= 19.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 19.21 && bmiF <= 27.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 27.01 && bmiF <= 30.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 30.61) {
                    bmiFinal = 2;
                }
            }
            if (ageF >= 21) {

                if (bmiF <= 18.49) {
                    bmiFinal = 4;
                }

                if (bmiF >= 18.50 && bmiF <= 24.99) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.00 && bmiF <= 29.99) {
                    bmiFinal = 4;
                }

                if (bmiF >= 30.00) {
                    bmiFinal = 2;
                }
            }
        }

        //Female
        if( sexF.equalsIgnoreCase("Female")){

            if (ageF == 8) {

                if (bmiF <= 13.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 13.61 && bmiF <= 18.20) {
                    bmiFinal = 10;
                }

                if (bmiF >= 18.21 && bmiF <= 20.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 20.61) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 9) {

                if (bmiF <= 13.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 13.80 && bmiF <= 19.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 19.01 && bmiF <= 21.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 21.81) {
                    bmiFinal = 2;
                }

            }

            if (ageF == 10) {

                if (bmiF <= 14.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.01 && bmiF <= 20.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 20.01 && bmiF <= 23.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 23.01) {
                    bmiFinal = 2;
                }

            }

            if (ageF == 11) {

                if (bmiF <= 14.40) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.41 && bmiF <= 20.80) {
                    bmiFinal = 10;
                }

                if (bmiF >= 20.81 && bmiF <= 24.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 24.01) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 12) {

                if (bmiF <= 14.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 14.81 && bmiF <= 21.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 21.61 && bmiF <= 25.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 25.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 13) {

                if (bmiF <= 15.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 15.21 && bmiF <= 22.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 22.61 && bmiF <= 26.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 26.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 14) {

                if (bmiF <= 15.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 15.81 && bmiF <= 23.20) {
                    bmiFinal = 10;
                }

                if (bmiF >= 23.21 && bmiF <= 27.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 27.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 15) {

                if (bmiF <= 16.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 16.21 && bmiF <= 24.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 24.01 && bmiF <= 28.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 28.01) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 16) {

                if (bmiF <= 16.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 16.81 && bmiF <= 24.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 24.61 && bmiF <= 28.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 28.81) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 17) {

                if (bmiF <= 17.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.21 && bmiF <= 25.20) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.21 && bmiF <= 29.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 29.81) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 18) {

                if (bmiF <= 17.60) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.61 && bmiF <= 25.60) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.61 && bmiF <= 30.20) {
                    bmiFinal = 4;
                }

                if (bmiF >= 30.21) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 19) {

                if (bmiF <= 17.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.81 && bmiF <= 26.00) {
                    bmiFinal = 10;
                }

                if (bmiF >= 26.01 && bmiF <= 31.00) {
                    bmiFinal = 4;
                }

                if (bmiF >= 31.01) {
                    bmiFinal = 2;
                }
            }

            if (ageF == 20) {

                if (bmiF <= 17.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 17.81 && bmiF <= 26.40) {
                    bmiFinal = 10;
                }

                if (bmiF >= 26.41 && bmiF <= 31.80) {
                    bmiFinal = 4;
                }

                if (bmiF >= 31.81) {
                    bmiFinal = 2;
                }
            }
            if (ageF >= 21) {

                if (bmiF <= 18.49) {
                    bmiFinal = 4;
                }

                if (bmiF >= 18.50 && bmiF <= 24.99) {
                    bmiFinal = 10;
                }

                if (bmiF >= 25.00 && bmiF <= 29.99) {
                    bmiFinal = 4;
                }

                if (bmiF >= 30.00) {
                    bmiFinal = 2;
                }
            }
        }
    }
}
