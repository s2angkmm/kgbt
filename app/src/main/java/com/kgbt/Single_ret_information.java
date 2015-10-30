package com.kgbt;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Single_ret_information extends Activity {

    private int    uiOption = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_single_ret_information);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView textView = (TextView)findViewById(R.id.tv_title_MultiInfomation);
        String sttemp = textView.getText().toString();
        textView.setText(name+" "+sttemp);

        Log.d("DGE", "..........."+name);

        TextView tv = (TextView)findViewById(R.id.information_flg);
        tv.setText(name);
        EditText et = (EditText) findViewById(R.id.editText_Maker);
        et.setFocusable(false);
        EditText et_ser = (EditText) findViewById(R.id.editText_SerialNo);
        et_ser.setFocusable(false);
        EditText et_Model = (EditText) findViewById(R.id.editText_Model);
        et_Model.setFocusable(false);
        EditText et_HW = (EditText) findViewById(R.id.editText_HW_ver);
        et_HW.setFocusable(false);
        EditText et_FW = (EditText) findViewById(R.id.editText_FW_ver);
        et_FW.setFocusable(false);
        EditText et_Protocol = (EditText) findViewById(R.id.editText_Protocol);
        et_Protocol.setFocusable(false);
        EditText et_Comaddr = (EditText) findViewById(R.id.editText_ComAddr);
        et_Comaddr.setFocusable(false);
        EditText et_ComState = (EditText) findViewById(R.id.editText_ComState);
        et_ComState.setFocusable(false);
        Button btn_AddInfo = (Button)findViewById(R.id.btn_addinfo);
        btn_AddInfo.setOnClickListener(mClickListener);
        Button btn_manage = (Button)findViewById(R.id.btn_manage);
        btn_manage.setOnClickListener(mClickListener);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                toggleHideyBar();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    Button.OnClickListener mClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i;
            TextView tv = (TextView)findViewById(R.id.information_flg);
            switch (v.getId()){
                case R.id.btn_addinfo:
                    Log.d("DEG", "mClickListener__menu1"+tv.getText());
                    if(tv.getText().equals("SRET")){
                        Log.d("DEG",tv.getText().toString()+" sret");
                        i = new Intent(Single_ret_information.this, addinformation.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else if(tv.getText().equals("MRET")){
                        Log.d("DEG",tv.getText().toString()+" mret");
                        i = new Intent(Single_ret_information.this, MultiRetAdditional.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else if(tv.getText().equals("TMA")){
                        Log.d("DEG",tv.getText().toString()+" tma");
                        i = new Intent(Single_ret_information.this, TmaAdditional.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }else{

                        Log.d("DEG",tv.getText().toString() +" ..");
                        i = new Intent(Single_ret_information.this, RasAdditional.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                    finish();
                    break;
                case R.id.btn_manage:
                    Log.d("DEG", "mClickListener__menu2");

                    if(tv.getText().equals("RAS")){
                        Log.d("DEG",tv.getText().toString()+" sret");
                        i = new Intent(Single_ret_information.this, RasManagement.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else{
                        i = new Intent(Single_ret_information.this, Management.class);
                        startActivity(i);
                        finish();
                    }
                    break;
            }
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        // super.onWindowFocusChanged(hasFocus);
        if( hasFocus ) {
            toggleHideyBar();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_ret_information, menu);
        return true;
    }
    public void toggleHideyBar() {
        int uiOptions = this.getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOption = uiOptions;
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        // Navigation bar hiding:  Backwards compatible to ICS.
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        // Status bar hiding: Backwards compatible to Jellybean
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        this.getWindow().getDecorView().setSystemUiVisibility(newUiOptions);

        //END_INCLUDE (set_ui_flags)
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
