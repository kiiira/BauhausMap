package com.example.bauhausmap.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.bauhausmap.R;

public class MainActivity extends Activity {

    private String firstCityName;
    private String secondCityName;

    private String firstCityDescription;
    private String secondCityDescription;

    private static final int citiesImageId = R.drawable.cities_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton firstImageButton = findViewById(R.id.first_button);
        ImageButton secondImageButton = findViewById(R.id.second_button);

        firstCityDescription = getString(R.string.first_city_desc);
        secondCityDescription = getString(R.string.second_city_desc);

        firstCityName = getString(R.string.Stuttgart);
        secondCityName = getString(R.string.Hanover);


        View.OnClickListener onFirstButtonClickListener = v -> {
            Intent intent = CityDetailsActivity.newIntent(this, firstCityName, firstCityDescription, citiesImageId);
            startActivity(intent);
            };

        View.OnClickListener onSecondButtonClickListener = v -> {
            Intent intent = CityDetailsActivity.newIntent(this, secondCityName, secondCityDescription, citiesImageId);
            startActivity(intent);
        };

        firstImageButton.setOnClickListener(onFirstButtonClickListener);
        secondImageButton.setOnClickListener(onSecondButtonClickListener);

    }

}
