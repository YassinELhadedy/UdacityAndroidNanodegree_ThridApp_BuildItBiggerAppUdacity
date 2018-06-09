package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;



public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private PostExecute fetchdata;
    @SuppressLint("StaticFieldLeak")

    private String mResult;
    @SuppressLint("StaticFieldLeak")
    private ProgressBar mProgressBar;

    EndpointsAsyncTask( ProgressBar progressBar,PostExecute fetchdata) {
        this.mProgressBar = progressBar;
        this.fetchdata = fetchdata;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }


    @SafeVarargs
    @Override
    protected final String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }



        try {

            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            Log.e("Jokes", e.getMessage(), e);

            return null;
        }
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        fetchdata.onPostExecute(result);


    }



    interface PostExecute{
        void onPostExecute(String result);
    }
}
