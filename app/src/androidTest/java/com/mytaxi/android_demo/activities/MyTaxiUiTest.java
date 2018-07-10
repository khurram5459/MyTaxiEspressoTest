package com.mytaxi.android_demo.activities;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;

import android.support.test.rule.GrantPermissionRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyTaxiUiTest {

    @Rule
    public GrantPermissionRule grantPermissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void myTaxiUiTest() throws Exception{
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.edt_username),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText.perform(click());

        ViewInteraction userEditText = onView(
                allOf(withId(R.id.edt_username),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
                        isDisplayed()));
        userEditText.perform(click());
//
//        ViewInteraction appCompatEditText3 = onView(
//                allOf(withId(R.id.edt_username),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText2.perform(replaceText("crazydog"), closeSoftKeyboard());

//        ViewInteraction appCompatEditText4 = onView(
//                allOf(withId(R.id.edt_username), withText("crazydog"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText4.perform(click());

//        ViewInteraction appCompatEditText5 = onView(
//                allOf(withId(R.id.edt_username), withText("crazydog"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
//                        isDisplayed()));
        userEditText.perform(replaceText("crazydog335"));

//        ViewInteraction appCompatEditText6 = onView(
//                allOf(withId(R.id.edt_username), withText("crazydog335"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.design.widget.TextInputLayout")),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText6.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.edt_password),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("venture"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        isDisplayed()));
        appCompatButton.perform(click());

        Thread.sleep(3000);

        ViewInteraction appCompatAutoCompleteTextView = onView(
                allOf(withId(R.id.textSearch),
//                        childAtPosition(
//                                allOf(withId(R.id.searchContainer),
//                                        childAtPosition(
//                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
//                                                1)),
//                                0),
                        isDisplayed()));
        appCompatAutoCompleteTextView.perform(typeText("sa"));

        Thread.sleep(3000);

        onData(hasToString(containsString("Sarah Scott")))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

//        onView(withText("Sarah Scott"))
//                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
//                .perform(click());

        // Checking if driver profile screen is opened
        ViewInteraction textView = onView(
                allOf(withText("Driver Profile"),
//                        childAtPosition(
//                                allOf(withId(R.id.toolbar),
//                                        childAtPosition(
//                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
//                                                0)),
//                                0),
                        isDisplayed()));
        textView.check(matches(withText("Driver Profile")));

        // click call button
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                2),
                        isDisplayed()));
        floatingActionButton.perform(click());

    }

//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }


    @After
    public void tearDown () {
        new SharedPrefStorage(mActivityTestRule.getActivity()).resetUser();
    }
}
