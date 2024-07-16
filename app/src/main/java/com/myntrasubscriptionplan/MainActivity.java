package com.myntrasubscriptionplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Optional: Remove the ActionBar if it exists
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Setup click listeners for each subscription option
        setupClickListener(R.id.relativeLayout3, "Basic 1-Month Subscription clicked!", true);
        setupClickListener(R.id.relativeLayout4, "Standard 3-Month Subscription clicked!", false);
        setupClickListener(R.id.relativeLayout5, "Premium 6-Month Subscription clicked!", false);
        setupClickListener(R.id.relativeLayout6, "Elite 12-Month Subscription clicked!", false);
    }

    private void setupClickListener(int layoutId, String message, boolean switchActivity) {
        RelativeLayout layout = findViewById(layoutId);
        layout.setOnClickListener(v -> {
            layout.setBackgroundResource(R.drawable.hover_effect); // Ensure hover_effect drawable exists
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            if (switchActivity) {
                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                startActivity(intent);
            }
        });
    }
}
