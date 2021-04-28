package com.example.androidapp_development;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class signupTest {
    @Rule
    public ActivityScenarioRule<signup> activityScenarioRule =
            new ActivityScenarioRule<signup>(signup.class);

    @Test
    public void test_title_currentdate_signupbuttonVisiblity()
    {
        //test signupForm title visible
        onView(withId(R.id.signupForm)).check(matches(isDisplayed()));
        //test the sinup button visible
        onView(withId(R.id.signup)).check(matches(isDisplayed()));
        //test if current date is visable
        onView(withId(R.id.date)).check(matches(isDisplayed()));
    }
    @Test
    public void test_navigationToSecondActivity()
    {
        //test if the signup button click it will go to the result activity page

        onView(withId(R.id.signup)).perform(click());


    }

}