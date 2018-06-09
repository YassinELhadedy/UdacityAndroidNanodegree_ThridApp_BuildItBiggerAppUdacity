package com.udacity.gradle.builditbigger.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myandroidlib.JokeDisplayActivity;


/**
 * Created by yassin on 3/13/18.
 */

public class AdDisplay {
    public static void getAdView(View view){

    }
    public static void getAdFullBanner(final ProgressBar progressBar, final Context context, final String result){
      progressBar.setVisibility(View.GONE);
      startJokeDisplayActivity(context,result);
    }
    private static void startJokeDisplayActivity(Context context, String mResult) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, mResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
