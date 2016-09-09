package com.bulat_galiev.testapplication.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bulat_galiev.testapplication.Models.LoaderAsyncTaskModel;
import com.bulat_galiev.testapplication.R;

/**
 * Created by BulatGaliev on 09.09.16.
 * MainActivity class consists of the views, which are used to enter url and show html text
 * obtained by it
 **/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button browserButton = (Button) findViewById(R.id.browser_button);
        if (browserButton != null) {
            browserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    TextView that shows html content
                    TextView showTextView = (TextView) findViewById(R.id.browser_show_text);
//                    Make showTextView scroll vertically
                    if (showTextView != null) {
                        showTextView.setMovementMethod(new ScrollingMovementMethod());
                    }
                    LoaderAsyncTaskModel loaderAsyncTaskModel = new LoaderAsyncTaskModel(MainActivity.this, showTextView);
//                    EditText that holds url
                    EditText browserEditText = (EditText) findViewById(R.id.browser_edit_text);
//                    Packing url to send it to AsyncTask
                    String[] urlStringParam = {browserEditText.getText().toString()};
                    loaderAsyncTaskModel.execute(urlStringParam);
                }
            });
        }
    }


}
