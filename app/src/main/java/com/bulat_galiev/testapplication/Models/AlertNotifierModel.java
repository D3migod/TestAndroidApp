package com.bulat_galiev.testapplication.Models;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;

/**
 * Created by BulatGaliev on 09.09.16.
 * The class is used to notify the user about all exceptions
 */
public class AlertNotifierModel {
    private final static String notifyMessage = "Error";

    public static void alertNotify(final Activity activity, Exception e) {
        Log.e("testapplication", "exception", e);
        final AlertDialog.Builder alertNotifier = new AlertDialog.Builder(activity);
        alertNotifier.setTitle(notifyMessage);
        alertNotifier.setMessage(e.toString());
        alertNotifier.setNeutralButton("OK", null);
        alertNotifier.setCancelable(false);
        activity.runOnUiThread(new Runnable() {
            public void run() {
                alertNotifier.show();
            }
        });

    }
}
