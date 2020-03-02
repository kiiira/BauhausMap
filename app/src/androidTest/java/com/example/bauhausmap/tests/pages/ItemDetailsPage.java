package com.example.bauhausmap.tests.pages;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.bauhausmap.R;
import com.example.bauhausmap.activities.ItemDetailsActivity;

import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class ItemDetailsPage {

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

}
