package com.example.demoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String email_str, password_str;
        Intent intent = getIntent();
        if (intent.hasExtra(Signup.EMAIL)) {
            email_str = intent.getStringExtra(Signup.EMAIL);
            EditText email = (EditText) findViewById(R.id.edit_email);
            email.setText(email_str);

        }
        if (intent.hasExtra(Signup.PASSWORD)) {
            password_str = intent.getStringExtra(Signup.PASSWORD);
            EditText password = (EditText) findViewById(R.id.edit_password);
            password.setText(password_str);
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100:
                    if (data.hasExtra("Email")) {
                        data.getStringExtra("Email");
                    }
                    break;
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
