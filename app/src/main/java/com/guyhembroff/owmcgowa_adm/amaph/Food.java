package com.guyhembroff.owmcgowa_adm.amaph;

/**
 * Created by owmcgowa-adm on 2/9/2016.
 */
public class Food {

    private double breadFinal, vegetableFinal, fruitFinal, milkFinal, meatFinal, foodFinal;


    public double getFoodFinal (){
        return foodFinal;
    }

    public void setFoodFinal ( double foodF){
        foodFinal = Math.round(foodF);
    }

    //Bread
    public double getBreadFinal (){
        return breadFinal;
    }

    public void setBreadFinal (double breadF, String sexF) {

        if (sexF.equalsIgnoreCase("Male")) {
            if (breadF == 11) {
                breadFinal = 6;
            }

            if (breadF >= 8 && breadF <= 10) {
                breadFinal = (6 * .8);
            }

            if (breadF >= 5 && breadF <= 7) {
                breadFinal = (6 * .6);
            }

            if (breadF >= 2 && breadF <= 4) {
                breadFinal = (6 * .4);
            }

            if (breadF == 1) {
                breadFinal = (6 * .2);
            }
            if (breadF == 0) {
                breadFinal = 0;
            }
        }

        if (sexF.equalsIgnoreCase("Female")) {
            if (breadF == 9) {
                breadFinal = 6;
            }

            if (breadF >= 7 && breadF <= 8) {
                breadFinal = (6 * .8);
            }

            if (breadF >= 5 && breadF <= 6) {
                breadFinal = (6 * .6);
            }

            if (breadF >= 3 && breadF <= 4) {
                breadFinal = (6 * .4);
            }

            if (breadF == 1 && breadF <= 2) {
                breadFinal = (6 * .2);
            }
            if (breadF == 0) {
                breadFinal = 0;
            }
        }
    }

    //Vegetable
    public double getVegetableFinal (){
        return vegetableFinal;
    }

    public void setVegetableFinal (double vegetableF, String sexF) {

        if (sexF.equalsIgnoreCase("Male")) {
            if (vegetableF == 5) {
                vegetableFinal = 6;
            }

            if (vegetableF == 4) {
                vegetableFinal = (6 * .8);
            }

            if (vegetableF == 3) {
                vegetableFinal = (6 * .6);
            }

            if (vegetableF == 2) {
                vegetableFinal = (6 * .4);
            }

            if (vegetableF == 1) {
                vegetableFinal = (6 * .2);
            }
            if (vegetableF == 0) {
                breadFinal = 0;
            }
        }
        if (sexF.equalsIgnoreCase("Female")) {
            if (vegetableF == 4) {
                vegetableFinal = 6;
            }

            if (vegetableF == 3) {
                vegetableFinal = (6 * .75);
            }

            if (vegetableF == 2) {
                vegetableFinal = (6 * .5);
            }

            if (vegetableF == 2) {
                vegetableFinal = (6 * .25);
            }

            if (vegetableF == 0) {
                breadFinal = 0;
            }
        }
    }

    //Fruit
    public double getFruitFinal (){
        return fruitFinal;
    }

    public void setFruitFinal (double fruitF, String sexF) {

        if (sexF.equalsIgnoreCase("Male")) {
            if (fruitF == 4) {
                fruitFinal = 6;
            }

            if (fruitF == 3) {
                fruitFinal = (6 * .75);
            }

            if (fruitF == 2) {
                fruitFinal = (6 * .50);
            }

            if (fruitF == 1) {
                fruitFinal = (6 * .25);
            }

            if (fruitF == 0){
                fruitFinal = 0;
            }
        }

        if (sexF.equalsIgnoreCase("Female")) {
            if (fruitF == 3) {
                fruitFinal = 6;
            }

            if (fruitF == 2) {
                fruitFinal = (6 * .6767);
            }

            if (fruitF == 2) {
                fruitFinal = (6 * .3434);
            }

            if (fruitF == 0){
                fruitFinal = 0;
            }
        }
    }

    //Milk
    public double getMilkFinal (){
        return milkFinal;
    }

    public void setMilkFinal ( double milkF){
        if (milkF == 3) {
            milkFinal = 6;
        }

        if (milkF == 2) {
            milkFinal = (6 * .6667);
        }

        if (milkF == 1) {
            milkFinal = (6 * .3434);
        }
    }

    //Meat
    public double getMeatFinal (){
        return meatFinal;
    }

    public void setMeatFinal (double meatF, String sexF) {

        if (sexF.equalsIgnoreCase("Male")) {
            if (meatF == 3) {
                meatFinal = 6;
            }

            if (meatF == 2) {
                meatFinal = (6 * .6667);
            }

            if (meatF == 1) {
                meatFinal = (6 * .3434);
            }
        }
        if (sexF.equalsIgnoreCase("Female")) {
            if (meatF == 2) {
                meatFinal = 6;
            }

            if (meatF == 1) {
                meatFinal = (6 * .50);
            }

            if (meatF == 0) {
                meatFinal = 0;
            }
        }
    }

}
