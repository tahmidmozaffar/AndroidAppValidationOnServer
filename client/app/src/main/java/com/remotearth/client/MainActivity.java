package com.remotearth.client;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://10.0.2.2:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeHttpCall();
            }
        });
    }

    private void makeHttpCall() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestHeaders requestHeaders = new RequestHeaders();
        requestHeaders.put("signature", Utils.getAppSignature(this).trim());
        client.post(BASE_URL + "/books", requestHeaders, null, "", new TextHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Headers headers, String response) {
                        Log.d("RESPONSE", response);
                    }

                    @Override
                    public void onFailure(int statusCode, Headers headers, String errorResponse, Throwable t) {
                        Log.e("ERROR", errorResponse);
                    }
                }
        );
    }
}
