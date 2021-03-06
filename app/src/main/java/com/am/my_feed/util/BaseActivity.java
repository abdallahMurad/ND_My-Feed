package com.am.my_feed.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.am.my_feed.network.APIClient;
import com.am.my_feed.network.ApiRequests;

public class BaseActivity extends AppCompatActivity {
    protected ApiRequests apiService = APIClient.getClient().create(ApiRequests.class);

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * @return true if the device is connect to wifi network , false if NOT
     */
    protected boolean isConnectedToWifi() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null
                ? connectivityManager.getActiveNetworkInfo()
                : null;
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }


}
