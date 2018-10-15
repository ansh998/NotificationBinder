package com.techwiz.notificationbinder;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import static com.techwiz.notificationbinder.MainActivity.i;
import static com.techwiz.notificationbinder.MainActivity.ll;


@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressLint("OverrideAbstract")
public class NotificationService extends NotificationListenerService {

    public static boolean isOn = false;


    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        try {
            Notification a = sbn.getNotification();
            String r = a.tickerText.toString();
            TextView tv = new TextView(this);
            tv.setText(r);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setId(i++);
            ll.addView(tv);

        } catch (Exception e) {
        }
    }

    @Override
    public void onListenerDisconnected() {
        isOn = false;
    }

    @Override
    public void onListenerConnected() {
        isOn = true;
    }

}
