package com.example.feedo.modelApi;

import com.example.feedo.modelApi.Nutriments;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("generic_name_fr")
    @Expose
    private String generic_name_fr;
    @SerializedName("nutriments")
    @Expose
    private Nutriments nutriments;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

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
