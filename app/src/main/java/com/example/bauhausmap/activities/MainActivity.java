package com.example.bauhausmap.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.bauhausmap.R;

public class MainActivity extends Activity {

    private String firstCityName = "Stuttgart";
    private String secondCityName = "München";

    //TODO: get strings from string.xml
    String firstCityDescription = "";
    String secondCityDescription = "";

    //TODO: get images
    private static final int firstCityImageId = R.drawable.stuttgart_image;
    private static final int secondCityImageId = R.drawable.cologne_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton firstImageButton = findViewById(R.id.first_button);
        ImageButton secondImageButton = findViewById(R.id.second_button);

        View.OnClickListener onFirstButtonClickListener = v -> {
            Intent intent = CityDetailsActivity.newIntent(this, firstCityName, firstCityDescription, firstCityImageId);
            startActivity(intent);
            };

        View.OnClickListener onSecondButtonClickListener = v -> {
            Intent intent = CityDetailsActivity.newIntent(this, secondCityName, secondCityDescription, secondCityImageId);
            startActivity(intent);
        };

        firstImageButton.setOnClickListener(onFirstButtonClickListener);
        secondImageButton.setOnClickListener(onSecondButtonClickListener);

    }

}
