package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    int quantity = 1;
    String name="";

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        CheckBox CreamCheckBox = (CheckBox) findViewById(R.id.isChecked);
        boolean HasCream = CreamCheckBox.isChecked();

        CheckBox CheckChocolate = (CheckBox) findViewById(R.id.isCheckedChoco);
        boolean HasChoco = CheckChocolate.isChecked();

        int Price = CalculatePrice(quantity,HasCream, HasChoco);

        String Summary = OrderSummary(Price, HasCream, HasChoco);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order Place by " + name);
        intent.putExtra(Intent.EXTRA_TEXT, Summary);
        if(intent.resolveActivity(getPackageManager()) !=null){
            startActivity(intent);
        }

       display(quantity);

    }


    /**
     * This method is called when Call Button is clicked
     */

    public void Call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "7607135731"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when MAP Button is clicked
     */

    public void Map(View view){
        Uri gmmIntentUri = Uri.parse("geo:26.2207102,81.2281093");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }


    /**
     * Method for calculating Price
     */

    private int CalculatePrice(int number,boolean HasCream, boolean HasChoco) {
        int basePrice=5;

        if(HasCream){
            basePrice++;
        }

        if(HasChoco){
            basePrice +=2;
        }

        return number * basePrice;
    }


    /**
     * MEthod for Order Summary
     */

    private String OrderSummary(int price, boolean HasCream, boolean HasChoco) {
        /**
         * This fetch the text from the EditText and store it to a Temp variable
         */
        EditText Txt = findViewById(R.id.plain_text_input);
        name = Txt.getText().toString();

        return "NAME: " + name + "\nAdd Whipped Cream?" + HasCream + "\nAdd Chocolate?" + HasChoco + "\nQuantity: " + quantity + "\nTotal: $" + price + "\n" + getString(R.string.thank);

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

//    private void displayPrice(String Summary) {
//        TextView quantityTextView = (TextView) findViewById(R.id.price);
//        quantityTextView.setText(Summary);
//    }


    /* This method is called when the increment button is clicked*/

    public void increment(View view) {
        if(quantity==10) {
            Toast.makeText(this, "You cannot have more than 10 coffees", Toast.LENGTH_LONG).show();
            return;
        }
        quantity++;
        displayIncDcr(quantity);
    }



    /* This method is called when the decrement button is clicked*/

    public void decrement(View view) {
        if (quantity==1) {
            Toast.makeText(this, "You cannot have less than 1 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
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