package com.example.notificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class NotificationAppChannel extends Application {
    
    public static final String CHANNEL_1_ID = "Channel 1";
    public static final String CHANNEL_2_ID = "Channel 2";

    @Override
    public void onCreate() {
        super.onCreate();
        
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
        channel1.setDescription("This is channel one");
        NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_LOW);
        channel2.setDescription("This is channel Two");

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel1);
        manager.createNotificationChannel(channel2);

    }
}

