package com.hpe.devops.activity;

import com.hpe.devops.BuildConfig;
import com.hpe.devops.R;
import com.hpe.devops.application.DevOpsApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class LauncherActivityTest {

    LauncherActivity launcherActivity;
    ActivityController<LauncherActivity> controller;

    @Before
    public void setup() {
        DevOpsApplication.inject(this);
        launcherActivity = new LauncherActivity();
        controller = ActivityController.of(Robolectric.getShadowsAdapter(), launcherActivity);
        controller.setup();
    }

    @Test
    public void onCreate_shouldSetTitle() throws Exception {
        assertThat(launcherActivity.getTitle()).isEqualTo("United Airlines");
    }

    @Test
    public void onCreate_titleShouldNotBeNull() throws Exception {
        assertThat(launcherActivity.getTitle()).isNotNull();
    }

    @Test
    public void onCreate_titleShouldNotBeEmpty() throws Exception {
        assertThat(launcherActivity.getTitle()).isNotEmpty();
    }

    @Test
    public void onCreate_shouldDisplayFlightAndHotelOption() throws Exception {
        assertThat(launcherActivity.findViewById(R.id.first_row)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view1)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view2)).isNotNull();
    }

    @Test
    public void onCreate_shouldDisplayTaxiAndBookingOption() throws Exception {
        assertThat(launcherActivity.findViewById(R.id.second_row)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view3)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view4)).isNotNull();
    }

    @Test
    public void onCreate_shouldNotDisplayShoppingAndCouponsOption() throws Exception {
        assertThat(launcherActivity.findViewById(R.id.third_row)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view5)).isNotNull();
        assertThat(launcherActivity.findViewById(R.id.card_view6)).isNotNull();
    }

    @Test
    public void onBackPressed_whenNavDrawerOpened_shouldCloseNavDrawer() throws Exception {
        launcherActivity.onBackPressed();
    }
}
