package com.example.swimproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingInActivity extends AppCompatActivity {

    private Button button;
    private EditText emailAddress;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        button = findViewById(R.id.buttonGoToRegister);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);

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

            if (emailAddress.getText() != null && password.getText() != null){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailAddress.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent = new Intent(SingInActivity.this, ChooseLevelActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            } else{
                Toast.makeText(this, getString(R.string.not_empty), Toast.LENGTH_SHORT).show();
            }
        });
    }
}