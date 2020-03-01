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


    private static final float ALPHA_ACTIVE = 1f;
    private static final float ALPHA_INACTIVE = 0.5f;


    private ImageView mCityImage;
    private TextView mCityTitle;
    private TextView mCityDescription;
    private Button mShowPlacesButton;
    private Button mFirstOption;
    private Button mSecondOption;

    private static final String CITY_NAME = "City name";
    private static final String CITY_DESCRIPTION = "City description";
    private static final String CITY_IMAGE = "City image";

    private String stuttgartFirstPlaceName;
    private String stuttgartFirstPlaceAddress;
    private int stuttgartFirstPlaceImage = 0;

    private String stuttgartSecondPlaceName;
    private String stuttgartSecondPlaceAddress;
    private int stuttgartSecondPlaceImage = 0;


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
            mShowPlacesButton.setAlpha(ALPHA_INACTIVE);
            mShowPlacesButton.setEnabled(false);
            mFirstOption.setVisibility(View.VISIBLE);
            mSecondOption.setVisibility(View.VISIBLE);
        });

        stuttgartFirstPlaceName = getString(R.string.first_place_stuttgart);
        stuttgartFirstPlaceAddress = getString(R.string.first_place_address_stuttgart);

        stuttgartSecondPlaceName = getString(R.string.second_place_stuttgart);
        stuttgartSecondPlaceAddress = getString(R.string.second_place_address_stuttgart);

        View.OnClickListener onFirstButtonClickListener = v -> {
            Intent intent = ItemDetailsActivity.newIntent(this, stuttgartFirstPlaceAddress, stuttgartFirstPlaceName, stuttgartFirstPlaceImage);
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

        int city_image = getIntent().getIntExtra(CITY_IMAGE, 0);
        mCityImage.setImageResource(R.drawable.hanover_image);
    }

}
