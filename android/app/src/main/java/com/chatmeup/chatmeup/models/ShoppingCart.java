package com.chatmeup.chatmeup.models;

import java.util.List;

class Item {
    private String productID;
    private int item_count;
    private List<Products> unitPrice;

    Item(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String toString() {
        String s = this.productName + ":";
        s = s + this.quantity + "\n";
        return s;
    }
    public String getProductName() {
        return this.productName;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getUnitPrice() {
        return this.unitPrice;
    }
}
