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
import android.widget.TextView;

public class MultiRetInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_ret_information);

        Button btn_add = (Button)findViewById(R.id.btn_MultiAddinfo);
        btn_add.setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i;

            TextView tv = (TextView)findViewById(R.id.tv_title_MultiInfomation);
            switch (v.getId()){
                case R.id.btn_MultiAddinfo:
                    Log.d("DEG", "mClickListener__menu1" + tv.getText());
                    i = new Intent(MultiRetInformation.this, MultiRetAdditional.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
                case R.id.btn_MultiInforationManage:
                    Log.d("DEG", "mClickListener__menu2");
                    i = new Intent(MultiRetInformation.this, Management.class);
                    startActivity(i);
                    finish();
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_ret_information, menu);
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
