/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/






/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * noc means no: of coffees
     */
    static int quan = 0;
    static int bill = 0;

    int temp1 = 0, temp2 = 0;

    String str1 = "false", str2 = "false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void plus(View view) {
        quan += 1;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText(String.valueOf(quan));

    }

    public void minus(View view) {
        if (quan == 0)
            quan = 0;
        else
            quan -= 1;

        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText(String.valueOf(quan));

    }


    public void submitOrder(View view) {

        bill = 2 * quan + temp1* 1 + temp2* 2;


        EditText nameView = (EditText) findViewById(R.id.name);
        Editable name = nameView.getText();


        String text = "Order Summary\n\n" + "Name: " + name + "\nTotal: " + "$" + bill+ "\nWhipped Cream?" + str1 + "\nChocolate?" + str2;

        //Creating Intent

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this1
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    public void onCheckWhip(View view) {
        boolean whipChecked = ((CheckBox) view).isChecked();
        if (whipChecked) {
            str1 = "true";
            temp1 = 1; }
        else{
            str1 = "false";
            temp1 = 0;}

    }

    public void onCheckChoc(View view) {
        boolean chocChecked = ((CheckBox) view).isChecked();
        if (chocChecked) {
            str2 = "true";
            temp2 = 1;
        }
        else{
            str2 = "false";
            temp2 = 0;}

    }

    /**
     * This method displays the given quantity value on the screen.

     private void display(int number) {
     TextView quantityTextView = (TextView) findViewById(R.id.quantity);
     quantityTextView.setText("" + number);
     }
     */
    /**
     * This method displays the given price on the screen.
     */
}
