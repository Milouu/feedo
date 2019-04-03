package com.example.feedo.offApi;

public class Product {

    private int code;
    private String generic_name_fr;
    private String product_name_fr;
    private Nutriments nutriments;


    //Getters

    public int getCode() {
        return code;
    }

    public String getGeneric_name_fr() {
        return generic_name_fr;
    }

    public String getProduct_name_fr() {
        return product_name_fr;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }
}
