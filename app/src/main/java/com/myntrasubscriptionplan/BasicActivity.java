package com.myntrasubscriptionplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        // Handle click on left icon to return to MainActivity
        ImageView leftIcon = findViewById(R.id.left_icon);
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });

        // Setup the Add button click listener
        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextAndCurrency();
                // Remove the button after click
                RelativeLayout parentLayout = (RelativeLayout) v.getParent();
                if (parentLayout != null) {
                    parentLayout.removeView(v);
                }
            }
        });

        // Setup the Select button click listener
        Button selectButton = findViewById(R.id.select_button);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic for the select button here
            }
        });
    }

    private void updateTextAndCurrency() {
        TextView currencyTextView = findViewById(R.id.amountTextView);
        if (currencyTextView != null) {
            currencyTextView.setText(getString(R.string.final_basic_currency));
        } else {
            Log.e("BasicActivity", "currencyTextView is null");
        }
    }
}
