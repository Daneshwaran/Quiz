package com.quiz.daneshwaran.quiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login2Activity extends AppCompatActivity {


    private EditText emailId ;
    private EditText password;
    private Button login;
    private Button loginReg;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAuth = FirebaseAuth.getInstance();
        emailId = (EditText) findViewById(R.id.userNameTxt);
        password = (EditText) findViewById(R.id.passwordTxt);
        login = (Button) findViewById(R.id.loginBtn);
        loginReg = (Button)findViewById(R.id.loginRegBtn);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String loginemail = emailId.getText().toString();

                    String loginPassword = password.getText().toString();

//                    Toast.makeText(Login2Activity.this,"working",Toast.LENGTH_LONG).show();
//
                    if(!(TextUtils.isEmpty(loginemail)&&TextUtils.isEmpty(loginPassword)) ){

                        mAuth.signInWithEmailAndPassword(loginemail, loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    sendToMain();
                                    Toast.makeText(Login2Activity.this, "User Exist", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(Login2Activity.this, "something", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }
                    else{
                        Toast.makeText(Login2Activity.this, "empty", Toast.LENGTH_LONG).show();
                    }

                }
            });

    }

    private void sendToMain() {
        Intent intent = new Intent(Login2Activity.this ,MainActivity.class );
        startActivity(intent);
        finish();


    }
}
