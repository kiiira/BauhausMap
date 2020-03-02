package com.example.bauhausmap.tests.pages;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.bauhausmap.R;
import com.example.bauhausmap.activities.MainActivity;

import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainPage {

    @Rule
    public ActivityScenarioRule<MainActivity> rule;

    public MainPage(ActivityScenarioRule<MainActivity> rule) {
        this.rule = rule;
    }

    public void clickFirstButton(){
        onView(withId(R.id.first_button)).perform(click());
    }

    public void clickSecondButton(){
        onView(withId(R.id.second_button)).perform(click());
    }

    public void assertPageDisplayed(){
        onView(withId(R.id.button_layout)).check(matches(isDisplayed()));
    }

}
