package com.example.f1app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.f1app.database.UserDao;
import com.example.f1app.database.UserDatabase;
import com.example.f1app.model.room.User;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername, etEmail, etPhone;
    Button btnSave, btnCancel;

    UserDao userDao;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_PHONE = "phone";

    String sName, sUsername, sEmail, sPassword, sPhone;
    int iId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);

        userDao = UserDatabase.getInstance(this).contactDao();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        iId = sharedPreferences.getInt(KEY_ID,1);
        sName = sharedPreferences.getString(KEY_NAME,null);
        sUsername = sharedPreferences.getString(KEY_USERNAME,null);
        sEmail = sharedPreferences.getString(KEY_EMAIL,null);
        sPassword = sharedPreferences.getString(KEY_PASSWORD,null);
        sPhone = sharedPreferences.getString(KEY_PHONE,null);

        if (sUsername != null || sEmail != null || sPhone != null){
            etUsername.setText(sUsername);
            etEmail.setText(sEmail);
            etPhone.setText(sPhone);
        }

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (btnSave.equals(v)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(KEY_ID, iId);
            editor.putString(KEY_NAME, sName);
            editor.putString(KEY_USERNAME, etUsername.getText().toString());
            editor.putString(KEY_EMAIL, etEmail.getText().toString());
            editor.putString(KEY_PASSWORD, sPassword);
            editor.putString(KEY_PHONE, etPhone.getText().toString());
            editor.apply();

            sPhone = etPhone.getText().toString();

            User user = new User(iId, sName, sUsername, sEmail, sPassword, sPhone);
            userDao.updateData(user);
            finish();
        } else if (btnCancel.equals(v)) {
            finish();
        }
    }
}