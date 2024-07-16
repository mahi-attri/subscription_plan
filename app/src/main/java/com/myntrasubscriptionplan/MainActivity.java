package com.myntrasubscriptionplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Remove the ActionBar if it exists
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupClickListener(R.id.relativeLayout3, "Third RelativeLayout clicked!", true);
        setupClickListener(R.id.relativeLayout4, "Fourth RelativeLayout clicked!", false);
        setupClickListener(R.id.relativeLayout5, "Fifth RelativeLayout clicked!", false);
        setupClickListener(R.id.relativeLayout6, "Sixth RelativeLayout clicked!", false);
    }

    private void setupClickListener(int layoutId, String message, boolean switchActivity) {
        RelativeLayout layout = findViewById(layoutId);
        layout.setOnClickListener(v -> {
            layout.setBackgroundResource(R.drawable.hover_effect);
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            if (switchActivity) {
                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                startActivity(intent);
            }
        });
    }
}
