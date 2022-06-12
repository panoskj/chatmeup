package com.chatmeup.chatmeup.models;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;

public class Payment {
    private int paymentID;
    private double amount;
    private Time paymentTime;
    private Date paymentDate;
    private String paymentDetails;
    protected LinkedList<ShoppingCart> itemsPurchased;

    //Constructor to initialize amount to 0
    public Payment()
    {
        amount = 0.0;
    }

    //Constructor to initialize payment amount
    public Payment(double paymentAmount)
    {
        amount = paymentAmount;
    }


    //Sets the payment amount
    public void setPayment(double paymentAmount)
    {
        amount = paymentAmount;
    }

    //Returns the payment amount
    public double getPayment()
    {
        return amount;
    }

    //Prints a description of the payment
    public void paymentDetails()
    {
        System.out.println("The payment amount is " + amount);
    }
}
