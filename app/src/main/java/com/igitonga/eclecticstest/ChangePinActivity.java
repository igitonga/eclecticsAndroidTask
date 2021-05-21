package com.igitonga.eclecticstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.igitonga.eclecticstest.database.DBManager;
import com.igitonga.eclecticstest.database.UserModel;

public class ChangePinActivity extends AppCompatActivity {

    Button btnChangePin;
    IndicatorDots indicator_dots;
    PinLockView pin_lock_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);

        btnChangePin = findViewById(R.id.btnChangePin);
        indicator_dots = findViewById(R.id.indicator_dots);
        pin_lock_view = findViewById(R.id.pin_lock_view);

        btnChangePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = null;
                try {
                    userModel = new UserModel(1, "0713394693", "1234");
                    Toast.makeText(ChangePinActivity.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                    pin_lock_view.attachIndicatorDots(indicator_dots);
                    pin_lock_view.setPinLockListener(new PinLockListener() {
                        @Override
                        public void onComplete(String pin) {

                        }

                        @Override
                        public void onEmpty() {

                        }

                        @Override
                        public void onPinChange(int pinLength, String intermediatePin) {

                        }
                    });

                }
                catch (Exception e){
                    Toast.makeText(ChangePinActivity.this, "Error changing pin", Toast.LENGTH_SHORT).show();
                }
                DBManager dbManager = new DBManager(ChangePinActivity.this);
                boolean success = dbManager.addUser(userModel);

                Toast.makeText(ChangePinActivity.this, "Success" + success, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(ChangePinActivity.this, ConfirmChangePinActivity.class));
            }
        });
    }
}
