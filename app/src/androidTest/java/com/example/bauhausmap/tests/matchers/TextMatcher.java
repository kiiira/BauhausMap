package com.example.bauhausmap.tests.matchers;

import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class TextMatcher {

    public static Matcher<View> hasValueEqualTo(final String content) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Has EditText/TextView the value:  " + content);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (view != null) {
                    String text = ((TextView) view).getText().toString();
                    return (text.equalsIgnoreCase(content));
                }
                return false;
            }
        };
    }
}
