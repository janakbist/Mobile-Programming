package com.example.demoapp;
import static android.provider.Telephony.Carriers.PASSWORD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    public static final String EMAIL = "int-email";
    public static final String PASSWORD = "int-password";

    //create object of database reference class to access the firebase database
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);
        EditText editUsername = (EditText) findViewById(R.id.edit_username);
        EditText editPassword = (EditText) findViewById(R.id.edit_password);
        EditText editCPassword =(EditText) findViewById(R.id.edit_confirm_password);
        Button register = findViewById(R.id.signup);
        TextView backtologin = (TextView) findViewById(R.id.backtologin) ;
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.radio_group) ;
        RadioButton male = (RadioButton) findViewById(R.id.male) ;
        RadioButton female = (RadioButton) findViewById(R.id.female) ;
        Spinner spStates = (Spinner) findViewById(R.id.sp_states);
        String[] states ={"state1","state2","state3"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,states);
        spStates.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(inte);
                finish();
            }
        });
male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.e("Tag","male checked");
    }
});
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("Tag","female checked");
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //male.isChecked();
                //rgGender.getCheckedRadioButtonId();
                switch (rgGender.getCheckedRadioButtonId()) {
                    case R.id.male:
                        Log.e("TAG","male selected");
                        break;
                    case R.id.female:
                        Log.e("TAG","Female selected");
                        break;
                    case R.id.others:
                        Log.e("TAG","Others selected");
                        break;
                    default:
                        Log.e("TAG","Nothing selected");
                        break;
                }
                if(editUsername.getText().toString().isEmpty()) {
                    editUsername.setError("Fill the Username");
                }
//                if (!editUsername.getText().toString().matches(String.valueOf(Patterns.EMAIL_ADDRESS))) {
//                    Toast.makeText(Signup.this,"Invalid  Email Format",Toast.LENGTH_LONG).show();
//
//                }
                else if(editPassword.getText().toString().isEmpty()){
                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();

                }else if (editPassword.getText().toString().length()<6){
                    Toast.makeText(Signup.this, "Password Length Must be Greater than 6", Toast.LENGTH_SHORT).show();

                }
                else if (editPassword.getText().toString().isEmpty()) {
                    editPassword.setError("Enter your password");
                }else if (editCPassword.getText().toString().isEmpty()) {
                    editCPassword.setError("password does not match");}
//                }else if (editPassword.getText().toString() != editCPassword.getText().toString()) {
//                    editCPassword.setError("password doenot match");
//                    editCPassword.setError("password does not match");
//                }
                else {
                    Intent inte = new Intent(Signup.this,LoginActivity.class);
                    inte.putExtra(EMAIL,editUsername.getText().toString());
                    inte.putExtra(PASSWORD,editPassword.getText().toString());
                    startActivity(inte);

                }
            }
        });

    }
}