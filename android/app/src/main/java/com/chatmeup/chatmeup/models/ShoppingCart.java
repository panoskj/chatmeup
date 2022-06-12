package com.chatmeup.chatmeup.models;

import java.util.List;

class Cart {
    private String productID;
    private int item_count;
    private List<Product> ProductList;
    private int quantity;
}


public void addToCart(String productID, double price, int quantity)
        {

        Item temp = new Item(itemName, price, quantity);
        totalPrice += (price * quantity);
        itemCount += quantity;
        cart[itemCount] = temp;

        }

    public int getQuantity() {
        return this.quantity;
    }
    public double getProductPrice() {
        return this.price;
    }
}
