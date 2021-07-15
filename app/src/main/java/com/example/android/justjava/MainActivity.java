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

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        int number_Of_Coffee=5;
        display(number_Of_Coffee);
        displayPrice(number_Of_Coffee * 5);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quant);
        quantityTextView.setText("" + number);

    }

    private void displayPrice(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.price);
        quantityTextView.setText("$" + number);

    }


}