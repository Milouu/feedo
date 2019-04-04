package com.example.feedo.modelApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffWrapper {

    @SerializedName("code")
    @Expose
    private Double code;
    @SerializedName("product")
    @Expose
    private Product product;

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
