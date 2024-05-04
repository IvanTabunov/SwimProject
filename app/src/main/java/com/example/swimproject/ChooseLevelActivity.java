package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseLevelActivity extends AppCompatActivity {
    public static final String EXTRA_DIFFICULTY = "difficulty";
    private static final int NOVICE = 1;
    private static final int MEDIUM = 2;
    private static final int ADVANCED = 3;

    private Button buttonNovice, buttonMedium, buttonAdvanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        buttonNovice = findViewById(R.id.buttonNovice);
        buttonMedium = findViewById(R.id.buttonMedium);
        buttonAdvanced = findViewById(R.id.buttonAdvanced);

        buttonNovice.setOnClickListener(new DifficultyClickListener(NOVICE));
        buttonMedium.setOnClickListener(new DifficultyClickListener(MEDIUM));
        buttonAdvanced.setOnClickListener(new DifficultyClickListener(ADVANCED));
    }

    private class DifficultyClickListener implements View.OnClickListener {
        private int difficulty;

        public DifficultyClickListener(int difficulty) {
            this.difficulty = difficulty;
        }

        @Override
        public void onClick(View view) {
            Intent intent = createIntent(difficulty);
            startActivity(intent);
        }

        private Intent createIntent(int difficulty) {
            Intent intent = new Intent(ChooseLevelActivity.this, ChooseWorkoutActivity.class);
            intent.putExtra(EXTRA_DIFFICULTY, difficulty);
            return intent;
        }
    }
}