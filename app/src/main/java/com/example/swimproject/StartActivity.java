package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        startSingIn(buttonStart);
    }

    public void startSingIn(View view) {
        buttonStart.setOnClickListener(v -> {
            try{
                Intent intent = new Intent(StartActivity.this, ChooseWorkoutActivity.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(StartActivity.this, getString(R.string.please_try_again_toast), Toast.LENGTH_SHORT).show();
            }
        });
    }
}