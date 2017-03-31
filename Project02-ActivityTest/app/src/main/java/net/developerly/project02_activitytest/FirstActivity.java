package net.developerly.project02_activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        // 根据ID拿到按钮
        Button button1 = (Button) findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked Button1", Toast.LENGTH_LONG).show();
                // 销毁当前活动
//                finish();
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class); // 显式Intent
//                Intent intent = new Intent("net.developerly.activitytest.ACTION_START"); // 隐式Intent
//                intent.addCategory("net.developerly.activitytest.MY_CATEGORY");

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));

//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));

//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class); // 显式Intent
//                intent.putExtra("extra_data", data);
//                startActivity(intent);

                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
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

        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You Clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

}
