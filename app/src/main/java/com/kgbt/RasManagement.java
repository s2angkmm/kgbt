package com.kgbt;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RasManagement extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ras_management);

        ImageView imageView = (ImageView)findViewById(R.id.imagev_Tma);
        imageView.setImageResource(R.drawable.bg);


    }

    Button.OnClickListener mClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i;

            TextView tv = (TextView)findViewById(R.id.information_flg);
            switch (v.getId()){
                case R.id.btn_RasSetConfig:
                    Log.d("DEG", "mClickListener btn_RasSetConfig");

                    break;
                case R.id.btn_RasManage:
                    Log.d("DEG", "mClickListener btn_RasManage");

                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ras_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
