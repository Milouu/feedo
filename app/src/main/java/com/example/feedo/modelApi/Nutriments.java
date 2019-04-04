package com.example.feedo.modelApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutriments {

    @SerializedName("carbohydrates_100g")
    @Expose
    private double carbohydrates;
    @SerializedName("saturated-fat_100g")
    @Expose
    private double saturated_fat;
    @SerializedName("energy_100g")
    @Expose
    private double energy;
    @SerializedName("salt_100g")
    @Expose
    private double salt;
    @SerializedName("fat_100g")
    @Expose
    private double fat;
    @SerializedName("sugars_100g")
    @Expose
    private double sugars;
    @SerializedName("proteins_100g")
    @Expose
    private double proteins;
    @SerializedName("fiber_100g")
    @Expose
    private double fiber;
    @SerializedName("nutrition-score-fr_100g")
    @Expose
    private double score;

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSaturated_fat() {
        return saturated_fat;
    }

    public void setSaturated_fat(double saturated_fat) {
        this.saturated_fat = saturated_fat;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
