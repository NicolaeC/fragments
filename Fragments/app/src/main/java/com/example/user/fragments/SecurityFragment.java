package com.example.user.fragments;

import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 12.11.2017.
 */

public class SecurityFragment extends PreferenceFragment {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.security);
    }

    @Override
    public void onStart() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.security_tag);
        super.onStart();
    }
}
