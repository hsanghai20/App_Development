package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

    int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream= whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        String priceMessage = createOrderSummary(hasWhippedCream,hasChocolate,name);

        // sending email for the order by clicking on order button
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(boolean addWhippedCream,boolean addChocolate,String name){
            String message= getString(R.string.nameOfPerson) + name +
                        "\n"+ getString(R.string.toAddWhippedCream) + addWhippedCream +
                        "\n"+ getString(R.string.toAddChocolate) + addChocolate +
                        "\n"+ getString(R.string.noOfCoffee) + quantity +
                        "\n" + getString(R.string.total) +calculatePrice(addWhippedCream,addChocolate) +
                        "\n" + getString(R.string.thank_you);
        return message;
    }
    /**
     * This method is used for calculating the total price for the coffee
     */
    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate){
        int price=5;
        if(hasWhippedCream)
            price++;
        if(hasChocolate)
            price+=2;
        return quantity*price;
    }
    public void increment(View view) {
        if(quantity==100) {
            Toast.makeText(this,"You Can't Order More Than 100 Coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        display(quantity);
    }
    public void decrement(View view){
        if(quantity==1){
            Toast.makeText(this,"You Can't Order Less Than 1 Coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}