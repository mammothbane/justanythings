package com.mammothbane.justanythings.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.mammothbane.justanythings.R;
import com.mammothbane.justanythings.fragments.MainFragment;
import com.mammothbane.justanythings.fragments.TumblrFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class MainActivity extends SherlockFragmentActivity {

    @InjectView(R.id.vp_main)
    ViewPager viewPager;

    Fragment[] fragments = { new com.mammothbane.justanythings.fragments.CameraFragment(), new MainFragment(), new TumblrFragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments[i];
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        viewPager.setCurrentItem(1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }



}
