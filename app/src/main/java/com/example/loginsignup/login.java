package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button btnLogin;
    EditText luser, lpass;
    int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        luser = findViewById(R.id.lusern);
        lpass = findViewById(R.id.lpass);
        btnLogin = findViewById(R.id.button2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = getIntent().getExtras();
                if (b != null) {
                    String suser = b.getString("user");
                    String spass = b.getString("pass");
                    String user1 = luser.getText().toString();
                    String pass1 = lpass.getText().toString();

                    if (suser != null && suser.equals(user1) && spass != null && spass.equals(pass1)) {
                        Intent it = new Intent(getBaseContext(), success.class);
                        startActivity(it);
                    } else {
                        count--;
                        if (count == 0) {
                            btnLogin.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Failed Login Attempts", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), "Login Failed " + count, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}
