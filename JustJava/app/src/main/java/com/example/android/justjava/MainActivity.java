package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameEdit = (EditText)findViewById(R.id.name);
        String name = nameEdit.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        int price = calculatePrice(hasChocolate, hasWhippedCream);
        //displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, name));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary(price, hasWhippedCream, hasChocolate, name));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {
        int chocolate = 0, whippedCream = 0;
        if(hasChocolate) chocolate = 2;
        if(hasWhippedCream) whippedCream = 1;
        return quantity * (5 + whippedCream + chocolate);
    }

    /**
     * Creates a summary of the order.
     *
     * @param total price of order
     * @return text summary of order
     */
    private String createOrderSummary(int total, boolean whippedCream, boolean chocolate, String name) {
        return "Name: "+name+"\nQuantity: "+quantity+"\nAdd Whipped Cream? "+whippedCream+
                "\nAdd Chocolate? "+chocolate+"\nTotal: "+total+"\nThank You!";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_text_view);
        summaryTextView.setText(message);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if(quantity<100) {
            quantity = quantity + 1;
            display(quantity);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Cannot order more than 99 cups of coffee", Toast.LENGTH_SHORT);
            toast.show();
        };
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if(quantity>0){
        quantity = quantity-1;
        display(quantity);}
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Cannot decrement below 0", Toast.LENGTH_SHORT);
            toast.show();
        };
    }
}