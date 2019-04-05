package com.example.feedo.modelApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.ArrayList;

public class OffWrapper {

    @SerializedName("count")
    @Expose
    private Double count;
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<Product>();

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
