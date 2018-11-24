package com.superhero.superhero.notifications.firebase;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SuperHeroMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), remoteMessage.getNotification().getTitle() + remoteMessage.getNotification().getBody(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
