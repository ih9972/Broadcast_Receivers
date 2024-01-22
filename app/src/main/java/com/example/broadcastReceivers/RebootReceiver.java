package com.example.broadcastReceivers;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class RebootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = context.getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("RebootNumber",(settings.getInt("RebootNumber",-1 )+1));
    }
}