package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button btnSignUp;
    String reg = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@!#$%&*])[A-Za-z\\d@!#$%&*]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usern);
        password = findViewById(R.id.pass);
        btnSignUp = findViewById(R.id.button1);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usern = username.getText().toString();
        String pass = password.getText().toString();
        if (validatePassword(pass)) {
            Toast.makeText(getBaseContext(), "Valid Password", Toast.LENGTH_SHORT).show();
            Bundle b = new Bundle();
            b.putString("user", usern);
            b.putString("pass", pass);
            Intent it = new Intent(this, login.class);
            it.putExtras(b);
            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePassword(String spassword) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(spassword);
        return matcher.matches();
    }
}
