package com.pablo.u2p4conversor;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class LogActivity extends Activity {
    private final String ACTIVIDAD_NAME = this.getClass().getSimpleName();
    private final String DEBUG_TAG = "LOG-" + ACTIVIDAD_NAME;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(DEBUG_TAG,"onCreate");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(DEBUG_TAG,"onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(DEBUG_TAG,"onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(DEBUG_TAG,"onResume");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(DEBUG_TAG,"onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(DEBUG_TAG,"onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(DEBUG_TAG,"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(DEBUG_TAG,"onDestroy");
        Log.i(DEBUG_TAG,"isFininshing-> "+ isFinishing());

    }

    protected void imprimirLog(String elemento, String accion ){
        Log.i(DEBUG_TAG,elemento+ "=>" + accion );
    }



}

