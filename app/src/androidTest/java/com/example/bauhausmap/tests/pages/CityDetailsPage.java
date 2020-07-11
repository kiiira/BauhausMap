package com.example.bauhausmap.tests.pages;

import com.example.bauhausmap.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

/**
 * Страница, описывающая CityDetailsActivity.
 */
public class CityDetailsPage extends BasePage {

    /**
     * Проверка активности и альфы кнопки.
     */
    public void checkButtonActive() {
        onView(withId(R.id.show_places_button)).check(matches(withAlpha(1f)));
        onView(withId(R.id.show_places_button)).check(matches(is(isEnabled())));
    }

    /**
     * Проверка неактивности и альфы кнопки.
     */
    public void checkButtonInactive() {
        onView(withId(R.id.show_places_button)).check(matches(withAlpha(0.5f)));
        onView(withId(R.id.show_places_button)).check(matches(is(isEnabled())));
    }

    /**
     * Нажатие кнопки отображения локаций.
     */
    public void clickShowPlacesButton() {
        onView(withId(R.id.show_places_button)).perform(click());
    }

    /**
     * Проверка отображение страницы.
     */
    public void assertPageDisplayed() {
        onView(withId(R.id.city_details_activity)).check(matches(isDisplayed()));
    }

    /**
     * Проверка названия первого города.
     *
     * @param name строка для проверки названия.
     */
    public void checkFirstCityName(String name) {
        onView(withId(R.id.city_title)).check(matches(withText(name)));
    }

    /**
     * Проверка названия первой локации.
     *
     * @param name строка для проверки первой локации.
     */
    public void checkFirstPlaceName(String name) {
        onView(withId(R.id.first_place_button)).check(matches(withText(name)));
    }

    /**
     * Кнопка первой локации.
     */
    public void clickFirstPlaceButton() {
        onView(withId(R.id.first_place_button)).perform(click());
    }

}
