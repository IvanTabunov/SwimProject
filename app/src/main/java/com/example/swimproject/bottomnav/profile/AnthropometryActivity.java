package com.example.swimproject.bottomnav.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.swimproject.R;

public class AnthropometryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anthropometry);
    }

    public void returnBackActivityToProfile(View view) {
        Intent intent = new Intent(this, ProfileFragment.class);
        startActivity(intent);
    }
}