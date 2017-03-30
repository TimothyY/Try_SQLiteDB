package com.example.user.try_sqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btnRegister:
                UserDAO userDAO1 = new UserDAO();
                userDAO1.addUser(
                        this,
                        etUsername.getText().toString(),
                        etPassword.getText().toString());
                break;
            case R.id.btnLogin:
                UserDAO userDAO2 = new UserDAO();
                String result = userDAO2.getUsername(
                        this,
                        etUsername.getText().toString(),
                        etPassword.getText().toString());
                if(result==null){
                    Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
                    ArrayList<String> results = userDAO2.getUsernames(this);
                    for (int i=0;i<results.size();i++){
                        Toast.makeText(this, "Registered user: "+results.get(i), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Login sukses, halo "+result, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
