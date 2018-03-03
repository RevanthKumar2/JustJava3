/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String ch;
        String wc;
        CheckBox whippedCream = findViewById(R.id.Whipped_cream);
        boolean hasWhippedCream = whippedCream.isChecked();
        if (hasWhippedCream) {
             wc = "yes";
        } else {
             wc = "No";
        }
        CheckBox choclate = findViewById(R.id.Choclate);
        boolean hasChoclate = choclate.isChecked();
        if (hasChoclate) {
             ch = "yes";
        } else {
             ch = "No";
        }
        EditText nameText = findViewById(R.id.name_view);
        String naMe = nameText.getText().toString();
        int price = calculatePrice(hasWhippedCream, hasChoclate);
        displayMessage(createOrdersummary(price,wc ,ch , naMe));
    }

    public void increment(View view) {
        if (quantity==100) {
            Toast.makeText(this, "you cannot have more than 100",Toast.LENGTH_SHORT).show();
        }
        else{
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "you cannot have less than 1",Toast.LENGTH_SHORT).show();
        }
        else{
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }
    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * Calculates the price of the order.
     *
     *?? @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean whippedCream , boolean Choclate ) {
        int baseprice = 5;
        if (whippedCream) {
            baseprice = baseprice + 1;
        }
        if (Choclate) {
            baseprice = baseprice + 2;
        }
        return baseprice * quantity;
    }

    private String createOrdersummary(int price , String hasWhippedCream , String hasChoclate , String name){
        String ORDERSUMMARY = getString(R.string.name) + name  + "\n" + getString(R.string.addwhipcream) + hasWhippedCream + "\n" + getString(R.string.addchocolate) + hasChoclate + "\n" + getString(R.string.Qunatity) + quantity + "\n" + getString(R.string.toatal) +"₹"+ price + "\n" + getString(R.string.thanku);
        return ORDERSUMMARY;
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
