package com.example.android.justjava;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        CheckBox CreamCheckBox = (CheckBox) findViewById(R.id.isChecked);
        boolean HasCream = CreamCheckBox.isChecked();

        CheckBox CheckChocolate = (CheckBox) findViewById(R.id.isCheckedChoco);
        boolean HasChoco = CheckChocolate.isChecked();

        int Price = CalculatePrice(quantity);
        String Summary = OrderSummary(Price, HasCream, HasChoco);
        display(quantity);
        displayPrice(Summary);
    }


    /**
     * Method for calculating Price
     */

    private int CalculatePrice(int number) {
        return number * 5;
    }


    /**
     * MEthod for Order Summary
     */

    private String OrderSummary(int price, boolean HasCream, boolean HasChoco) {
        EditText Txt =  findViewById(R.id.plain_text_input);
        String Temp=Txt. getText(). toString();
        if (!HasChoco & !HasCream) {
            return "$" + price;
        } else {
            return "NAME: "+ Temp + "\nAdd Whipped Cream?" + HasCream + "\nAdd Chocolate?" + HasChoco + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank You!";
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quant);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen.
     */

    private void displayPrice(String Summary) {
        TextView quantityTextView = (TextView) findViewById(R.id.price);
        quantityTextView.setText(Summary);
    }


    /* This method is called when the increment button is clicked*/

    public void increment(View view) {
        quantity++;
        displayIncDcr(quantity);
    }



    /* This method is called when the decrement button is clicked*/

    public void decrement(View view) {
        quantity--;
        displayIncDcr(quantity);
    }

    /**
     * This method displays the Increment and decremented quantity value on the screen.
     */

    private void displayIncDcr(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quant);
        quantityTextView.setText("" + number);
    }
}