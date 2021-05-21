package com.igitonga.eclecticstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.igitonga.eclecticstest.githubrepo.GithubReposActivity;

public class ConfirmChangePinActivity extends AppCompatActivity {

    Button btnConfirmChangePin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_change_pin);

        btnConfirmChangePin = findViewById(R.id.btnConfirmChangePin);

        btnConfirmChangePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmChangePinActivity.this, GithubReposActivity.class));
            }
        });
    }
}
