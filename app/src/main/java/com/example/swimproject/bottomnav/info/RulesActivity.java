package com.example.swimproject.bottomnav.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.swimproject.R;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    public void returnBackActivity(View view) {
        Intent intent = new Intent(this, InfoFragment.class);
        startActivity(intent);
    }
}