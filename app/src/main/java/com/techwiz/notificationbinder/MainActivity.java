package com.techwiz.notificationbinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    static LinearLayout ll;
    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.LL_all);
        if (!NotificationService.isOn) {
            Intent in = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
        }
    }


//    public void notif(String val) {
//        TextView tv = new TextView(this);
//        tv.setText(val);
//        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
//        tv.setGravity(Gravity.CENTER_VERTICAL);
//        tv.setId(i++);
//        ll.addView(tv);
//    }
}
