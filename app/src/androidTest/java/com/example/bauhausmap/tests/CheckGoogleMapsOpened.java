package com.example.bauhausmap.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.bauhausmap.activities.CityDetailsActivity;
import com.example.bauhausmap.activities.ItemDetailsActivity;
import com.example.bauhausmap.activities.MainActivity;
import com.example.bauhausmap.tests.pages.CityDetailsPage;
import com.example.bauhausmap.tests.pages.ItemDetailsPage;
import com.example.bauhausmap.tests.pages.MainPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class CheckGoogleMapsOpened {


    private MainPage mainPage;
    private CityDetailsPage cityDetailsPage;
    private ItemDetailsPage itemDetailsPage;

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);
    private ActivityScenarioRule<CityDetailsActivity> cityDetailActivityRule = new ActivityScenarioRule<>(CityDetailsActivity.class);
    private ActivityScenarioRule<ItemDetailsActivity> itemDetailsActivityRule = new ActivityScenarioRule<>(ItemDetailsActivity.class);


    @Before
    public void setUp() {
        mainPage = new MainPage(mainActivityRule);
        cityDetailsPage = new CityDetailsPage(cityDetailActivityRule);
        itemDetailsPage = new ItemDetailsPage(itemDetailsActivityRule);
    }

    @Test
    public void testGoogleMapsOpenByButtonClick() {

        mainPage.assertPageDisplayed();
        mainPage.clickFirstButton();

        cityDetailsPage.assertPageDisplayed();
        cityDetailsPage.clickShowPlacesButton();
        cityDetailsPage.clickFirstPlaceButton();

        itemDetailsPage.assertPageDisplayed();
        itemDetailsPage.checkAddressDisplayed();
        itemDetailsPage.assertAddressInput();

        itemDetailsPage.clickOpenMapButton();
        itemDetailsPage.checkGoogleMapsOpened();
    }
}