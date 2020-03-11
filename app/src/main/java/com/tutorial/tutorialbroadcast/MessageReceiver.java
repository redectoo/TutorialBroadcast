package com.tutorial.tutorialbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("ru.alexanderklimov.broadcast.Message"),
                Toast.LENGTH_LONG).show();




    }
}
