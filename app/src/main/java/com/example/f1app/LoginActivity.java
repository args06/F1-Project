package com.example.f1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.f1app.database.UserDao;
import com.example.f1app.database.UserDatabase;
import com.example.f1app.model.room.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_PHONE = "phone";

    UserDao userDao;

    EditText etUsername, etPassword;
    Button btnLogin, btnRegister;

    String dbName = "firstInitial", dbUsername = "firstInitial", dbEmail = "firstInitial", dbPassword = "firstInitial", dbPhone = "firstInitial";
    int dbId = 0;
    String sUsername = "", sPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_signin);
        btnRegister = findViewById(R.id.btn_register);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String sUsername = sharedPreferences.getString(KEY_USERNAME, null);

        if (sUsername != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        userDao = UserDatabase.getInstance(this).contactDao();

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btnLogin.equals(v)) {
            if (TextUtils.isEmpty(etUsername.getText())){
                etUsername.setError( "Username is required!" );
            }

            if (TextUtils.isEmpty(etPassword.getText())){
                etPassword.setError( "Password is required!" );
            }

            if(!TextUtils.isEmpty(etUsername.getText()) && !TextUtils.isEmpty(etPassword.getText())){
                checkUser();

                if ((dbUsername.equals(sUsername) && dbPassword.equals(sPassword)) || (dbEmail.equals(sUsername) && dbPassword.equals(sPassword))){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(KEY_ID,dbId);
                    editor.putString(KEY_NAME,dbName);
                    editor.putString(KEY_USERNAME,dbUsername);
                    editor.putString(KEY_EMAIL,dbEmail);
                    editor.putString(KEY_PASSWORD,dbPassword);
                    editor.putString(KEY_PHONE,dbPhone);
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if(!(dbUsername.equals(sUsername) || dbEmail.equals(sUsername))){
                    etUsername.setError( "Username or E-mail is wrong!" );
                } else if(!dbPassword.equals(sPassword)){
                    etPassword.setError( "Password is wrong!" );
                }
            }

        } else if (btnRegister.equals(v)) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        }
    }

    private void checkUser(){
        dbId = 0;
        dbName = "";
        dbUsername = "";
        dbEmail = "";
        dbPassword = "";
        dbPhone = "";

        sUsername = etUsername.getText().toString();
        sPassword = etPassword.getText().toString();

        List<User> datas = userDao.getAllData();
        for (User data : datas ){
            System.out.println("Output");
            if((data.getUsername().equals(sUsername) || data.getEmail().equals(sUsername) ) || dbPassword.equals(sPassword)){
                System.out.println("Masuk");
                dbId = data.getId();
                System.out.println(dbId);
                dbName = data.getName();
                dbUsername = data.getUsername();
                dbEmail = data.getEmail();
                dbPassword = data.getPassword();
                dbPhone = data.getPhoneNumber();
                break;
            }
        }
    }
}