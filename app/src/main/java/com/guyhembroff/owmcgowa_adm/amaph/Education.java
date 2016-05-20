package com.guyhembroff.owmcgowa_adm.amaph;

/**
 * Created by owmcgowa-adm on 3/13/2016.
 */
public class Education {

    private String ed1F, ed2F, ed3F;

    public String getEd1F(){
        return ed1F;
    }
    public String getEd2F(){
        return ed2F;
    }
    public String getEd3F(){
        return ed3F;
    }

    public void setEdu(int times){

        if(times == 0){
            ed1F = "Try to drink at least 8 glasses of water everyday";
            ed2F = "Did you know your body is composed of about 60% water";
            ed3F = "Water can also help keep your skin looking GOOD.";
        }

        if (times == 1){
            ed1F = "Try to exercising at least 60 minutes a day.";
            ed2F = "Exercise improves the quantity and quality of sleep.  Mom! I need my sleep!";
            ed3F = "Lets go dancing, hiking, running, swimming, or for a walk?";
        }

        if (times == 2){
            ed1F = "Breakfast is the most important meal of the day. Do you eat breakfast everyday?";
            ed2F = "Set the alarm for 15 minutes earlier to allow more time for breakfast.";
            ed3F = "How about adding some fresh fruits, oatmeal, eggs, or whole grain cereals to your breakfast?";
        }

        if (times == 3){
            ed1F = "Drink a lot of soda/pop or juices?";
            ed2F = "Choose water over soda/pop.";
            ed3F = "Choose 100% juices over 10% juice.  Who wants 10% anyway.";
        }
        if (times == 4){
            ed1F = "Are you eating fruits and veggies everyday?";
            ed2F = "Try making a fruit and veggie smoothie. I'll take one please?";
            ed3F = "Like pizza? Don't hold back on the veggies!";
        }
    }


}
