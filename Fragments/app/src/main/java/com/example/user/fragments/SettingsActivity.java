package com.example.user.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity implements SettingsFragment.OnPreferenceSelectedListener {

    private final String SETTINGS_TAG = "settings";
    private final String SECURITY_TAG = "security";
    private ActionBar actionBar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().replace(android.R.id.content, new SettingsFragment()).addToBackStack(SETTINGS_TAG).commit();
    }

    @Override
    public void onSecuritySelected() {
        fragmentManager.beginTransaction().replace(android.R.id.content, new SecurityFragment()).addToBackStack(SECURITY_TAG).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStack();
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
