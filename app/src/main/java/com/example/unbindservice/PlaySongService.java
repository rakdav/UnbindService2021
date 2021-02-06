package com.example.unbindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlaySongService extends Service {
    private MediaPlayer mediaPlayer;
    public PlaySongService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.piskun);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}