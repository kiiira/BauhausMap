package com.example.bauhausmap.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bauhausmap.R;

public class CityDetailsActivity extends Activity {

    private ImageView mCityImage;
    private TextView mCityTitle;
    private TextView mCityDescription;
    private Button mShowPlacesButton;
    private Button mFirstOption;
    private Button mSecondOption;

    private static final String CITY_NAME = "City name";
    private static final String CITY_DESCRIPTION = "City description";
    private static final String CITY_IMAGE = "City image";

    private String firstPlaceName = "Place name line 1";
    private String firstPlaceAddress = "Address line 1";
    private int firstPlaceImage = 0;

    public static Intent newIntent(@NonNull Activity activity, String cityName, String cityDescription, int cityImageId) {
        Intent intent = new Intent(activity, CityDetailsActivity.class);
        intent.putExtra(CITY_NAME, cityName);
        intent.putExtra(CITY_DESCRIPTION, cityDescription);
        intent.putExtra(CITY_IMAGE, cityImageId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.city_details_activity);
        mCityImage = findViewById(R.id.headerImage);
        mCityTitle = findViewById(R.id.cityTitle);
        mCityDescription = findViewById(R.id.description);
        mShowPlacesButton = findViewById(R.id.showPlacesButton);
        mFirstOption = findViewById(R.id.firstPlaceButton);
        mSecondOption = findViewById(R.id.secondPlaceButton);


        mFirstOption.setVisibility(View.GONE);
        mSecondOption.setVisibility(View.GONE);

        mShowPlacesButton.setOnClickListener(v -> {
            mShowPlacesButton.setVisibility(View.GONE);
            mFirstOption.setVisibility(View.VISIBLE);
            mSecondOption.setVisibility(View.VISIBLE);
        });

        View.OnClickListener onFirstButtonClickListener = v -> {
            Intent intent = ItemDetailsActivity.newIntent(this, firstPlaceAddress, firstPlaceName, firstPlaceImage);
            startActivity(intent);
        };

        mFirstOption.setOnClickListener(onFirstButtonClickListener);

    }


    @Override
    protected void onResume() {
        super.onResume();

        String city_name = getIntent().getStringExtra(CITY_NAME);
        mCityTitle.setText(city_name);

        String city_description = getIntent().getStringExtra(CITY_DESCRIPTION);
        mCityDescription.setText(city_description);

//        int city_image = getIntent().getIntExtra(CITY_IMAGE, 0);
//        mCityDescription.setText(city_image);
    }

}
