package com.example.androidapp_development;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class resultTest {
    @Rule
    public ActivityScenarioRule<signup> activityScenarioRule =
            new ActivityScenarioRule<signup>(signup.class);

    @Test
    public void test_navigationToSecondActivity()
    {
        //test if the signup button click it will go to the result activity page

        onView(withId(R.id.signup)).perform(click());

        onView(withId(R.id.fname2)).check(matches(isDisplayed()));
    }



}