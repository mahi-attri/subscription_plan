package com.myntrasubscriptionplan; // Replace with your actual package name

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.BreakIterator;

public class BasicActivity extends AppCompatActivity {

    private RelativeLayout expandableView;
    private boolean isExpanded = false;
    private TextView expandableTextView;
    private TextView amountTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        expandableView = findViewById(R.id.expandableView);
        expandableTextView = findViewById(R.id.expandableTextView);
        amountTextView = findViewById(R.id.amountTextView);

        findViewById(R.id.titleTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSection();
            }
        });


        // Handle button click inside expandable view
        Button addButton = expandableView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update text and disable expandable view
                expandableTextView.setText(getString(R.string.basic_beauty));
                amountTextView.setText(getString(R.string.currency2));
                expandableView.setVisibility(View.GONE);
                isExpanded = false;
            }
        });
    }

    public void toggleSection() {
        if (isExpanded) {
            collapseView();
        } else {
            expandView();
        }
    }

    private void expandView() {
        // Set visibility to VISIBLE before animating
        expandableView.setVisibility(View.VISIBLE); // Added to ensure visibility before animation

        // Load animations
        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.expand_anim);
        expandableView.startAnimation(slideDown);

        isExpanded = true;
    }

    private void collapseView() {
        // Load animations
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.collapse_anim);
        expandableView.startAnimation(slideUp);

        // Set visibility to GONE after animating
        slideUp.setAnimationListener(new Animation.AnimationListener() { // Added AnimationListener to set visibility to GONE after animation ends
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                expandableView.setVisibility(View.GONE); // Added to ensure visibility is set to GONE after animation
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        isExpanded = false;
    }
}