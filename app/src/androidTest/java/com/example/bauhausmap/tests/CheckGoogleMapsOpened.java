package com.example.bauhausmap.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.example.bauhausmap.activities.MainActivity;
import com.example.bauhausmap.tests.pages.CityDetailsPage;
import com.example.bauhausmap.tests.pages.ItemDetailsPage;
import com.example.bauhausmap.tests.pages.MainPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Тест на проверку открытия Google Maps
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class CheckGoogleMapsOpened {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);
    private MainPage mainPage;
    private CityDetailsPage cityDetailsPage;
    private ItemDetailsPage itemDetailsPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(mainActivityRule);
        cityDetailsPage = new CityDetailsPage();
        itemDetailsPage = new ItemDetailsPage();
    }

    @Test
    public void testGoogleMapsOpenByButtonClick() throws UiObjectNotFoundException {

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
        itemDetailsPage.assertAddressInputCorrect();
    }
}