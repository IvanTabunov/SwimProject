package com.example.swimproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ActivitySignOn extends AppCompatActivity {
    private TextView textViewCommentClick;
    private Button button;
    private EditText emailAddress;
    private EditText password;
    private EditText name;
    private EditText passwordAgain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_on);
        textViewCommentClick = findViewById(R.id.textViewCommentClick);
        button = findViewById(R.id.buttonRegister);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        name = findViewById(R.id.editTextTextName);
        passwordAgain = findViewById(R.id.editTextTextPasswordAgain);

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
            if (emailAddress.getText() != null && password.getText() != null && passwordAgain.getText() != null && name.getText() != null && IsPasswordCorrect()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailAddress.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    HashMap<String, String> userInfo = new HashMap<>();
                                    userInfo.put("email", emailAddress.toString());
                                    userInfo.put("username", name.toString());
                                    FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(userInfo);
                                    startActivity(new Intent(ActivitySignOn.this, ChooseLevelActivity.class));
                                }
                            }
                        });
            } else{
                Toast.makeText(this, R.string.wrong_data_input, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean IsPasswordCorrect(){
        return passwordAgain.getText().toString().equals(password.getText().toString());
    }
}