package com.example.swimproject.bottomnav.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.swimproject.R;

import org.checkerframework.checker.index.qual.LTEqLengthOf;

public class TechniqueActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technique);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.stroke));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);

        imageView = findViewById(R.id.imageViewTmp);
        textView = findViewById(R.id.textViewTmp);

        onItemSelected(spinner, null, 0, 0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] items = getResources().getStringArray(R.array.stroke);

        switch (position) {
            case 0:
                imageView.setImageResource(R.drawable.free);
                textView.setText(R.string.technique_free);
                break;
            case 1:
                imageView.setImageResource(R.drawable.back);
                textView.setText(R.string.technique_back);
                break;
            case 2:
                imageView.setImageResource(R.drawable.breast);
                textView.setText(R.string.technique_breast);
                break;
            case 3:
                imageView.setImageResource(R.drawable.bat);
                textView.setText(R.string.technique_bat);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    public void returnBackActivityOther(View view) {
        Intent intent = new Intent(this, InfoFragment.class);
        startActivity(intent);
    }
}