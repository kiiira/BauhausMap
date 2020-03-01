package com.example.bauhausmap.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.bauhausmap.R;
import com.example.bauhausmap.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4ClassRunner.class)
public class CheckCityDetailsVisibleTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivity = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    private static final String FIRST_CITY_NAME = "Stuttgart";
    private static final String FIRST_PLACE_NAME = "Kultur- & Kongresszentrum Liederhalle";

    /**
     * Тест на проверку доступности и состояния отображения кнопки.
     */
    @Test
    public void testButtonDisabled() {
        onView(withId(R.id.first_button)).perform(click());
        onView(withId(R.id.showPlacesButton)).perform(click()).check(matches(withAlpha(0.5f)));
        onView(withId(R.id.showPlacesButton)).check(matches(not(isEnabled())));
    }

    /**
     * Тест на проверку отображения элементов экрана адреса.
     */
    @Test
    public void testItemDetailsVisible() {
        onView(withId(R.id.first_button)).perform(click());
        onView(withId(R.id.showPlacesButton)).perform(click());
        onView(withId(R.id.cityTitle)).check(matches(withText(FIRST_CITY_NAME)));
        onView(withId(R.id.firstPlaceButton)).check(matches(withText(FIRST_PLACE_NAME))).perform(click());
        onView(withId(R.id.placeAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.placeName)).check(matches(isDisplayed()));
    }
}
