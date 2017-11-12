package com.example.user.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.Preference;

/**
 * Created by User on 12.11.2017.
 */

public class SettingsFragment extends PreferenceFragment {
    private OnPreferenceSelectedListener mListener;

    public interface OnPreferenceSelectedListener {
        void onSecuritySelected();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnPreferenceSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnPreferenceSelectedListener");
        }
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.app_preferences);

        Preference preference1 = findPreference("key1");
        Preference preference2 = findPreference("key1");

        preference1.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                mListener.onSecuritySelected();
                return false;
            }
        });
    }

    @Override
    public void onStart() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.settings_tag);
        super.onStart();
    }
}