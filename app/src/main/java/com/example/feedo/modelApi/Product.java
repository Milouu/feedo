package com.example.feedo.modelApi;

import com.example.feedo.modelApi.Nutriments;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
    @SerializedName("brands_tags")
    @Expose
    private List<String> brands = new ArrayList<String>();
    @SerializedName("quantity")
    @Expose
    private String quantity;

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

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public String getQuantity() { return quantity; }

    public void setQuantity(String quantity) { this.quantity = quantity; }
}
