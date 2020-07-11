package com.example.bauhausmap.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bauhausmap.R;

/**
 * Активити, описывающая детали отдельной локации: название локации, адрес, ссылка на гугл карты.
 */
public class ItemDetailsActivity extends Activity {

    private static final String PLACE_NAME = "Place name";
    private static final String PLACE_ADDRESS = "Place address";
    private static final String PLACE_IMAGE = "Place image";

    private TextView placeName;
    private TextView placeAddress;
    private TextView placeGoogleMaps;
    private ImageView placeImage;

    private String location;
    private String map;

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

        placeName = findViewById(R.id.place_name);
        placeAddress = findViewById(R.id.place_address);
        placeGoogleMaps = findViewById(R.id.open_google_maps);
        location = getString(R.string.first_place_address_stuttgart)
                .replaceAll(" ", "+");
        map = "http://maps.google.co.in/maps?q=" + location;

        placeGoogleMaps.setOnClickListener(v -> new Handler().postDelayed(() -> {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
//            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }, 1000));
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
