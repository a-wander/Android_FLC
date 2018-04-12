package com.zhangyong.activitylifecycletest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String temp = savedInstanceState.getString("key");
            Log.d(TAG, "onCreate: "+temp);
        }

        Button btn = (Button)findViewById(R.id.start_normal_activity);
        btn.setOnClickListener(MainActivity.this);
//        btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
//                startActivity(intent);
//            }
//        });

        Button btn1 = (Button)findViewById(R.id.start_dialog_activity);
        btn1.setOnClickListener(MainActivity.this);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.start_normal_activity) {
            Intent intent = new Intent(MainActivity.this, NormalActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.start_dialog_activity) {
            Intent intent = new Intent(MainActivity.this, DialogActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "value");
    }
}
