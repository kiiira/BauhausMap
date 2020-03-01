package com.example.bauhausmap.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bauhausmap.R;

public class ItemDetailsActivity extends Activity {

    private static final String PLACE_NAME = "Place name";
    private static final String PLACE_ADDRESS = "Place address";
    private static final String PLACE_IMAGE = "Place image";

    private TextView placeName;
    private TextView placeAddress;
    private ImageView placeImage;


    public static Intent newIntent(@NonNull Activity activity, String placeName, String placeAddress, int placeImageId) {
        Intent intent = new Intent(activity, ItemDetailsActivity.class);
        intent.putExtra(PLACE_NAME, placeName);
        intent.putExtra(PLACE_ADDRESS, placeAddress);
        intent.putExtra(PLACE_IMAGE, placeImageId);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_activity);

        placeName = findViewById(R.id.placeName);
        placeAddress = findViewById(R.id.placeAddress);
        placeImage = findViewById(R.id.placeImage);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String place_name = getIntent().getStringExtra(PLACE_NAME);
        placeName.setText(place_name);

        String place_address = getIntent().getStringExtra(PLACE_ADDRESS);
        placeAddress.setText(place_address);

//        int city_image = getIntent().getIntExtra(CITY_IMAGE, 0);
//        mCityDescription.setText(city_image);
    }
}
