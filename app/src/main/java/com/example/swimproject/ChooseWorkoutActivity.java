package com.example.swimproject;

import static com.example.swimproject.ChooseLevelActivity.EXTRA_DIFFICULTY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseWorkoutActivity extends AppCompatActivity {
    public static final String EXTRA_GOAL = "goal";
    private static final int STAMINA = 1;
    private static final int TECHNIQUE = 2;
    private static final int COMPETITION = 3;
    private static final int OPEN = 4;

    private Button buttonStamina, buttonTechnique, buttonCompetition, buttonOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_workout);
        buttonStamina = findViewById(R.id.buttonChoice1);
        buttonTechnique = findViewById(R.id.buttonChoice2);
        buttonCompetition = findViewById(R.id.buttonChoice3);
        buttonOpen = findViewById(R.id.buttonChoice4);

        buttonStamina.setOnClickListener(new ChooseWorkoutActivity.GoalClickListener(STAMINA));
        buttonTechnique.setOnClickListener(new ChooseWorkoutActivity.GoalClickListener(TECHNIQUE));
        buttonCompetition.setOnClickListener(new ChooseWorkoutActivity.GoalClickListener(COMPETITION));
        buttonOpen.setOnClickListener(new ChooseWorkoutActivity.GoalClickListener(OPEN));


    }

    private class GoalClickListener implements View.OnClickListener {
        private int goal;

        public GoalClickListener(int goal) {
            this.goal = goal;
        }

        @Override
        public void onClick(View view) {
            Intent intentDifficulty = getIntent();
            int difficultyValue = intentDifficulty.getIntExtra(EXTRA_DIFFICULTY, 0);
            Intent intent = createIntent(goal, difficultyValue);
            startActivity(intent);
        }

        private Intent createIntent(int goal, int difficult) {
            Intent intent = new Intent(ChooseWorkoutActivity.this, ProfileActivity.class);
            intent.putExtra(EXTRA_GOAL, goal);
            intent.putExtra(EXTRA_DIFFICULTY, difficult);
            return intent;
        }
    }

}