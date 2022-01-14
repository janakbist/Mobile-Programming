package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btnClick (View view) {
        TextView txtHello = findViewById(R.id.txtMessage);
        EditText getTxtName = findViewById(R.id.editTxtName);
        txtHello.setText(getTxtName.getText().toString());

        TextView lN = findViewById(R.id.txtMessageLN);
        EditText getTxtLn = findViewById(R.id.editTxtLastName);
        lN.setText(getTxtLn.getText().toString());

        TextView txtEmail = findViewById(R.id.txtMessageEmail);
        EditText getTxtEmail = findViewById(R.id.editTxtEmail);
        txtEmail.setText(getTxtEmail.getText().toString());
        //TODO: SIMPLE LOGIN FORM


    }
}