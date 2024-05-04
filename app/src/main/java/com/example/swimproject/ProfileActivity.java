package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView difficulty;
    private TextView goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        difficulty = findViewById(R.id.textViewDifficulty);
        goal = findViewById(R.id.textViewGoal);

        Intent intentDifficulty = getIntent();
        int difficultyValue = intentDifficulty.getIntExtra(ChooseLevelActivity.EXTRA_DIFFICULTY, 0);

        Intent intentGoal = getIntent();
        int goalValue = intentGoal.getIntExtra(ChooseWorkoutActivity.EXTRA_GOAL, 0);


        switch (difficultyValue) {
            case 1:
                difficulty.setText("новичок");
                break;
            case 2:
                difficulty.setText("средний");
                break;
            case 3:
                difficulty.setText("крутой");
                break;
        }

        switch (goalValue) {
            case 1:
                goal.setText("выносливость");
                break;
            case 2:
                goal.setText("техника");
                break;
            case 3:
                goal.setText("соревы");
                break;
            case 4:
                goal.setText("дальнобой");
                break;
        }
    }
}