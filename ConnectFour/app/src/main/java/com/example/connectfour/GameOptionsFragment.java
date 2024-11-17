package com.example.connectfour;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

public class GameOptionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_game_options, container, false);

        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Select the radio button matching the level selected
        int diffSelect = sharedPref.getInt("difficulty", R.id.Easy);
        int radioId = R.id.Easy;

        if (radioId == R.id.Easy) {
            radioId = R.id.Easy;
        }
        else if (radioId == R.id.Medium) {
            radioId = R.id.Medium;
        }
        else if (radioId == R.id.Hard) {
            radioId = R.id.Hard;
        }

        RadioButton radio = inf.findViewById(radioId);
        radio.setChecked(true);

        // Add click callback to all radio buttons
        RadioGroup group_radio = inf.findViewById(R.id.radiogroupfragmentgameoptions);
        for (int i = 0; i < group_radio.getChildCount(); i++) {
            radio = (RadioButton) group_radio.getChildAt(i);
            radio.setOnClickListener(this::Difficulty);
        }

        return inf;
    }

    public void Difficulty(View view) {
        int difficultyId = R.id.Easy;
        if (view.getId() == R.id.Easy) {
            difficultyId = R.id.Easy;
        } else if (view.getId() == R.id.Medium) {
            difficultyId = R.id.Medium;
        } else if (view.getId() == R.id.Hard) {
            difficultyId = R.id.Hard;
        }

        // Save selected color ID in SharedPreferences
        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("difficulty", difficultyId);
        editor.apply();

    }
}