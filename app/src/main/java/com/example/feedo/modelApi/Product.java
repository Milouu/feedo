package com.example.feedo.modelApi;

import com.example.feedo.modelApi.Nutriments;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {


    @SerializedName("generic_name_fr")
    @Expose
    private String generic_name_fr;
    @SerializedName(" nutriments")
    @Expose
    private Nutriments nutriments;

    public String getGeneric_name_fr() {
        return generic_name_fr;
    }

    public void setGeneric_name_fr(String generic_name_fr) {
        this.generic_name_fr = generic_name_fr;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public void setNutriments(Nutriments nutriments) {
        this.nutriments = nutriments;
    }
}
