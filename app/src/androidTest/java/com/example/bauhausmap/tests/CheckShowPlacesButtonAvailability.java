package com.example.bauhausmap.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.bauhausmap.activities.MainActivity;
import com.example.bauhausmap.tests.pages.CityDetailsPage;
import com.example.bauhausmap.tests.pages.MainPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Тест на проверку доступности и состояния отображения кнопки.
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class CheckShowPlacesButtonAvailability {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);
    private MainPage mainPage;
    private CityDetailsPage cityDetailsPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(mainActivityRule);
        cityDetailsPage = new CityDetailsPage();
    }

    @Test
    public void testButtonDisabled() {

        mainPage.assertPageDisplayed();
        mainPage.clickFirstButton();

        cityDetailsPage.assertPageDisplayed();
        cityDetailsPage.checkButtonActive();
        cityDetailsPage.clickShowPlacesButton();
        cityDetailsPage.checkButtonInactive();
    }
}