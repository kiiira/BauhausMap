package com.example.bauhausmap.tests;

import androidx.test.runner.AndroidJUnit4;

import com.example.bauhausmap.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class CheckCityDetailsVisibleTest {


    @Test
    public void test() {

        onView(withId(R.id.first_button)).perform(click());

    }
}
