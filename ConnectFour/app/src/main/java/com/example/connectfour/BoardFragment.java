package com.example.connectfour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/*board class that redirects to activity board when clicked*/
public class BoardFragment extends Fragment {

    final String GAME_STATE = "gameState";
    ConnectFourGame mGame;
    GridLayout mGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View gLayout = inflater.inflate(R.layout.fragment_board, container, false);

        mGrid = gLayout.findViewById(R.id.glayout);

        for (int i = 0; i < mGrid.getChildCount(); i++) {
            Button button = (Button) mGrid.getChildAt(i);
            button.setOnClickListener(this::onButtonClick);
        }

        return gLayout;
    }

    private void onButtonClick(View view) {
        //stub
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(GAME_STATE, mGame.getState());
    }


}
