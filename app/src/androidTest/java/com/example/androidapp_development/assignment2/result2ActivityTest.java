package com.example.androidapp_development.assignment2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.androidapp_development.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class result2ActivityTest {


    @Rule
    public ActivityScenarioRule<result2Activity> activityScenarioRule
            = new ActivityScenarioRule<>(result2Activity.class);
    @Test
    public void isBackButtenOpenTheFirstActivity() {
     
        onView(withId(R.id.backbtn)).perform(click());

    }

    @Test
    public void test_isTitleTextDisplayed() {
        
        onView(withId(R.id.backbtn)).check(matches(isDisplayed()));
        //
    }
    
}
