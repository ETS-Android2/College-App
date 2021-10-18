package com.example.appdroid.authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appdroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    private TextView login;
    private EditText txtEmail;
    private Button forgetBtn;
    private String email;
    private FirebaseAuth auth;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        pd= new ProgressDialog(this);

        auth= FirebaseAuth.getInstance();
        txtEmail=findViewById(R.id.forgetEmail);
        forgetBtn=findViewById(R.id.forgetBtn);

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        login = findViewById(R.id.backToLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();

            }
        });
    }

    private void validateData() {
        email= txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("Required");
        }else{
            pd.setMessage("Please wait...");
            pd.show();
            forgetPass();
        }
    }

    private void forgetPass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            pd.dismiss();
                            Toast.makeText(ForgetPasswordActivity.this, "Check your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                            finish();
                        }else{
                            pd.dismiss();
                            Toast.makeText(ForgetPasswordActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void openlogin() {
        startActivity(new Intent(ForgetPasswordActivity.this, LoginActivity.class));
        finish();
    }
}