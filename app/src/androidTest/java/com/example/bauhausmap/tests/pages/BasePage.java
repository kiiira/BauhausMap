package com.example.bauhausmap.tests.pages;

import android.os.Build;

import androidx.test.uiautomator.UiDevice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;


/**
 * Базовая страница.
 */
class BasePage {

    /**
     * Минимальная версия SDK, которую поддерживает UI Automator.
     */
    private static final int UIAUTOMATOR_MIN_SDK = 18;

    private static UiDevice sUiDevice = null;

    public static boolean isUIAvailable() {
        return Build.VERSION.SDK_INT >= UIAUTOMATOR_MIN_SDK;
    }

    public static UiDevice getUiDevice() {
        if (sUiDevice == null) {
            if (!isUIAvailable()) {
                try {
                    throw new Exception("Требуется версия api " + UIAUTOMATOR_MIN_SDK + " или выше.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sUiDevice = UiDevice.getInstance(getInstrumentation());
        }
        return sUiDevice;
    }

}
