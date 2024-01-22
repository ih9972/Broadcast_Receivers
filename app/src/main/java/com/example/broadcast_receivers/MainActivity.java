package com.example.broadcast_receivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView headphone, five_headpohone, boot;
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headphone = (TextView) findViewById(R.id.headpohone_tv);
        five_headpohone = (TextView) findViewById(R.id.five_headpohone_tv);
        boot = (TextView) findViewById(R.id.boot_counter_tv);
        settings=getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        if(settings.getInt("RebootNumber",-1 )== -1) {
            editor.putInt("RebootNumber",0);
        }
        else{
            boot.setText(""+settings.getInt("RebootNumber",-1 ));
        }

    }
}