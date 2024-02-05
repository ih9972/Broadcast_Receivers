package com.example.broadcast_receivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcastReceivers.EarphonesReceiver;
import com.example.broadcastReceivers.FiveTimes;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_ACTION = "com.example.broadcast_receivers.receivers.FiveTimes";
    public static TextView headphone, five_headpohone, boot;
    SharedPreferences settings;
    public static int headphones_connect;
    private EarphonesReceiver earphonesReceiver;
    private FiveTimes fiveTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headphones_connect = 0;
        headphone = (TextView) findViewById(R.id.headpohone_tv);
        five_headpohone = (TextView) findViewById(R.id.five_headpohone_tv);
        boot = (TextView) findViewById(R.id.boot_counter_tv);
        settings=getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        if(settings.getInt("RebootNumber",-1 ) == -1) {
            editor.putInt("RebootNumber",0);
        }
        else{
            boot.setText("Reboots "+settings.getInt("RebootNumber",-1 ));
        }
        fiveTimes = new FiveTimes();
        earphonesReceiver = new EarphonesReceiver();
    }


    protected void onResume() {
        super.onResume();
        IntentFilter earphonesFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(earphonesReceiver,earphonesFilter);
        IntentFilter fiveTimesFilter = new IntentFilter(CUSTOM_ACTION);
        registerReceiver(fiveTimes,fiveTimesFilter);
    }

    public static void inc_five_headphones_connect(){
        headphones_connect ++;
        headphone.setText(""+headphones_connect);
    }
    protected void onPause() {
        super.onPause();
        unregisterReceiver(earphonesReceiver);
    }

}