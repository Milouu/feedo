package com.example.feedo.offApi;

import com.google.gson.annotations.SerializedName;

public class Nutriments {

    @SerializedName("carbohydrates_100g")
    private double carbohydrates;
    @SerializedName("saturated-fat_100g")
    private double saturated_fat;
    @SerializedName("energy_100g")
    private double energy;
    @SerializedName("salt_100g")
    private double salt;
    @SerializedName("fat_100g")
    private double fat;
    @SerializedName("sugars_100g")
    private double sugars;
    @SerializedName("proteins_100g")
    private double proteins;
    @SerializedName("fiber_100g")
    private double fiber;
    @SerializedName("nutrition-score-fr_100g")
    private double score;


    //Getters

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getSaturated_fat() {
        return saturated_fat;
    }

    public double getEnergy() {
        return energy;
    }

    public double getSalt() {
        return salt;
    }

    public double getFat() {
        return fat;
    }

    public double getSugars() {
        return sugars;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFiber() {
        return fiber;
    }

    public double getScore() {
        return score;
    }
}
