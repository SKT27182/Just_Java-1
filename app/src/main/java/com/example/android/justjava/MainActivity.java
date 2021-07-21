package com.example.android.justjava;

        import android.os.Bundle;
        import android.view.View;
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

    int quantity=0;

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * 5);
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

    private void displayPrice(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.price);
        quantityTextView.setText("$" + number +"\n\nThank You!");
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