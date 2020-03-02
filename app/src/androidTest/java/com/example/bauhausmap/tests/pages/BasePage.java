package com.example.bauhausmap.tests.pages;

import android.content.Intent;
import android.os.Build;

import androidx.test.uiautomator.UiDevice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

class BasePage {

    private static final int UIAUTOMATOR_MIN_SDK = 18;

    private static UiDevice sUiDevice = null;

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

    public static boolean isUIAvailable() {
        return Build.VERSION.SDK_INT >= UIAUTOMATOR_MIN_SDK;
    }

    public void collapseAndExpandApp(){
        String packageName = getInstrumentation().getTargetContext().getPackageName();
        if (isUIAvailable()) {
            UiDevice uiDevice = getUiDevice();
            uiDevice.pressHome();
            Intent intent = getInstrumentation().getContext().getPackageManager().getLaunchIntentForPackage(packageName);
            getInstrumentation().getContext().startActivity(intent);
        }
    }

}
