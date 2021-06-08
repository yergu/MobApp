package com.example.androidapp_development;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

 @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void isActivityLounched()
    {
        onView(withId(R.id.hello)).check(matches(isDisplayed())); //
    }
    @Test
    public void isButtonAndTexBoxVisible() {
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withId(R.id.txtHello)).check(matches(isDisplayed()));

        onView(withId(R.id.edtTxtFname)).check(matches(isDisplayed()));
    }
    @Test
    public void testDisplayFirstNmeEntry()
    {
        onView(withId(R.id.edtTxtFname)).perform(typeText("Yergalem"),
                closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.txtHello)).check(matches(withText("Hi Yergalem")));

    }

}