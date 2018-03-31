package com.zhangyong.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button btn1 = (Button)findViewById(R.id.button_1);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "你真听话！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button)findViewById(R.id.button_3);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.zhangyong.activitytest.ACTION_START");
                // 只能有一个action，但是可以有多个category,当为匹配到时会崩溃
                intent.addCategory("com.zhangyong.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button btn3 = (Button) findViewById(R.id.button_4);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "不要乱点", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "就知道你会乱点，没了吧！", Toast.LENGTH_SHORT).show();
                finish();// 结束当前activity
                break;
            default:
        }
        return true;
    }
}
