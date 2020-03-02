package com.example.bauhausmap.tests.pages;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.bauhausmap.R;
import com.example.bauhausmap.activities.CityDetailsActivity;

import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class CityDetailsPage {

    @Rule
    public ActivityScenarioRule<CityDetailsActivity> rule;

    public CityDetailsPage(ActivityScenarioRule<CityDetailsActivity> rule) {
        this.rule = rule;
    }

    public void checkButtonActive(){
        onView(withId(R.id.showPlacesButton)).check(matches(withAlpha(1f))).check(matches(is(isEnabled())));
    }

    public void checkButtonInactive(){
        onView(withId(R.id.showPlacesButton)).check(matches(withAlpha(0.5f))).check(matches(not(isEnabled())));
    }

    public void clickShowPlacesButton(){
        onView(withId(R.id.showPlacesButton)).perform(click());
    }

    public void assertPageDisplayed(){
        onView(withId(R.id.city_details_activity)).check(matches(isDisplayed()));
    }

    public void checkFirstCityName(String name){
        onView(withId(R.id.cityTitle)).check(matches(withText(name)));
    }

    public void checkFirstPlaceName(String name){
        onView(withId(R.id.firstPlaceButton)).check(matches(withText(name))).perform(click());
    }

}
