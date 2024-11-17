package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /*onCreate for this java class*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottom_nav);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.boardfragment);

        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(
                    R.id.boardfragment, R.id.gameoptionsfragment)
                    .build();

            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
            NavigationUI.setupWithNavController(navView, navController);
        }
    }
}


//    /*when connect4 is clicked*/
//    public void onConnect4Click(View view) {
//        Intent intent = new Intent(this, BoardFragment.class);
//        startActivity(intent);
//    }
//
//    /*when options for difficulty is clicked*/
//    public void whenChangingDifficulty(View view) {
//        Intent intent = new Intent(this, GameOptionsFragment.class);
//        ActivityResultLauncherMain.launch(intent);
//    }
//
//    /*ActivityResultLauncher for toasts depending on which difficulty selected*/
//    ActivityResultLauncher<Intent> ActivityResultLauncherMain = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            result -> {
//                if (result.getResultCode() == GameOptionsFragment.RESULT_OK) {
//                    Intent data = result.getData();
//                    if(data != null){
//                        int difficultyId = data.getIntExtra(GameOptionsFragment.DIFFICULTY_SELECTOR, R.id.Easy);
//                        if(difficultyId == R.id.Easy){
//                            Toast toast = Toast.makeText(this, "Easy", Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                        else if(difficultyId == R.id.Medium){
//                            Toast toast = Toast.makeText(this, "Medium", Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                        else if(difficultyId == R.id.Hard){
//                            Toast toast = Toast.makeText(this, "Hard", Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                    }
//                }
//            });


