package com.superhero.superhero;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.amazonaws.mobileconnectors.apigateway.ApiRequest;
import com.superhero.clientsdk.HelpApiClient;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final EditText titleEntered = findViewById(R.id.title_entered);
        final HelpActivity this_ = this;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            this_.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(this_.getBaseContext(), "Your request couldn't be submitted", Toast.LENGTH_LONG).show();
                                }
                            });


                            ApiClientFactory factory = new ApiClientFactory();
                            HelpApiClient client = factory.build(HelpApiClient.class);
                            ApiRequest request = new ApiRequest();
                            request.withHttpMethod(HttpMethodName.POST);
                            request.addHeader("Test", titleEntered.getText().toString());
                            request.withPath("/");
                            client.execute(request);
                        } catch (Throwable e) {
                            e.printStackTrace();

                        }
                    }
                });

                thread.start();

            }
        });
    }

}
