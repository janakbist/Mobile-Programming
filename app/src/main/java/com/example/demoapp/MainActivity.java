package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import com.example.demoapp.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


///        EditText editPassword = findViewById(R.id.edit_password);
//        EditText editConfirmPassword = findViewById(R.id.edit_confirm_password);
//        Button loginBtn = findViewById(R.id.loginbtn);
//        Log.e("TAG: ", editUserName.getText().toString());
//        editUserName.setText("This is Email");
//        signup.setOnClickListener((View.OnClickListener) this);

    }
//    @Override
//    public  void onClick(View view) {
//        switch (view.getId() {
//
//        })
//
//    }
}