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

import com.example.appdroid.MainActivity;
import com.example.appdroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView openReg,openForgetPassword;
    private EditText logEmail,logPass;
    private Button loginBtn;

    private String email,password;
    private FirebaseAuth auth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pd= new ProgressDialog(this);

        openReg= findViewById(R.id.openRegister);
        logEmail= findViewById(R.id.loginEmail);
        logPass= findViewById(R.id.loginPass);
        loginBtn= findViewById(R.id.loginBtn);
        openForgetPassword= findViewById(R.id.openforgetPassword);
        auth = FirebaseAuth.getInstance();

        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        openForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
            }
        });
    }

    private void validateData() {
        email=logEmail.getText().toString();
        password= logPass.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }else{
            pd.setMessage("Please wait...");
            pd.show();
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            pd.dismiss();
                            openMain();
                        }else{
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(LoginActivity.this, "Error :" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }

    private void openMain() {
        pd.dismiss();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void openRegister() {
        pd.dismiss(); //confusion
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }
}