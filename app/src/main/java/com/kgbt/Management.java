package com.kgbt;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.logging.LogRecord;

public class Management extends Activity {

    private int    uiOption = 0;
    private ImageView iv;
    private TextView tv;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg){
            Log.d("DEG","Data :::"+msg.arg1);
            iv.setRotation(msg.arg1);
            tv.setText(msg.arg1+"");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_management);
        toggleHideyBar();

        iv = (ImageView)findViewById(R.id.iv_manage_rote);
        tv = (TextView)findViewById(R.id.tv_manage_rote);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    if(i > 360){
                        break;
                    }else{
                        Message msg = mHandler.obtainMessage();
                        msg.arg1 = i;
                        mHandler.sendMessage(msg);

                        try {
                            Thread.sleep(1000);
                            i+=10;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();

    }

    class testThread extends Thread{

        private int i=0;
        private  boolean isPlay = false;

        public testThread(boolean _isPlay){
            this.isPlay = _isPlay;
        }

        @Override
        public void run(){
            super.run();
            while (isPlay){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_management, menu);
        return true;
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        // super.onWindowFocusChanged(hasFocus);
        if( hasFocus ) {
            toggleHideyBar();
        }
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
