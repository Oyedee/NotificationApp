package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notificationapp.NotificationAppChannel.CHANNEL_1_ID;
import static com.example.notificationapp.NotificationAppChannel.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    EditText title, description;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.edit_title);
        description = findViewById(R.id.edit_description);
        notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
    }

    public void sendOnChannelOne(View view) {
        String title_text = title.getText().toString();
        String description_text = description.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_filter_1_24)
                .setContentTitle(title_text)
                .setContentText(description_text)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManagerCompat.notify(1, notification);

    }

    public void sendOnChannelTwo(View view) {
        String title_text = title.getText().toString();
        String description_text = description.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_filter_2_24)
                .setContentTitle(title_text)
                .setContentText(description_text)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManagerCompat.notify(2, notification);
    }
}