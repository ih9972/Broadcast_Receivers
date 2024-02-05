package com.example.broadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.broadcast_receivers.MainActivity;

public class FiveTimes extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.CUSTOM_ACTION)) {
            MainActivity.five_headpohone.setText("Five Earphones Plugs "+MainActivity.headphones_connect/5/2);
        }
    }
}