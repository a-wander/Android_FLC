package com.zhangyong.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent = getIntent();
        String strValue = intent.getStringExtra("key");
        Log.d(TAG, "onCreate: "+strValue);

        intent.putExtra("key1", "value1");
        setResult(RESULT_OK, intent);
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(SecondActivity.this, "不允许返回！", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
        startActivity(intent);
    }
}
