package com.guyhembroff.owmcgowa_adm.amaph;

/**
 * Created by owmcgowa-adm on 2/9/2016.
 */
public class Activity {

    private int activityFinal;

    public int getActivityFinal(){
        return activityFinal;
    }

    public void setActivityFinal(int activityF){
        if ( activityF >= 60){
            double all = ( 60 / 2 );
            activityFinal = (int) all;
        }
        if (activityF <= 59){
            double all = Math.round(activityF / 2);
            activityFinal = (int) all;
        }
    }
}
