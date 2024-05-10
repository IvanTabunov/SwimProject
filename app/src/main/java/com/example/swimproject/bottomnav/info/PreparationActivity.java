package com.example.swimproject.bottomnav.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.swimproject.R;

public class PreparationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);
    }

    public void returnBackActivity(View view) {
        Intent intent = new Intent(this, InfoFragment.class);
        startActivity(intent);
    }
}