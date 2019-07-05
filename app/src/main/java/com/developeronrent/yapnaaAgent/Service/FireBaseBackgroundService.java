package com.developeronrent.yapnaaAgent.Service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.developeronrent.yapnaaAgent.Activity.DialUp;

import static com.developeronrent.yapnaaAgent.Service.MyFirebaseMessagingClass.numberdial;
public class FireBaseBackgroundService extends WakefulBroadcastReceiver {

    private static final String TAG = "FirebaseService";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "I'm in!!!");

        if (intent.getExtras() != null) {
            for (String key : intent.getExtras().keySet()) {
                if (key.equals("type") && intent.getExtras().get(key).equals("silent_call"))
                {
                    Object value = intent.getExtras().get(key);
                Log.e("FirebaseDataReceiver", "Key: " + key + " Value: " + value);
                    for (String keys : intent.getExtras().keySet())
                if (keys.equals("number")) {
                    numberdial = String.valueOf(intent.getExtras().get(keys));
                    if (numberdial != null) {
                        Intent backgroundIntent = new Intent(context, DialUp.class);
                        backgroundIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, backgroundIntent,
                                PendingIntent.FLAG_ONE_SHOT);
                        try {
                            pendingIntent.send();
                        } catch (PendingIntent.CanceledException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
            }
        }

    }
}
