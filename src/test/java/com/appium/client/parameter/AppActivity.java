package com.appium.client.parameter;

public enum AppActivity
{
    SNAPCHAT_APP_ACTIVITY("com.snapchat.android.LandingPageActivity"),
    INSTAGRAM_APP_ACTIVITY("com.instagram.android.activity.MainTabActivity");

    public final String appActivity;

    AppActivity(String appActivity)
    {
        this.appActivity = appActivity;
    }
}
