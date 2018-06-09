package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;


public class EmptyStringTest extends AndroidTestCase {

    private static final String LOG_TAG = "EmptyStringTest";

    @SuppressWarnings("unchecked")
    public void test() {


        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}
