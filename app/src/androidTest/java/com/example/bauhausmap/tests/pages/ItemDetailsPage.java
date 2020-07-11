package com.example.bauhausmap.tests.pages;

import android.widget.EditText;
import android.widget.TextView;

import androidx.test.InstrumentationRegistry;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.example.bauhausmap.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.bauhausmap.tests.matchers.TextMatcher.hasValueEqualTo;
import static org.junit.Assert.assertEquals;

/**
 * Страница, описывающая ItemDetailsActivity.
 */
public class ItemDetailsPage extends BasePage {

    /**
     * Проверка отображения страницы.
     */
    public void assertPageDisplayed() {
        onView(withId(R.id.item_details)).check(matches(isDisplayed()));
    }

    /**
     * Проверка отображения названия локации.
     */
    public void checkNameDisplayed() {
        onView(withId(R.id.place_name)).check(matches(isDisplayed()));
    }

    /**
     * Проверка отображения адреса.
     */
    public void checkAddressDisplayed() {
        onView(withId(R.id.place_address)).check(matches(isDisplayed()));
    }

    /**
     * Нажатие кнопки открытия Google Maps.
     */
    public void clickOpenMapButton() {
        onView(withId(R.id.open_google_maps)).perform(click());
    }

    /**
     * Проверка открытия приложения Google Maps.
     */
    public void checkGoogleMapsOpened() {
        UiObject map = getUiDevice().findObject(new UiSelector().descriptionContains("Google Maps"));
        try {
            map.isEnabled();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверка текста элемента, содержащего адрес и строки с адресом.
     */
    public void assertAddressInput() {
        onView(withId(R.id.place_address)).check(matches
                (hasValueEqualTo(InstrumentationRegistry.getTargetContext()
                        .getString(R.string.first_place_address_stuttgart))));
    }

    /**
     * Проверить, что передался правильный текст адреса в поле ввода в Google Maps.
     *
     * @throws UiObjectNotFoundException обработка не найденного объекта.
     */
    public void assertAddressInputCorrect() throws UiObjectNotFoundException {
        UiObject mapInputFieldParent = getUiDevice().findObject(new UiSelector().className(EditText.class));
        UiObject child = mapInputFieldParent.getChild(new UiSelector().className(TextView.class).instance(0));
        String inputFieldText = child.getText();
        assertEquals(inputFieldText, InstrumentationRegistry.getTargetContext()
                .getString(R.string.first_place_address_stuttgart));
    }
}
