package com.example.f1app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.f1app.database.UserDao;
import com.example.f1app.database.UserDatabase;
import com.example.f1app.model.room.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    UserDao userDao;

    EditText etName, etUsername, etEmail, etPassword, etPhone;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userDao = UserDatabase.getInstance(this).contactDao();

        etName = findViewById(R.id.et_name);
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etPhone = findViewById(R.id.et_phone_number);
        btnSignUp = findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btnSignUp.equals(v)) {
            String sName = etName.getText().toString();
            String sUsername = etUsername.getText().toString();
            String sEmail = etEmail.getText().toString();
            String sPassword = etPassword.getText().toString();
            String sPhone = etPhone.getText().toString();

            User user = new User(sName, sUsername, sEmail, sPassword, sPhone);
            userDao.insertData(user);
            finish();
        }
    }
}