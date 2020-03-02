package com.example.bauhausmap.tests.pages;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.example.bauhausmap.R;
import com.example.bauhausmap.activities.ItemDetailsActivity;

import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.bauhausmap.tests.matchers.TextMatcher.hasValueEqualTo;

public class ItemDetailsPage extends BasePage{

    @Rule
    public ActivityScenarioRule<ItemDetailsActivity> rule;

    public ItemDetailsPage(ActivityScenarioRule<ItemDetailsActivity> rule) {
        this.rule = rule;
    }

    public void assertPageDisplayed(){
        onView(withId(R.id.item_details)).check(matches(isDisplayed()));
    }

    public void checkNameDisplayed(){
        onView(withId(R.id.place_name)).check(matches(isDisplayed()));
    }

    public void checkAddressDisplayed(){
        onView(withId(R.id.place_address)).check(matches(isDisplayed()));
    }

    public void clickOpenMapButton(){
        onView(withId(R.id.open_google_maps)).perform(click());
    }

    public void checkGoogleMapsOpened(){
        UiObject map = getUiDevice().findObject(new UiSelector().descriptionContains("Google Maps"));
        try {
            map.isEnabled();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void assertAddressInput(){
        onView(withId(R.id.place_name)).check(matches
                (hasValueEqualTo(InstrumentationRegistry.getTargetContext()
                        .getString(R.string.first_place_address_stuttgart))));
    }
}
