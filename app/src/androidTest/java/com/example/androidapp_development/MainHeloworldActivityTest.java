package com.example.androidapp_development;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainHeloworldActivityTest {


        @Rule
        public ActivityScenarioRule<MainActivity> activityRule
                = new ActivityScenarioRule<>(MainActivity.class);


        @Before
        public void setUp() {
            //Before Test case execution
        }


        @Test
        public void isHelloWorldActivityInView() {
            onView(withId(R.id.hello)).check(matches(isDisplayed())); //
        }

        @Test
        public void is_title_ButtonsVisible() {
            onView(withId(R.id.txtHello)).check(matches(isDisplayed())); //
            onView(withId(R.id.button)).check(matches(isDisplayed())); //

        }

        @Test
        public void test_isTitleTextDisplayed() {

            onView(withId(R.id.txtHello)).check(matches(withText("HellWorldActivity")));
        }


}
