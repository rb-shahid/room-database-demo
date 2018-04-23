package com.byteshaft.roomdatabasedemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class CreateUser extends AppCompatActivity {


    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private Button mButtonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        mFirstName = findViewById(R.id.et_first_name);
        mLastName = findViewById(R.id.et_last_name);
        mEmail = findViewById(R.id.et_email);
        mButtonSave = findViewById(R.id.button_save);

        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        List<User> users = database.userDao().getAllUsers();

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.userDao().insertAll(new User(
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mEmail.getText().toString()));
                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
