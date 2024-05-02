package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySignOn extends AppCompatActivity {

    TextView textViewCommentClick;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_on);
        textViewCommentClick = findViewById(R.id.textViewCommentClick);
        button = findViewById(R.id.buttonRegister);

        startChooseLevelScreen(button);
        startSingInBack(textViewCommentClick);
    }

    public void startSingInBack(View view) {
        textViewCommentClick.setOnClickListener(v -> {
            try{
                Intent intent = new Intent(this, SingInActivity.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, getString(R.string.please_try_again_toast), Toast.LENGTH_SHORT).show();
            }
        });
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