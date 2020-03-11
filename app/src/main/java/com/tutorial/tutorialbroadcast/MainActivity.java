package com.tutorial.tutorialbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String WHERE_MY_CAT_ACTION = "ru.alexanderklimov.action.CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";
    private MessageReceiver mTimeBroadCastReceiver = new MessageReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonReg = findViewById(R.id.buttonReg);
        Button buttonUnr = findViewById(R.id.buttonUnreg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter(
                        WHERE_MY_CAT_ACTION));

                Intent intent = new Intent();
                intent.setAction(WHERE_MY_CAT_ACTION);
                intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);




                Toast.makeText(getApplicationContext(), "Приёмник включен",
                        Toast.LENGTH_SHORT).show();
            }
        });

        buttonUnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.unregisterReceiver(mTimeBroadCastReceiver);

                Toast.makeText(getApplicationContext(), "Приёмник выключён", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }




}
