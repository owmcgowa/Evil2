package com.guyhembroff.owmcgowa_adm.amaph;

/**
 * Created by owmcgowa-adm on 2/9/2016.
 */
public class Sleep {

    private int sleepFinal;

    public int getSleepFinal(){
        return sleepFinal;
    }

    public void setSleepFinal(int sleepF){
        if ( sleepF >= 1 && sleepF <= 10){
            double all =  (sleepF * 3);
            sleepFinal = (int) all;
        }
        if (sleepF >= 11){
            double all = (10 * 3);
            sleepFinal = (int) all;
        }
    }

}
