package com.bulat_galiev.testapplication.Models;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;

import static com.bulat_galiev.testapplication.Models.AlertNotifierModel.alertNotify;

/**
 * Created by BulatGaliev on 09.09.16.
 * The class is used to asynchronously load html via htmlModel
 */
public class LoaderAsyncTaskModel extends AsyncTask<String, Void, String> {
    TextView textView;
    //    Calling activity is used in AlertNotifierModel
    Activity activity;

    public LoaderAsyncTaskModel(Activity activity, TextView imageView) {
        this.textView = imageView;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
//            params contains url
            if (params != null && params.length != 0) {
                HtmlLoaderModel htmlLoaderModel = new HtmlLoaderModel();
                return htmlLoaderModel.loadHtml(params[0]);
            }
        } catch (IOException e) {
            alertNotify(activity, e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String resultText) {
//        Set loaded html to the TextView
        textView.setText(resultText);
    }
}
