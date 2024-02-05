package com.example.broadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.broadcast_receivers.MainActivity;

public class EarphonesReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity.headphones_connect ++;
        if(MainActivity.headphones_connect%2 == 0)
            MainActivity.headphone.setText("Earphones Plugs "+MainActivity.headphones_connect/2);
            if(MainActivity.headphones_connect/2%5 == 0){
                Intent intent1 = new Intent(MainActivity.CUSTOM_ACTION);
                context.sendBroadcast(intent1);
            }
    }
}