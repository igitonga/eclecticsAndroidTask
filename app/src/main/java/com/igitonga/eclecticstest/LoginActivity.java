package com.igitonga.eclecticstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockView;

public class LoginActivity extends AppCompatActivity {

    IndicatorDots indicator_dots;
    PinLockView pin_lock_view;
    Button btnOTPLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnOTPLogin = findViewById(R.id.btnOTPLogin);

        btnOTPLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ChangePinActivity.class));
            }
        });
    }
}
