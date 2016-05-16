package com.senapathi.basicservicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Senapathi on 13-05-2016.
 */
public class MyService extends Service implements Runnable{
    Thread thread;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread( this ).start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //
            Intent intent = new Intent( MainActivity.INTENT_ID);
            intent.putExtra( "count",i );
            sendBroadcast( intent );


        }
//        stopSelf();
}
}
