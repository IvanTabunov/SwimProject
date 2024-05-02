package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SingInActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        button = findViewById(R.id.buttonGoToRegister);

        startChooseLevelScreen(button);
    }

    public void startSignOn(View view) {
        Intent intent = new Intent(this, ActivitySignOn.class);
        startActivity(intent);
    }

    public void changeLanguage(View view) {

    }

    public void startChooseLevelScreen(View view) {
        button.setOnClickListener(v -> {
            try{
                Intent intent = new Intent(this, ChooseLevelActivity.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, getString(R.string.please_try_again_toast), Toast.LENGTH_SHORT).show();
            }
        });
    }
}