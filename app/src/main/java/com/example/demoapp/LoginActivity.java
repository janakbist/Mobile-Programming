package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    String email_str,password_str;
    public static final String EMAIL = "int-email";
    public static final String PASSWORD = "int-password";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout_example);

        Intent intent = getIntent();
        if(intent.hasExtra(Signup.EMAIL)) {
            email_str = intent.getStringExtra(Signup.EMAIL);

        }
        if (intent.hasExtra(Signup.PASSWORD)) {
            password_str = intent.getStringExtra(Signup.PASSWORD);
        }
        EditText editUserName = findViewById(R.id.edit_username);
        EditText editPassword = findViewById(R.id.edit_password);
        Button loginBtn = findViewById(R.id.loginbtn);
        TextView register = (TextView) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ri = new Intent(getApplicationContext(),Signup.class);
                startActivity(ri);
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String validateEmail ="/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/" ;
                if(editUserName.getText().toString().isEmpty()) {
                    editUserName.setError("please fill this filed");

            }else if(editPassword.getText().toString().isEmpty()){
                editUserName.setError("please fill this filed");

            }else if(!(Patterns.EMAIL_ADDRESS.matcher(editUserName.getText().toString()).matches())){
                editUserName.setError("Invalid Email Address");

            }else if (editUserName.getText().toString().equals(email_str) && editPassword.getText().toString().equals(password_str)) {

                    Intent inte = new Intent(LoginActivity.this, HomeActivity.class);
                    inte.putExtra(EMAIL,editUserName.getText().toString());
                    inte.putExtra(PASSWORD,editPassword.getText().toString());
                    startActivity(inte);
                    finish();

                }
            else {
                    Toast.makeText(LoginActivity.this, "Something Went Wrong!" ,Toast.LENGTH_SHORT).show();

                  }
            }
        });

    }
}
