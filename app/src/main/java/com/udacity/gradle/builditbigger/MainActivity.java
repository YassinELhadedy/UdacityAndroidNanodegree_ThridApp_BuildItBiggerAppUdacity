package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import static com.udacity.gradle.builditbigger.builditbigger.AdDisplay.getAdFullBanner;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.PostExecute {
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
         progressBar = findViewById(R.id.progressbar);
                new EndpointsAsyncTask( progressBar,this).execute(new Pair<Context, String>(this, "Manfred"));

    }


    @Override
    public void onPostExecute(String result) {
        getAdFullBanner(progressBar,this, result);

    }


}
