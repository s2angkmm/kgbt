package com.kgbt;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
        Log.d("DEG","Test~run");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("DEG", "서비스 onStartCommand");
        return START_STICKY;
//      return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "서비스 onDestro",Toast.LENGTH_SHORT).show();
        Log.d("DEG", "서비스 onDestro");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
