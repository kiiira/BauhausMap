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
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4ClassRunner.class)
public class CheckCityDetailsVisibleTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivity = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testButtonDisables() {
        onView(withId(R.id.first_button)).perform(click());
        onView(withId(R.id.showPlacesButton)).perform(click()).check(matches(withAlpha(0.5f)));
        onView(withId(R.id.showPlacesButton)).check(matches(not(isEnabled())));
    }
}
