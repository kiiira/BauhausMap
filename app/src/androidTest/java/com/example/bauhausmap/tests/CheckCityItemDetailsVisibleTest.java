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
public class CheckCityItemDetailsVisibleTest {


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

    private static final String FIRST_CITY_NAME = "Stuttgart";
    private static final String FIRST_PLACE_NAME = "Kultur- & Kongresszentrum Liederhalle";

    /**
     * Тест на проверку отображения элементов экрана адреса.
     */
    @Test
    public void testItemDetailsVisible() {
        mainPage.assertPageDisplayed();
        mainPage.clickFirstButton();
        cityDetailsPage.assertPageDisplayed();
        cityDetailsPage.clickShowPlacesButton();
        cityDetailsPage.checkFirstCityName(FIRST_CITY_NAME);
        cityDetailsPage.checkFirstPlaceName(FIRST_PLACE_NAME);
        itemDetailsPage.assertPageDisplayed();
        itemDetailsPage.checkAddressDisplayed();
        itemDetailsPage.checkNameDisplayed();

    }
}
